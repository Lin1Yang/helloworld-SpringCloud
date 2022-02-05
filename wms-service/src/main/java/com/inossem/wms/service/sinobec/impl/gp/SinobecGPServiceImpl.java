package com.inossem.wms.service.sinobec.impl.gp;

import java.math.BigDecimal;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;

import com.inossem.wms.dao.dic.DicMaterialMapper;
import com.inossem.wms.dao.rel.RelUnitMapper;
import com.inossem.wms.model.dic.DicMaterial;
import com.inossem.wms.model.rel.RelUnit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.inossem.wms.co.dic.DicMaterialInfoCo;
import com.inossem.wms.common.exception.WMSException;
import com.inossem.wms.common.util.UtilConst;
import com.inossem.wms.common.util.UtilObject;
import com.inossem.wms.common.util.UtilREST;
import com.inossem.wms.constant.Const;
import com.inossem.wms.dao.sinobec.gp.SinobecBizInputGPMapper;
import com.inossem.wms.dao.sinobec.gp.SinobecBizOutputGpMapper;
import com.inossem.wms.dao.sinobec.gp.SinobecBizStockGpMapper;
import com.inossem.wms.enums.EnumPoType;
import com.inossem.wms.enums.EnumReceiptType;
import com.inossem.wms.enums.EnumReturnCode;
import com.inossem.wms.model.dic.DicCorp;
import com.inossem.wms.model.sinobec.SinobecIpasToken;
import com.inossem.wms.model.sinobec.gp.SinobecBizInputGP;
import com.inossem.wms.model.sinobec.gp.SinobecBizOutputGp;
import com.inossem.wms.model.sinobec.gp.SinobecBizStockGp;
import com.inossem.wms.service.common.ICacheCommonService;
import com.inossem.wms.service.common.IDictionaryService;
import com.inossem.wms.service.sinobec.gp.ISinobecGPService;


@Service
public class SinobecGPServiceImpl implements ISinobecGPService {
	
	@Value("${ipas.token-time}")
	protected Long IpasTokenTime;

	@Autowired
	private SinobecBizInputGPMapper inputGPDao;
	
	@Autowired
	private SinobecBizOutputGpMapper outputGPDao;
	
	@Autowired
	private SinobecBizStockGpMapper stockGPDao;

	@Autowired
	private DicMaterialMapper dicMaterialDAO;

	@Autowired
	private RelUnitMapper relUnitDao;

	@Autowired
	private IDictionaryService dictionaryService;
	
	
	@Autowired
    protected ICacheCommonService cache;

	@Override
	public String resetToken() {

		JSONObject tokenParam = new JSONObject();
		tokenParam.put("username", "user1");
		tokenParam.put("password", "123456");
		String token = null;
		try {
			JSONObject tokenJson = UtilREST.executePostJSONTimeOut(UtilConst.getInstance().getErpUrl() + "getToken",
					tokenParam, 3);
			token = tokenJson.getString("body");
			if (StringUtils.hasText(token)) {
				SinobecIpasToken ipasToken = new SinobecIpasToken();
				ipasToken.setToken(token);
				ipasToken.setTokenTime(System.currentTimeMillis());
				cache.delete(Const.CACHE_IPAS_TOKEN);
				cache.put(Const.CACHE_IPAS_TOKEN, Const.CACHE_IPAS_TOKEN,ipasToken);
				
				return token;
			} else {
				throw new WMSException(EnumReturnCode.RETURN_CODE_SINOBEC_GET_GP_TOKEN_FAILED);
			}

		} catch (Exception e) {
			throw new WMSException(EnumReturnCode.RETURN_CODE_SINOBEC_GET_GP_TOKEN_FAILED);
		}
	}

	@Override
	public String getAndSetTokenifEmpty() {
		SinobecIpasToken ipasToken = (SinobecIpasToken) cache.get(Const.CACHE_IPAS_TOKEN,Const.CACHE_IPAS_TOKEN);
		if(ipasToken == null){
			return resetToken();
		}
		Long tokenTime = ipasToken.getTokenTime();
		String token = ipasToken.getToken();
		Long currentTiem = System.currentTimeMillis();
		
		System.out.println(currentTiem-tokenTime);
		
		if(currentTiem-tokenTime>IpasTokenTime){
			// 超时  重新获取TOKEN
			token = resetToken();
		}
		
		return token;
	}

	@Override
	public Integer changeCorp(){
		return stockGPDao.changeCorp();
	}

	@Override
	public Integer synPoreceive(String ShippingRef) {
		// 同步  采购  退货  GP
		// 根据公司 同步
		Map<String, DicCorp> corpMap = dictionaryService.getAllCorpCache();
		JSONObject GP = null;
		Integer result = 0;
		//corpMap.put("ZTest", new DicCorp());
		for (String corpCode : corpMap.keySet()) {
			JSONObject GPParam = new JSONObject();
			GPParam.put("CompanyCode", corpCode);
			if (StringUtils.hasText(ShippingRef)) {
				GPParam.put("ShippingRef", ShippingRef);
			}
			GPParam.put("Authorization", getAndSetTokenifEmpty());
			try {
				GP = UtilREST.executePostJSONTimeOut(UtilConst.getInstance().getErpUrl() + "poreceive",
						GPParam, 3);
			} catch (Exception e) {
				
				e.printStackTrace();

			}
			if ("200".equals(GP.get("code"))) {

				JSONObject body = GP.getJSONObject("body");
				JSONObject pocommand = body.getJSONObject("pocommand");
				if (pocommand.size() == 0) {
					continue;
				}
				JSONArray POInfoAry = pocommand.getJSONArray("POInfo");
				List<SinobecBizInputGP> inputList = JSONObject.parseArray(POInfoAry.toJSONString(),
						SinobecBizInputGP.class);
				List<SinobecBizInputGP> insertList = new ArrayList<SinobecBizInputGP>();
				for (SinobecBizInputGP gp : inputList) {
					gp.setCorpCode(GPParam.getString("CompanyCode"));
					gp.setUnitCode(gp.getInWhCode());
					if (EnumPoType.SINOBEC_INPUT_PURCHASE.getValue().equals(gp.getPoType())) {
						gp.setReceiptType(EnumReceiptType.SINOBEC_INPUT_PURCHASE.getValue());
					} else if (EnumPoType.SINOBEC_INPUT_RETURN.getValue().equals(gp.getPoType())) {
						gp.setReceiptType(EnumReceiptType.SINOBEC_INPUT_CUSTOMER_RETURN.getValue());
					}
					/*StringBuffer bundleBuffer = new StringBuffer();
					bundleBuffer.append(gp.getShippingRef()).append("-").append(gp.getHeatCode()).append("-")
							.append(gp.getSkidCode());
					gp.setBundleCode(bundleBuffer.toString());*/
					gp.setBundleCode(gp.getLotNumb());
					gp.setItemNumb(gp.getMatCode());
					if (gp.getReceiptUnitCode() == null) {
						gp.setReceiptUnitCode("PCS");
					}
					gp.setPoRid(Const.STRING_EMPTY);
					insertList.add(gp);
					try {
						if (insertList.size() >= 500) {
							result += inputGPDao.insertList(insertList);
							insertList.clear();
						}
					} catch (Exception e) {
						insertList.clear();
						e.printStackTrace();
					}
				}
				try {
					if (!CollectionUtils.isEmpty(insertList)) {
						result += inputGPDao.insertList(insertList);
						insertList.clear();
					}
				} catch (Exception e) {
					insertList.clear();
					e.printStackTrace();
				}
			}
		}
		return result;
	}

	@Override
	public Integer synSodelivery(String SOPNumber) {
		// 同步  SO  GP
		// 根据公司 同步
		Map<String, DicCorp> corpMap = dictionaryService.getAllCorpCache();
		JSONObject GP = null;
		Integer result = 0;
		for (String corpCode : corpMap.keySet()) {
			JSONObject GPParam = new JSONObject();
			GPParam.put("CompanyCode", corpCode);
			if(StringUtils.hasText(SOPNumber)){
				GPParam.put("SOPNumber", SOPNumber);
			}
			GPParam.put("Authorization", getAndSetTokenifEmpty());
			try {
				GP = UtilREST.executePostJSONTimeOut(UtilConst.getInstance().getErpUrl() + "sodelivery",
						GPParam, 3);
				} catch (Exception e) {
					e.printStackTrace();
				}
			if ("200".equals(GP.get("code"))) {
				JSONObject body = GP.getJSONObject("body");
				JSONObject socommand = body.getJSONObject("socommand");
				if (socommand.size() == 0) {
					continue;
				}
				JSONArray SoInfoAry = socommand.getJSONArray("SoInfo");
				List<SinobecBizOutputGp> outputList = JSONObject.parseArray(SoInfoAry.toJSONString(), SinobecBizOutputGp.class);

				List<SinobecBizOutputGp> insertList = new ArrayList<SinobecBizOutputGp>();
				for (SinobecBizOutputGp gp : outputList) {
					gp.setCorpCode(GPParam.getString("CompanyCode"));
					if (EnumPoType.SINOBEC_INPUT_RETURN.getValue().equals(gp.getSoType())) {
						gp.setReceiptType(EnumReceiptType.SINOBEC_OUTPUT_VENDOR_RETURN.getValue());
					}else  {
						gp.setReceiptType(EnumReceiptType.SINOBEC_OUTPUT_SALE.getValue());
					}


					
					
					/*StringBuffer bundleBuffer = new StringBuffer();
					bundleBuffer.append(gp.getShippingRef()).append("-").append(gp.getHeatCode()).append("-").append(gp.getSkidCode());
					gp.setBundleCode(bundleBuffer.toString());*/
					gp.setBundleCode(gp.getLotNumb());
					gp.setItemNumb(gp.getMatCode());
					if (gp.getReceiptUnitCode() == null) {
						gp.setReceiptUnitCode("PCS");
					}


					gp.setSoRid(Const.STRING_EMPTY);
					insertList.add(gp);
					try {
						if (insertList.size() >= 500) {
							result += outputGPDao.insertList(insertList);
							insertList.clear();
						}
					} catch (Exception e) {
						insertList.clear();
						e.printStackTrace();
					}
				}
				try {
					if (!CollectionUtils.isEmpty(insertList)) {
						result += outputGPDao.insertList(insertList);
						insertList.clear();
					}
				} catch (Exception e) {
					insertList.clear();
					e.printStackTrace();
				}
			}
		}
		return result;
	}

	@Override
	public Integer synTransferin(String DocumentCode) {
		// 同步  转入
		// 根据公司 同步
		Map<String, DicCorp> corpMap = dictionaryService.getAllCorpCache();
		JSONObject GP = null;
		Integer result = 0;
		for (String corpCode : corpMap.keySet()) {
			JSONObject GPParam = new JSONObject();
			GPParam.put("CompanyCode", corpCode);
			if(StringUtils.hasText(DocumentCode)){
				GPParam.put("DocumentCode", DocumentCode);
			}
			GPParam.put("Authorization", getAndSetTokenifEmpty());
			try {
				GP = UtilREST.executePostJSONTimeOut(UtilConst.getInstance().getErpUrl() + "transferin",
						GPParam, 3);
			}catch (Exception e) {
				e.printStackTrace();
			}
			if ("200".equals(GP.get("code"))) {
				JSONObject body = GP.getJSONObject("body");
				JSONObject transferincommand = body.getJSONObject("transferincommand");
				if (transferincommand.size() == 0) {
					continue;
				}
				JSONArray TransferInfoAry = transferincommand.getJSONArray("TransferInfo");
				System.out.println(TransferInfoAry.get(0));
				List<SinobecBizInputGP> inputList = JSONObject.parseArray(TransferInfoAry.toJSONString(),
						SinobecBizInputGP.class);

				List<SinobecBizInputGP> insertList = new ArrayList<SinobecBizInputGP>();
				for (SinobecBizInputGP gp : inputList) {
					gp.setCorpCode(GPParam.getString("CompanyCode"));

					gp.setReceiptType(EnumReceiptType.SINOBEC_INPUT_TRANSFER_IN.getValue());
					gp.setWhCode(gp.getToWhCode());
					gp.setStockStatus(gp.getToStockStatus());
					/*StringBuffer bundleBuffer = new StringBuffer();
					bundleBuffer.append(gp.getShippingRef()).append("-").append(gp.getHeatCode()).append("-")
							.append(gp.getSkidCode());
					gp.setBundleCode(bundleBuffer.toString());*/
					gp.setBundleCode(gp.getLotNumb());
					gp.setItemNumb(gp.getMatCode());
					if (gp.getReceiptUnitCode() == null) {
						gp.setReceiptUnitCode("PCS");
					}
					gp.setPoRid(Const.STRING_EMPTY);
					insertList.add(gp);
					try {
						if (insertList.size() >= 500) {
							result += inputGPDao.insertList(insertList);
							insertList.clear();
						}
					} catch (Exception e) {
						insertList.clear();
						e.printStackTrace();
					}
				}
				try {
					if (!CollectionUtils.isEmpty(insertList)) {
						result += inputGPDao.insertList(insertList);
						insertList.clear();
					}
				} catch (Exception e) {
					insertList.clear();
					e.printStackTrace();
				}
			}
		}
		return result;
	}

	@Override
	public Integer synTransferout(String DocumentCode) {
		// 同步  转出  GP
		// 根据公司 同步
		Map<String, DicCorp> corpMap = dictionaryService.getAllCorpCache();
		JSONObject GP = null;
		Integer result = 0;
		for (String corpCode : corpMap.keySet()) {
			JSONObject GPParam = new JSONObject();
			GPParam.put("CompanyCode", corpCode);
			if(StringUtils.hasText(DocumentCode)){
				GPParam.put("DocumentCode", DocumentCode);
			}
			GPParam.put("Authorization", getAndSetTokenifEmpty());
			try {
				GP = UtilREST.executePostJSONTimeOut(UtilConst.getInstance().getErpUrl() + "transferout",
						GPParam, 3);
			}catch (Exception e) {
				e.printStackTrace();
			}
			if ("200".equals(GP.get("code"))) {
				JSONObject body = GP.getJSONObject("body");
				JSONObject transfercommand = body.getJSONObject("transferoutcommand");
				if (transfercommand.size() == 0) {
					continue;
				}
				JSONArray TransferInfo = transfercommand.getJSONArray("TransferInfo");
				List<SinobecBizOutputGp> outputList = JSONObject.parseArray(TransferInfo.toJSONString(), SinobecBizOutputGp.class);

				List<SinobecBizOutputGp> insertList = new ArrayList<SinobecBizOutputGp>();
				for (SinobecBizOutputGp gp : outputList) {
					gp.setCorpCode(GPParam.getString("CompanyCode"));
					gp.setReceiptType(EnumReceiptType.SINOBEC_OUTPUT_TRANSFER_OUT.getValue());
					gp.setWhCode(gp.getFormWhCode());
					gp.setStockStatus(gp.getFromStockStatus());
					/*StringBuffer bundleBuffer = new StringBuffer();
					bundleBuffer.append(gp.getShippingRef()).append("-").append(gp.getHeatCode()).append("-").append(gp.getSkidCode());
					gp.setBundleCode(bundleBuffer.toString());*/
					gp.setBundleCode(gp.getLotNumb());
					gp.setItemNumb(gp.getMatCode());
					if (gp.getReceiptUnitCode() == null) {
						gp.setReceiptUnitCode("PCS");
					}
					gp.setSoRid(Const.STRING_EMPTY);
					insertList.add(gp);
					try {
						if (insertList.size() >= 500) {
							result += outputGPDao.insertList(insertList);
							insertList.clear();
						}
					} catch (Exception e) {
						insertList.clear();
						e.printStackTrace();
					}
				}
				try {
					if (!CollectionUtils.isEmpty(insertList)) {
						result += outputGPDao.insertList(insertList);
						insertList.clear();
					}
				} catch (Exception e) {
					insertList.clear();
					e.printStackTrace();
				}
			}
		}
		return result;
	}

	@Override
	public Integer synAdjustmentin(String DocumentCode) {
		// 同步  分包入
		// 根据公司 同步
		Map<String, DicCorp> corpMap = dictionaryService.getAllCorpCache();
		JSONObject GP = null;
		Integer result = 0;
		for (String corpCode : corpMap.keySet()) {
			JSONObject GPParam = new JSONObject();
			GPParam.put("CompanyCode", corpCode);
			if(StringUtils.hasText(DocumentCode)){
				GPParam.put("DocumentCode", DocumentCode);
			}
			GPParam.put("Authorization", getAndSetTokenifEmpty());
			try {
				GP = UtilREST.executePostJSONTimeOut(UtilConst.getInstance().getErpUrl() + "adjustmentin",
						GPParam, 3);
			}catch (Exception e) {
				e.printStackTrace();
			}
			if ("200".equals(GP.get("code"))) {
				JSONObject body = GP.getJSONObject("body");
				JSONObject adjustmentincommand = body.getJSONObject("adjustmentincommand");
				if (adjustmentincommand.size() == 0) {
					continue;
				}
				JSONArray TransferInfoAry = adjustmentincommand.getJSONArray("TransferInfo");
				System.out.println(TransferInfoAry.get(0));
				List<SinobecBizInputGP> inputList = JSONObject.parseArray(TransferInfoAry.toJSONString(),
						SinobecBizInputGP.class);

				List<SinobecBizInputGP> insertList = new ArrayList<SinobecBizInputGP>();
				for (SinobecBizInputGP gp : inputList) {
					gp.setCorpCode(GPParam.getString("CompanyCode"));

					gp.setReceiptType(EnumReceiptType.SINOBEC_INPUT_ADJUSTMENT_IN.getValue());
					gp.setWhCode(gp.getToWhCode());
					gp.setStockStatus(gp.getToStockStatus());
					/*StringBuffer bundleBuffer = new StringBuffer();
					bundleBuffer.append(gp.getShippingRef()).append("-").append(gp.getHeatCode()).append("-")
							.append(gp.getSkidCode());
					gp.setBundleCode(bundleBuffer.toString());*/
					gp.setBundleCode(gp.getLotNumb());
					gp.setItemNumb(gp.getMatCode());
					if (gp.getReceiptUnitCode() == null) {
						gp.setReceiptUnitCode("PCS");
					}
					gp.setPoRid(Const.STRING_EMPTY);
					insertList.add(gp);
					try {
						if (insertList.size() >= 500) {
							result += inputGPDao.insertList(insertList);
							insertList.clear();
						}
					} catch (Exception e) {
						inputList.clear();
						e.printStackTrace();
					}
				}
				try {
					if (!CollectionUtils.isEmpty(insertList)) {
						result += inputGPDao.insertList(insertList);
						insertList.clear();
					}
				} catch (Exception e) {
					inputList.clear();
					e.printStackTrace();
				}
			}
		}
		return result;
	}

	@Override
	public Integer synAdjustmentout(String DocumentCode) {
		// 同步  分包出  GP
		// 根据公司 同步
		Map<String, DicCorp> corpMap = dictionaryService.getAllCorpCache();
		JSONObject GP = null;
		Integer result = 0;
		for (String corpCode : corpMap.keySet()) {
			JSONObject GPParam = new JSONObject();
			GPParam.put("CompanyCode", corpCode);
			if(StringUtils.hasText(DocumentCode)){
				GPParam.put("DocumentCode", DocumentCode);
			}
			GPParam.put("Authorization", getAndSetTokenifEmpty());
			try {
				GP = UtilREST.executePostJSONTimeOut(UtilConst.getInstance().getErpUrl() + "adjustmentout",
						GPParam, 3);
			}catch (Exception e) {
				e.printStackTrace();
			}
			if ("200".equals(GP.get("code"))) {
				JSONObject body = GP.getJSONObject("body");
				JSONObject adjustmentoutcommand = body.getJSONObject("adjustmentoutcommand");
				if (adjustmentoutcommand.size() == 0) {
					continue;
				}
				JSONArray TransferInfo = adjustmentoutcommand.getJSONArray("TransferInfo");
				List<SinobecBizOutputGp> outputList = JSONObject.parseArray(TransferInfo.toJSONString(), SinobecBizOutputGp.class);

				List<SinobecBizOutputGp> insertList = new ArrayList<SinobecBizOutputGp>();
				for (SinobecBizOutputGp gp : outputList) {
					gp.setCorpCode(GPParam.getString("CompanyCode"));
					gp.setReceiptType(EnumReceiptType.SINOBEC_OUTPUT_COMMISSIONED_PROCESSING.getValue());
					gp.setWhCode(gp.getFormWhCode());
					gp.setStockStatus(gp.getFromStockStatus());
					/*StringBuffer bundleBuffer = new StringBuffer();
					bundleBuffer.append(gp.getShippingRef()).append("-").append(gp.getHeatCode()).append("-").append(gp.getSkidCode());
					gp.setBundleCode(bundleBuffer.toString());*/
					gp.setBundleCode(gp.getLotNumb());
					gp.setItemNumb(gp.getMatCode());
					if (gp.getReceiptUnitCode() == null) {
						gp.setReceiptUnitCode("PCS");
					}
					gp.setSoRid(Const.STRING_EMPTY);
					insertList.add(gp);
					try {
						if (insertList.size() >= 500) {
							result += outputGPDao.insertList(insertList);
							insertList.clear();
						}
					} catch (Exception e) {
						insertList.clear();
						e.printStackTrace();
					}
				}
				try {
					if (!CollectionUtils.isEmpty(insertList)) {
						result += outputGPDao.insertList(insertList);
						insertList.clear();
					}
				} catch (Exception e) {
					insertList.clear();
					e.printStackTrace();
				}
			}
		}
		return result;
	}

	@Override
	public Integer synGpinventory(String lotNumb) {
		// 删除库存
		stockGPDao.deleteAll();
		// 根据公司 同步
		Map<String, DicCorp> corpMap = dictionaryService.getAllCorpCache();
		JSONObject GP = null;
		Integer result = 0;
		for (String corpCode : corpMap.keySet()) {
			JSONObject GPParam = new JSONObject();
			GPParam.put("CompanyCode", corpCode);
			if(StringUtils.hasText(lotNumb)){
				GPParam.put("lotNumb", lotNumb);
			}
			GPParam.put("Authorization", getAndSetTokenifEmpty());
			try {
				GP = UtilREST.executePostJSONTimeOut(UtilConst.getInstance().getErpUrl() + "gpinventory",
						GPParam, 3);
			}catch (Exception e) {
				e.printStackTrace();
			}
			if ("200".equals(GP.get("code"))) {
				JSONObject body = GP.getJSONObject("body");
				JSONObject gpinventorycommand = body.getJSONObject("gpinventorycommand");
				if (gpinventorycommand.size() == 0) {
					continue;
				}
				JSONArray TransferInfoInfoAry = gpinventorycommand.getJSONArray("TransferInfo");
				List<SinobecBizStockGp> gpList = JSONObject.parseArray(TransferInfoInfoAry.toJSONString(),
						SinobecBizStockGp.class);

				List<SinobecBizStockGp> insertList = new ArrayList<SinobecBizStockGp>();
				for (SinobecBizStockGp gp : gpList) {
					gp.setCorpCode(GPParam.getString("CompanyCode"));
					

					/*StringBuffer bundleBuffer = new StringBuffer();
					bundleBuffer.append(gp.getShippingRef()).append("-").append(gp.getHeatCode()).append("-")
							.append(gp.getSkidCode());
					gp.setBundleCode(bundleBuffer.toString());*/
					gp.setBundleCode(gp.getLotNumb());
					gp.setItemNumb(gp.getMatCode());
					gp.setItemDesc(gp.getMatName());
					if (gp.getWeightUnitCode() == null) {
						gp.setWeightUnitCode("LBS");
					}
					if (gp.getReceiptUnitCode() == null) {
						gp.setReceiptUnitCode("PCS");
					}
					if (gp.getReceiptQty() == null) {
						gp.setReceiptQty(BigDecimal.ZERO);
					}
					insertList.add(gp);
					try {
						if (insertList.size() >= 500) {
							result += stockGPDao.insertList(insertList);
							insertList.clear();
						}
					} catch (Exception e) {
						insertList.clear();
						e.printStackTrace();
					}
				}
				try {
					if (!CollectionUtils.isEmpty(insertList)) {
						result += stockGPDao.insertList(insertList);
						insertList.clear();
					}
				} catch (Exception e) {
					insertList.clear();
					e.printStackTrace();
				}
			}
		}
		return result;
	}
	
	public void synInput(){
		this.synPoreceive(null);
		this.synTransferin(null);
		this.synAdjustmentin(null);
	}
	
	public void synOutput(){
		this.synSodelivery(null);
		this.synTransferout(null);
		this.synAdjustmentout(null);
	}
	
	public void synInventory(){
		this.synGpinventory(null);
	}

	public void synMat() {
		this.synMaterial("",null);
	}

	@Override
	public void  synAll() {
		this.synMaterial("",null);
//		this.synPoreceive(null);
//		this.synTransferin(null);
//		this.synAdjustmentin(null);
//		this.synSodelivery(null);
//		this.synTransferout(null);
//		this.synAdjustmentout(null);
//		this.synGpinventory("");
	}

	@Override
	public Integer synMaterial(String Date,List<String> matCodeList) {
		//物料同步
		//查询公司
		Map<String, DicCorp> corpMap = dictionaryService.getAllCorpCache();
		JSONObject GP = null;
		Integer result = 0;
		for (String corpCode : corpMap.keySet()) {
			JSONObject GPParam = new JSONObject();
			GPParam.put("CompanyCode", corpCode);
			if(StringUtils.hasText(Date)){
				GPParam.put("Date", Date);
			}
			GPParam.put("Authorization", getAndSetTokenifEmpty());
			try {
				GP = UtilREST.executePostJSONTimeOut(UtilConst.getInstance().getErpUrl() + "material",
						GPParam, 3);
			}catch (Exception e) {
				e.printStackTrace();
			}
			if ("200".equals(GP.get("code"))) {
				JSONObject body = GP.getJSONObject("body");
				JSONObject materialcommand = body.getJSONObject("materialcommand");
				if (materialcommand.size() == 0) {
					continue;
				}
				JSONArray MaterialAry = materialcommand.getJSONArray("Material");
/*			List<DicMaterial> dicList = JSONObject.parseArray(MaterialAry.toJSONString(),
					DicMaterial.class);*/
				List<DicMaterial> insertMatList = new ArrayList<>();
				List<RelUnit> insertUnitList = new ArrayList<>();
				DateFormat df = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
				SimpleDateFormat df1 = new SimpleDateFormat("EEE MMM dd HH:mm:ss Z yyyy", Locale.UK);
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
				for (int i = 0; i < MaterialAry.size(); i++) {
					JSONObject matObj = MaterialAry.getJSONObject(i);
					DicMaterial matJavaObj = new DicMaterial();
					RelUnit relunit = new RelUnit();
					matJavaObj.setMatCode(UtilObject.getStringOrEmpty(matObj.get("item_numb")));
					matJavaObj.setMatName(UtilObject.getStringOrEmpty(matObj.get("Item_desc")));
					matJavaObj.setUnitCode("PCS");
					matJavaObj.setUnitWeight(UtilObject.getStringOrEmpty(matObj.get("weight_unit_code")));
					String matType = UtilObject.getStringOrEmpty(matObj.get("Item_type"));
					matJavaObj.setMatGroupCode(matType);
					if ("EX".equals(matType)) {
						matJavaObj.setMatTypeCode("MR, WR");
					} else if ("SH".equals(matType) || "BI".equals(matType) || "CO".equals(matType)) {
						matJavaObj.setMatTypeCode("FL");
					} else {
						matJavaObj.setMatTypeCode("FL");
					}

					insertMatList.add(matJavaObj);

					relunit.setFtyCode("");
					relunit.setMatCode(UtilObject.getStringOrEmpty(matObj.get("item_numb")));
					relunit.setSourceUnitCode(UtilObject.getStringOrEmpty(matObj.get("weight_unit_code")));
					relunit.setTargetUnitCode("LBS");
					relunit.setSourceQty(new BigDecimal("1.000"));
					relunit.setTargetQty(UtilObject.getBigDecimal(matObj.get("Convert_ratio")));
					relunit.setIsDelete((byte) 0);
					insertUnitList.add(relunit);
					try {
						if (insertMatList.size() >= 500) {
							result += dicMaterialDAO.insertBatchDicMaterialInfoCo(insertMatList);
							relUnitDao.insertOrUpdateList(insertUnitList);
							insertMatList.clear();
							insertUnitList.clear();
						}
					} catch (Exception e) {
						insertMatList.clear();
						insertUnitList.clear();
						e.printStackTrace();
					}
				}
				try {
					if (!CollectionUtils.isEmpty(insertMatList)) {
						result += dicMaterialDAO.insertBatchDicMaterialInfoCo(insertMatList);
						relUnitDao.insertOrUpdateList(insertUnitList);
						insertMatList.clear();
						insertUnitList.clear();
					}
				} catch (Exception e) {
					insertMatList.clear();
					insertUnitList.clear();
					e.printStackTrace();
				}
			}
		}
		return result;
	}

}
