package com.inossem.wms.service.stocktake.impl;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.inossem.wms.co.biz.BizStockTakeCo;
import com.inossem.wms.co.dic.DicWhStorageBinListCo;
import com.inossem.wms.co.sys.SysUserInfoCo;
import com.inossem.wms.common.auth.CurrentUser;
import com.inossem.wms.common.exception.WMSException;
import com.inossem.wms.common.util.UtilBean;
import com.inossem.wms.common.util.UtilObject;
import com.inossem.wms.common.util.UtilText;
import com.inossem.wms.constant.Const;
import com.inossem.wms.dao.dic.DicFreezeReasonMapper;
import com.inossem.wms.dao.dic.DicWhStorageBinMapper;
import com.inossem.wms.dao.sinobec.SinobecStockMapper;
import com.inossem.wms.dao.sinobec.gp.CountOrderFromSapMapper;
import com.inossem.wms.dao.sinobec.take.SinobecBizStockTakeMapper;
import com.inossem.wms.dao.sinobec.take.SinobecBizStockTakeMatMapper;
import com.inossem.wms.dao.sys.SysUserMapper;
import com.inossem.wms.enums.EnumDebitCredit;
import com.inossem.wms.enums.EnumEnable;
import com.inossem.wms.enums.EnumIsFreeze;
import com.inossem.wms.enums.EnumReceiptOperationType;
import com.inossem.wms.enums.EnumReceiptStatus;
import com.inossem.wms.enums.EnumReceiptType;
import com.inossem.wms.enums.EnumReturnCode;
import com.inossem.wms.enums.EnumSequenceCode;
import com.inossem.wms.enums.EnumStockTakeMode;
import com.inossem.wms.enums.EnumStockTakeResult;
import com.inossem.wms.enums.EnumStockTakeType;
import com.inossem.wms.insmovetype.stocktake.SinobecInsTakeMoveType;
import com.inossem.wms.model.dic.DicFreezeReason;
import com.inossem.wms.model.sinobec.dic.SinobecDicBundleInfo;
import com.inossem.wms.model.sinobec.stock.SinobecStockVo;
import com.inossem.wms.model.sinobec.take.SinobecBizStockTake;
import com.inossem.wms.model.sinobec.take.SinobecBizStockTakeMat;
import com.inossem.wms.service.common.ICommonService;
import com.inossem.wms.service.sinobec.common.ISinobecBundleCommonService;
import com.inossem.wms.service.sinobec.common.ISinobecStockCommonService;
import com.inossem.wms.service.stocktake.IBizStockTakeService;
import com.inossem.wms.vo.sinobec.SinobecInsMoveTypeVo;
import com.inossem.wms.vo.dic.DicWhStorageBinVo;
import com.inossem.wms.vo.sys.SysUserVo;
import com.inossem.wms.vo.take.BizStockTakeDataVo;
import com.inossem.wms.vo.take.BizStockTakeHeadVo;
import com.inossem.wms.vo.take.BizStockTakeItemVo;
import com.inossem.wms.vo.take.BizStockTakeMatDataVo;
import com.inossem.wms.vo.take.BizStockTakeMatHeadVo;
import com.inossem.wms.vo.take.BizStockTakeMatItemVo;

import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;


@Service
public class BizStockTakeServiceImpl implements IBizStockTakeService {

	@Autowired
	protected ICommonService commonServiceSubImpl;// ???????????????

	@Autowired
	protected SinobecStockMapper sinobecStockDao;// ????????????

	@Autowired
	protected DicWhStorageBinMapper dicWhStorageBinDao;// ??????Dao

	@Autowired
	protected SysUserMapper sysUserDao;// ????????????Dao

	@Autowired
	protected DicFreezeReasonMapper dicFreezeReasonDao;// ????????????Dao

	@Autowired
	protected SinobecBizStockTakeMapper SinobecBizStockTakeDao;

	@Autowired
	protected SinobecBizStockTakeMatMapper SinobecBizStockTakeMatDao;

	@Autowired
	private ISinobecBundleCommonService bundleService;

	@Autowired
	private SinobecInsTakeMoveType insTakeMoveType;

	@Autowired
	private ISinobecStockCommonService stockCommonServiceImpl;
	
	@Autowired
	private CountOrderFromSapMapper countOrderFromSapMapper;
	
	/**
	 * ??????????????????(??????take???????????????)
	 */
	@Override
	public List<BizStockTakeHeadVo> getStockTakeList(CurrentUser cUser, BizStockTakeCo co, String langCode) {

		List <BizStockTakeHeadVo> stocktakeList = SinobecBizStockTakeDao.getStockTakeListOnPaging(co);
		for(BizStockTakeHeadVo vo : stocktakeList) {
			// ????????????????????????
			if(EnumStockTakeType.STOCK_TAKE_TYPE_DYNAMIC.getName() == vo.getStockTakeType()) {
				vo.setStockTakeTypeName(UtilText.getNameMessage(langCode, EnumStockTakeType.getEnumName(EnumStockTakeType.STOCK_TAKE_TYPE_DYNAMIC.getName())));
			}else {
				vo.setStockTakeTypeName(UtilText.getNameMessage(langCode, EnumStockTakeType.getEnumName(EnumStockTakeType.STOCK_TAKE_TYPE_CYCLE.getName())));
			}
		}
		return stocktakeList;
	}
	/**
	 * ??????????????????(??????take????????????)
	 */
	@Override
	public List<BizStockTakeItemVo> getStockTakeInfo(String stockTakeCode) {
		BizStockTakeCo bizStockTakeCo = new BizStockTakeCo();
		bizStockTakeCo.setStockTakeCode(stockTakeCode);
		List<BizStockTakeItemVo> itemList = SinobecBizStockTakeDao.getStockTakeInfo(bizStockTakeCo);

		return itemList;
	}
	/**
	 * ??????????????????(?????????????????????????????????)
	 */
	@Override
	public List<BizStockTakeItemVo> getStorageBinList(DicWhStorageBinListCo co) {
		List<BizStockTakeItemVo> takeList = new ArrayList<BizStockTakeItemVo>();
		// ??????????????????
		CurrentUser user = (CurrentUser) SecurityUtils.getSubject().getPrincipal();
		co.setWhCode(user.getCorpCode());
		List<DicWhStorageBinVo> binList = dicWhStorageBinDao.selectWhStorageBinListByZoneAndBin(co);
		for(DicWhStorageBinVo storageBinVo : binList) {
			// ?????????????????????
//			if(commonServiceSubImpl.isDefaultType(storageBinVo.getTypeCode())) {
//				continue;
//			}
			// ?????????????????????????????????????????????
			if(EnumStockTakeType.STOCK_TAKE_TYPE_CYCLE.getName() == co.getStockTakeType()) {
				if(EnumEnable.UNABLE.getValue().equals(storageBinVo.getUsed())) {
					continue;
				}
			}
			BizStockTakeItemVo bizStockTakeItemVo = new BizStockTakeItemVo();
			UtilBean.getBean(storageBinVo, bizStockTakeItemVo);
			bizStockTakeItemVo.setMoveDate(storageBinVo.getStockBinModifyTime());
			bizStockTakeItemVo.setUsed(storageBinVo.getUsed());
		    takeList.add(bizStockTakeItemVo);
		}
		return takeList;
	}
	/**
	 * ???????????????????????????(?????????????????????/?????????)
	 */
	@Override
	@Transactional
	public String saveOrUpdateStockTakeData(BizStockTakeDataVo bizStockTakeDataVo, CurrentUser user) {

		int i = 1;
		List<BizStockTakeItemVo> itemList = bizStockTakeDataVo.getItemList();
		String stockTakeCode = Const.STRING_EMPTY;
		byte status = EnumReceiptStatus.RECEIPT_STATUS_DRAFT.getValue();
		// ???????????????????????????????????????
		if(EnumReceiptOperationType.RECEIPT_OPERATION_SAVE.getValue().equals(bizStockTakeDataVo.getHead().getSaveOrUpdate())) {
			//?????? ????????????????????????????????????
			stockTakeCode = bizStockTakeDataVo.getHead().getStockTakeCode();
			List<BizStockTakeItemVo> takeList = this.getStockTakeInfo(stockTakeCode);
			status = takeList.get(0).getReceiptStatus();
			this.delete(bizStockTakeDataVo.getHead().getStockTakeCode(),user);
		}else {
			//?????? ?????????????????????????????????instock ???????????????sap????????????
			stockTakeCode = commonServiceSubImpl.getNextSequenceValue(EnumSequenceCode.SEQUENCE_TAKE.getValue());
		}

		List<SinobecBizStockTake> itemVoList = new ArrayList<SinobecBizStockTake>();
		for (BizStockTakeItemVo bizStockTakeItemVo : itemList) {
			bizStockTakeItemVo.setStockTakeId(Const.ZERO);
			bizStockTakeItemVo.setStockTakeCode(stockTakeCode);
			bizStockTakeItemVo.setReceiptType(EnumReceiptType.SINOBEC_STOCK_TAKE.getValue());
			if(EnumReceiptStatus.RECEIPT_STATUS_SUBMITTED.getValue().equals(bizStockTakeDataVo.getHead().getReceiptStatus())) {
				bizStockTakeItemVo.setReceiptStatus(bizStockTakeDataVo.getHead().getReceiptStatus());
			}else {
				bizStockTakeItemVo.setReceiptStatus(status);
			}
			bizStockTakeItemVo.setStockTakeRid(UtilObject.getStringOrEmpty(i));
			bizStockTakeItemVo.setStockTakeMode(bizStockTakeDataVo.getHead().getStockTakeMode());
			bizStockTakeItemVo.setStockTakeType(bizStockTakeDataVo.getHead().getStockTakeType());
			bizStockTakeItemVo.setStockTakeDate(bizStockTakeDataVo.getHead().getStockTakeDate());
			bizStockTakeItemVo.setFreezeStockTake(bizStockTakeDataVo.getHead().getFreezeStockTake());

			bizStockTakeItemVo.setItemStatus(EnumReceiptStatus.RECEIPT_STATUS_DRAFT.getValue());

			bizStockTakeItemVo.setCreateUserId(user.getUserId());
			bizStockTakeItemVo.setModifyUserId(user.getUserId());
			bizStockTakeItemVo.setCreateTime(new Date());
			bizStockTakeItemVo.setModifyTime(new Date());
			bizStockTakeItemVo.setDocumentNumber(bizStockTakeDataVo.getDocumentNumber());
			itemVoList.add(bizStockTakeItemVo);
			i++;
		}

		if(!CollectionUtils.isEmpty(itemVoList)) {
			//?????????????????????zone ??? bin ???????????????mat
			SinobecBizStockTakeDao.insertBizStockTake(itemVoList);
		}
		return stockTakeCode;
	}
	/**
	 * ??????????????????(????????????????????????)
	 */
	@Override
	@Transactional
	public void delete(String stockTakeCode, CurrentUser user) throws WMSException {

		SinobecBizStockTakeDao.delete(stockTakeCode);
		BizStockTakeCo co = new BizStockTakeCo();
		co.setStockTakeCode(stockTakeCode);
		SinobecBizStockTakeMatDao.delete(co);

	}


	/**
	 * ??????????????????(?????????????????????????????????)
	 */
	@Override
	public List<BizStockTakeMatItemVo> getStockTakeMatInfo(String stockTakeCode, String count, CurrentUser user) {
		BizStockTakeCo co = new BizStockTakeCo();
		co.setStockTakeCode(stockTakeCode);
		List<BizStockTakeItemVo> takeList = this.getStockTakeInfo(stockTakeCode);

		if(StringUtils.hasText(count) && Const.STRING_ONE.equals(count)) {
			co.setStockTakeUser(String.valueOf(user.getUserCode()));
		}
		List<BizStockTakeMatItemVo> itemList = SinobecBizStockTakeMatDao.getStockTakeMatInfo(co);
		List<BizStockTakeMatItemVo> list = new ArrayList<BizStockTakeMatItemVo>();
		for(BizStockTakeMatItemVo vo : itemList) {
			// ????????????????????????
			if(StringUtils.hasText(count) && (vo.getStockTakeMode() == EnumStockTakeMode.STOCK_TAKE_MODE_BLIND.getName())) {
				vo.setQty(new BigDecimal(Const.ZERO));
			}
			if(StringUtils.hasText(count) && Const.STRING_ONE.equals(count)) {
				vo.setUserId(vo.getCreateUserId());
			}

			list.add(vo);
		}

		return list;
	}
	private static String fetchGroupKey(BizStockTakeMatItemVo item){
	    //return item.getStockTakeCode() +"#"+ item.getExt0()+"#"+item.getExt1();
	    return item.getStockTakeCode();
	}

	public static List<BizStockTakeMatItemVo> getNewList(List<BizStockTakeMatItemVo> oldList) {
		HashMap<String, BizStockTakeMatItemVo> tempMap = new HashMap<String, BizStockTakeMatItemVo>();
		for (BizStockTakeMatItemVo item : oldList) {
			List<String> locationList = new ArrayList<String>();
			String name = item.getStockTakeCode();
			String sku = item.getMatCode();
			String vin = item.getExt0();
			String eng = item.getExt1();
			String M = item.getExt2();
			Byte mode = item.getStockTakeMode();
			Integer createUserId = item.getCreateUserId();
			String takeUser = item.getStockTakeUser();
			String unit = item.getUnitCode();
			String weightUnit = item.getWeightUnitCode();
			String zone = item.getTypeCode();
			String bin = item.getBinCode();
			//List<String> locationList = new ArrayList<String>();
			// containsKey(Object key)???????????????Map?????????????????????????????????????????????????????????true??????????????????false
			// containsValue(Object
			// value)???????????????Map?????????????????????????????????????????????????????????true??????????????????false
			if(M.equals("M")) {//M??????????????????????????????????????????????????????M??????????????????????????????
				if (tempMap.containsKey(sku)) {
					BizStockTakeMatItemVo newItem = new BizStockTakeMatItemVo();
					newItem.setStockTakeCode(name);
					newItem.setStockTakeMode(mode);
					newItem.setExt0(vin);
					newItem.setExt1(eng);
					newItem.setMatCode(sku);
					newItem.setCreateUserId(createUserId);
					newItem.setStockTakeUser(takeUser);
					newItem.setUnitCode(unit);
					newItem.setWeightUnitCode(weightUnit);
					// ????????????key???value
					newItem.setWeightQty(tempMap.get(sku).getWeightQty().add(item.getWeightQty()));
					newItem.setStockTakeQty(tempMap.get(sku).getStockTakeQty().add(item.getStockTakeQty()));
					
					locationList = tempMap.get(sku).getLocationList();
					locationList.add(zone+","+bin);
					newItem.setLocationList(locationList);
					// HashMap?????????key???????????????key??????????????????key?????????value???????????????
					tempMap.put(sku, newItem);
				} else {
					item.getLocationList().add(zone+","+bin);
					tempMap.put(sku, item);
				}
			}else {
				tempMap.put(sku, item);
			}
		}
		List<BizStockTakeMatItemVo> newList = new ArrayList<BizStockTakeMatItemVo>();
		Iterator iter = tempMap.entrySet().iterator();
		while (iter.hasNext()) {
			Map.Entry entry = (Map.Entry) iter.next();
			BizStockTakeMatItemVo newItem = (BizStockTakeMatItemVo)entry.getValue();
			newList.add(newItem);
		}
		return newList;
	}
	
	@Override
	public List<BizStockTakeMatItemVo> getStockTakeMatInfoFromWMSCountForReport( 
			String stockTakeCode, 
			String sapDocNumber, 
			String typeCode, 
			String binCode, 
			String matCode,
			String sDate,
			String eDate,
			String count, 
			CurrentUser user) {
		BizStockTakeCo co = new BizStockTakeCo();
		co.setStockTakeCode(stockTakeCode);
		co.setSapDocNum(sapDocNumber);
		co.setTypeCode(typeCode);
		co.setBinCode(binCode);
		co.setMatCode(matCode);
		co.setsDate(sDate);
		co.seteDate(eDate);
		//List<BizStockTakeItemVo> takeList = this.getStockTakeInfo(stockTakeCode);

		if(StringUtils.hasText(count) && Const.STRING_ONE.equals(count)) {
			co.setStockTakeUser(String.valueOf(user.getUserCode()));
		}
		List<BizStockTakeMatItemVo> itemList = SinobecBizStockTakeMatDao.getStockTakeMatInfoFromWMSCountForReport(co);
		//List<BizStockTakeMatItemVo> tmpList = new ArrayList<BizStockTakeMatItemVo>();
		//??????????????????list
		//??????list ????????????????????? ??????sku vin eng ??? weight_qty ???stock_take_qty ????????????
//		tmpList.add(itemList.get(0));
//		
//		for (int i = 0; i < itemList.size(); i++) {
//            for (int j = 0; j < tmpList.size(); j++) {
//                if() {
//                	
//                }
//            }
//        }
		List<BizStockTakeMatItemVo> list = new ArrayList<BizStockTakeMatItemVo>();
		List<BizStockTakeMatItemVo> retList = new ArrayList<BizStockTakeMatItemVo>();
		Map<String, List<BizStockTakeMatItemVo>> collect = itemList.stream().collect(Collectors.groupingBy(e -> fetchGroupKey(e)));
		for (List<BizStockTakeMatItemVo> value : collect.values()) {
			 
		    System.out.println("Value = " + value);
		    List<BizStockTakeMatItemVo> newList = getNewList(value);
		    list.addAll(newList);
		 
		}
		

	
		
		
		//for(BizStockTakeMatItemVo vo : itemList) {
		for(BizStockTakeMatItemVo vo : list) {
			// ????????????????????????
			if(StringUtils.hasText(count) && (vo.getStockTakeMode() == EnumStockTakeMode.STOCK_TAKE_MODE_BLIND.getName())) {
				vo.setQty(new BigDecimal(Const.ZERO));
			}
			if(StringUtils.hasText(count) && Const.STRING_ONE.equals(count)) {
				vo.setUserId(vo.getCreateUserId());
			}

			retList.add(vo);
		}
		//??????retList ?????? retList ?????? weight_qty ???stock_take_qty ?????? ??????????????????
		for (int i = 0; i < retList.size(); i++) {
			BizStockTakeMatItemVo item = retList.get(i);
			String sku = item.getMatCode();
			String vin = item.getExt0();
			String eng = item.getExt1();
			List<String> loc = item.getLocationList();
			List<String> type = item.getTypeList();
			List<String> bin = item.getBinList();
			
			//???sku???vin eng ?????????
			if(loc.isEmpty()) {
				loc.add(item.getTypeCode()+','+item.getBinCode());
				type.add(item.getTypeCode());
				bin.add(item.getBinCode());
			}
			for(int j = 0; j < loc.size(); j++) {
				List<String> result =Arrays.asList(loc.get(j).split(","));
				type.add(result.get(0));
				bin.add(result.get(1));
			}
			BigDecimal sum =new BigDecimal("0");
			//sum = sinobecStockDao.selectStockSumByKey(sku,vin,eng,loc);
			sum = sinobecStockDao.selectStockSumByKey(sku,vin,eng,type,bin);
			if(sum == null) {
				sum = new BigDecimal("0");
			}
			BigDecimal diffQty = item.getWeightQty().subtract(item.getStockTakeQty());
			item.setWeightQty(diffQty);
			item.setStockTakeQty(item.getStockTakeQty().add(sum));
		}
		return retList;
	}
	
	@Override
	public List<BizStockTakeMatItemVo> getStockTakeMatInfoForReport( 
			String stockTakeCode, 
			String sapDocNumber, 
			String typeCode, 
			String binCode, 
			String matCode,
			String sDate,
			String eDate,
			String count, 
			CurrentUser user) {
		BizStockTakeCo co = new BizStockTakeCo();
		co.setStockTakeCode(stockTakeCode);
		co.setSapDocNum(sapDocNumber);
		co.setTypeCode(typeCode);
		co.setBinCode(binCode);
		co.setMatCode(matCode);
		co.setsDate(sDate);
		co.seteDate(eDate);
		//List<BizStockTakeItemVo> takeList = this.getStockTakeInfo(stockTakeCode);

		if(StringUtils.hasText(count) && Const.STRING_ONE.equals(count)) {
			co.setStockTakeUser(String.valueOf(user.getUserCode()));
		}
		List<BizStockTakeMatItemVo> itemList = SinobecBizStockTakeMatDao.getStockTakeMatInfoForReport(co);
		List<BizStockTakeMatItemVo> list = new ArrayList<BizStockTakeMatItemVo>();
		for(BizStockTakeMatItemVo vo : itemList) {
			// ????????????????????????
			if(StringUtils.hasText(count) && (vo.getStockTakeMode() == EnumStockTakeMode.STOCK_TAKE_MODE_BLIND.getName())) {
				vo.setQty(new BigDecimal(Const.ZERO));
			}
			if(StringUtils.hasText(count) && Const.STRING_ONE.equals(count)) {
				vo.setUserId(vo.getCreateUserId());
			}

			list.add(vo);
		}

		return list;
	}

	/**
	 * ????????????(???????????? ??????/?????? ??????)
	 */
	@Override
	@Transactional
	public void saveOrUpdateStockTakeMatData(BizStockTakeMatDataVo bizStockTakeMatDataVo, CurrentUser user) {

		int i = 0;
		List<BizStockTakeMatItemVo> itemList = bizStockTakeMatDataVo.getItemList();
		BizStockTakeCo takeCo = new BizStockTakeCo();
		takeCo.setStockTakeCode(bizStockTakeMatDataVo.getHead().getStockTakeCode());
		takeCo.setStockTakeUser(user.getUserCode());
		List<BizStockTakeMatItemVo> bidList = SinobecBizStockTakeMatDao.selectMaxBid(takeCo);
		Map <String,Integer> bidMap = new HashMap<String,Integer>();
		for(BizStockTakeMatItemVo mat : bidList) {
			bidMap.put(mat.getBinCode(), mat.getStockTakeBid());
		}
		// ???????????????????????????????????????
		BizStockTakeMatItemVo itemVo = SinobecBizStockTakeMatDao.getStockTakeMatCountStatus(bizStockTakeMatDataVo.getHead().getStockTakeCode());
		List<SinobecBizStockTakeMat> insertList = new ArrayList<SinobecBizStockTakeMat>();
		List<SinobecBizStockTakeMat> updateList = new ArrayList<SinobecBizStockTakeMat>();
		List<SinobecDicBundleInfo> bundleInfoList = new ArrayList<>();

		for (BizStockTakeMatItemVo bizStockTakeMatItemVo : itemList) {
			bizStockTakeMatItemVo.setStockTakeCode(bizStockTakeMatDataVo.getHead().getStockTakeCode());
			bizStockTakeMatItemVo.setStockTakeRid(itemList.get(i).getStockTakeRid());
			bizStockTakeMatItemVo.setStockTakeUser(itemList.get(i).getStockTakeUser());
			if(EnumReceiptStatus.RECEIPT_STATUS_DRAFT.getValue().equals(bizStockTakeMatItemVo.getStatus()) || bizStockTakeMatItemVo.getStatus()==null) {
				bizStockTakeMatItemVo.setStatus(bizStockTakeMatDataVo.getHead().getReceiptStatus());
			}
			bizStockTakeMatItemVo.setWhCode(itemList.get(i).getWhCode());
			bizStockTakeMatItemVo.setCreateUserId(user.getUserId());
			bizStockTakeMatItemVo.setModifyUserId(user.getUserId());

			// ??????????????????????????????
			if(bizStockTakeMatItemVo.getStockTakeMatId() != null && Const.ZERO != bizStockTakeMatItemVo.getStockTakeMatId()) {
				// ???????????????????????????????????????????????????????????????????????????
				if(itemVo == null) {
					if(EnumReceiptStatus.RECEIPT_STATUS_COUNTED.getValue().equals(bizStockTakeMatItemVo.getStatus())) {
						throw new WMSException(EnumReturnCode.RETURN_CODE_COUNT_NOT_COUNT_DIFFERENCE_STOCK_TAKE,bizStockTakeMatItemVo.getTypeCode(),bizStockTakeMatItemVo.getBinCode(),bizStockTakeMatItemVo.getBundleCode(),String.valueOf(bizStockTakeMatItemVo.getQty()),String.valueOf(bizStockTakeMatItemVo.getStockTakeQty()));
					}
				}
				updateList.add(bizStockTakeMatItemVo);
			}else {
				bizStockTakeMatItemVo.setStockTakeMatId(Const.ZERO);
				bizStockTakeMatItemVo.setStockTakeBid(bidMap.get(itemList.get(i).getBinCode()) + 1);
				bidMap.put(itemList.get(i).getBinCode(), bidMap.get(itemList.get(i).getBinCode()) + 1);
				// ????????????bundle
				SinobecDicBundleInfo bundleInfo = new SinobecDicBundleInfo();
				bundleInfo.setInputDate(new Date());
				UtilBean.getBean(bizStockTakeMatItemVo, bundleInfo);
				bundleInfoList.add(bundleInfo);
				bizStockTakeMatItemVo.setMoveDate(new Date());
				insertList.add(bizStockTakeMatItemVo);
			}
			i++;
		}
		if(!CollectionUtils.isEmpty(bundleInfoList)) {
			// ??????bundle??????
			bundleService.insertOrUpdateList(bundleInfoList);
		}
		if(!CollectionUtils.isEmpty(insertList)) {
			SinobecBizStockTakeMatDao.insertBizStockTakeMat(insertList);
		}
		if(!CollectionUtils.isEmpty(updateList)) {
			SinobecBizStockTakeMatDao.updateBizStockTakeMat(updateList);
		}
		if(EnumReceiptStatus.RECEIPT_STATUS_SUBMITTED.getValue().equals(bizStockTakeMatDataVo.getHead().getReceiptStatus())) {
			BizStockTakeCo co = new BizStockTakeCo();
			co.setStockTakeCode(bizStockTakeMatDataVo.getHead().getStockTakeCode());
			co.setReceiptStatus(EnumReceiptStatus.RECEIPT_STATUS_SUBMITTED.getValue());
			co.setStockTakeUser(user.getUserCode());
			List<BizStockTakeItemVo> ridList = SinobecBizStockTakeDao.getStockTakeRid(co);
			co.setList(ridList);
			// ??????????????????????????????????????????
			SinobecBizStockTakeDao.updateStatusByStockTakeCode(co);
			// ?????????????????????????????????????????????
			co.setStatus(EnumReceiptStatus.RECEIPT_STATUS_SUBMITTED.getValue());
			SinobecBizStockTakeMatDao.updateSubmitStatus(co);
			// ??????????????????????????????????????????
			//BizStockTakeItemVo returnItemVo = bizStockTakeDao.getItemStatus(co);
			// ??????????????????????????????????????????
			BizStockTakeMatItemVo draftVo = SinobecBizStockTakeMatDao.getStockTakeMatForDraftStatus(bizStockTakeMatDataVo.getHead().getStockTakeCode());
			// ????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????
			if(draftVo == null ) {
				List<BizStockTakeItemVo> takeList = this.getStockTakeInfo(bizStockTakeMatDataVo.getHead().getStockTakeCode());
				// ??????????????????????????????????????????????????????????????????????????????
				if(!takeList.get(0).getReceiptStatus().equals(EnumReceiptStatus.RECEIPT_STATUS_COUNTED.getValue())) {
					co.setReceiptStatus(EnumReceiptStatus.RECEIPT_STATUS_COUNTED.getValue());
					SinobecBizStockTakeDao.updateAllStatusByStockTakeCode(co);
					co.setStatus(EnumReceiptStatus.RECEIPT_STATUS_COUNTED.getValue());
					// ????????????
					SinobecBizStockTakeMatDao.updateStatusByStockTakeCode(co);
				}else {
					co.setReceiptStatus(EnumReceiptStatus.RECEIPT_STATUS_COUNTED.getValue());
					SinobecBizStockTakeDao.updateStatusByStockTakeCode(co);
					co.setStatus(EnumReceiptStatus.RECEIPT_STATUS_COUNTED.getValue());
					SinobecBizStockTakeMatDao.updateCountStatus(co);
				}
			}
		}
	}
	/**
	 * ???????????????????????????????????????(???????????????????????????????????????????????????)
	 */
	@Override
	@Transactional
	public void initInsertStockTakeMat(BizStockTakeDataVo bizStockTakeDataVo, int userId,String stockTaskCode) {
		int i = 1;
		String sapDocNum = bizStockTakeDataVo.getDocumentNumber();
		List<SinobecBizStockTakeMat> itemList = new ArrayList<SinobecBizStockTakeMat>();

		List<SinobecStockVo> binList = sinobecStockDao.selectStockByBinCode(bizStockTakeDataVo.getItemList());
		
		List<BizStockTakeItemVo> stockTakeItemList = bizStockTakeDataVo.getItemList();
		Map<String,String> userMap = new HashMap<String,String>();
		for(BizStockTakeItemVo bizStockTakeItemVo : stockTakeItemList) {
			userMap.put(bizStockTakeItemVo.getWhCode()+Const.STRING_SEPRATE_FLAG+bizStockTakeItemVo.getTypeCode()
			+Const.STRING_SEPRATE_FLAG+bizStockTakeItemVo.getBinCode(), bizStockTakeItemVo.getStockTakeUser());
		}
		int m = 1;
		for(SinobecStockVo vo : binList) {
			SinobecBizStockTakeMat bizStockTakeMatItemVo = new SinobecBizStockTakeMat();
			UtilBean.getBean(vo, bizStockTakeMatItemVo);

			bizStockTakeMatItemVo.setStockTakeCode(stockTaskCode);
			bizStockTakeMatItemVo.setStockTakeRid(UtilObject.getStringOrEmpty(i));
		 	bizStockTakeMatItemVo.setStockTakeBid(UtilObject.getIntegerOrNull(m));
			bizStockTakeMatItemVo.setWhCode(vo.getWhCode());
			bizStockTakeMatItemVo.setTypeCode(vo.getTypeCode());
			bizStockTakeMatItemVo.setBinCode(vo.getBinCode());
			bizStockTakeMatItemVo.setBundleCode(vo.getBundleCode());
			bizStockTakeMatItemVo.setHeatCode(vo.getHeatCode());
			bizStockTakeMatItemVo.setSkidCode(vo.getSkidCode());
			bizStockTakeMatItemVo.setShippingRef(vo.getShippingRef());
			bizStockTakeMatItemVo.setMatCode(vo.getMatCode());
			bizStockTakeMatItemVo.setWeightUnitCode(vo.getWeightUnitCode());
			bizStockTakeMatItemVo.setWeightQty(vo.getWeightQty());
			bizStockTakeMatItemVo.setUnitCode(vo.getReceiptUnitCode());
			bizStockTakeMatItemVo.setQty(vo.getReceiptQty());
			bizStockTakeMatItemVo.setReceiptQty(vo.getReceiptQty());
			bizStockTakeMatItemVo.setMoveDate(vo.getModifyTime());
		 	bizStockTakeMatItemVo.setStockTakeQty(new BigDecimal(Const.ZERO));
			bizStockTakeMatItemVo.setStatus(EnumReceiptStatus.RECEIPT_STATUS_DRAFT.getValue());
			bizStockTakeMatItemVo.setStockTakeUser(userMap.get(vo.getWhCode()+Const.STRING_SEPRATE_FLAG+vo.getTypeCode()+Const.STRING_SEPRATE_FLAG+vo.getBinCode()));
			bizStockTakeMatItemVo.setCreateUserId(userId);
			bizStockTakeMatItemVo.setModifyUserId(userId);
			bizStockTakeMatItemVo.setMoveDate(vo.getModifyTime());
			bizStockTakeMatItemVo.setStockId(vo.getStockId());
			bizStockTakeMatItemVo.setLotNumb(vo.getLotNumb());
			bizStockTakeMatItemVo.setStockStatus(vo.getStockStatus());
			bizStockTakeMatItemVo.setCreateTime(new Date());
			bizStockTakeMatItemVo.setExt0(vo.getExt0());
			bizStockTakeMatItemVo.setExt1(vo.getExt1());
			bizStockTakeMatItemVo.setExt2(vo.getExt2());
			bizStockTakeMatItemVo.setExt3(vo.getExt3());
			bizStockTakeMatItemVo.setExt4(vo.getExt4());
			bizStockTakeMatItemVo.setExt5(vo.getExt5());
			bizStockTakeMatItemVo.setExt6(vo.getExt6());
			bizStockTakeMatItemVo.setExt7(vo.getExt7());
			bizStockTakeMatItemVo.setExt8(vo.getExt8());
			bizStockTakeMatItemVo.setExt9(vo.getExt9());
			bizStockTakeMatItemVo.setExt10(vo.getExt10());
			bizStockTakeMatItemVo.setExt11(vo.getExt11());
			bizStockTakeMatItemVo.setExt12(vo.getExt12());
			bizStockTakeMatItemVo.setExt13(vo.getExt13());
			bizStockTakeMatItemVo.setExt14(vo.getExt14());
			bizStockTakeMatItemVo.setExt15(vo.getExt15());
			
			if(sapDocNum !=null && sapDocNum .length()!=0) {
				//?????????bizStockTakeMatItemVo ??????sapDocNum+sku+ext0+ext1 ??? count_order_from_sap ???????????????
				//???????????????????????????????????????
				
				//int tmp = countOrderFromSapMapper.selectByInfoKey(sapDocNum, bizStockTakeMatItemVo.getMatCode(), bizStockTakeMatItemVo.getExt0(), bizStockTakeMatItemVo.getExt1());
				int tmp = countOrderFromSapMapper.selectByInfoKey(sapDocNum, bizStockTakeMatItemVo.getMatCode(), null, null);
				if(tmp > 0) {
					//????????????????????????????????????itemList
					itemList.add(bizStockTakeMatItemVo);
				}
				m++;
				continue;
				
			}
			itemList.add(bizStockTakeMatItemVo);
			m++;
		}
		if(!CollectionUtils.isEmpty(itemList)) {
			//????????????????????????sap??????????????????documentNumber????????????????????????binList????????????sku?????????????????????
			//?????????binList????????????????????????matCode???sap?????????sku list???????????????
			//????????????????????????
			if(bizStockTakeDataVo.getDocumentNumber()!=null && bizStockTakeDataVo.getDocumentNumber().length()!=0) {
				//sap?????????document???????????????????????????itemList??????matcode ext0 ext1 
				//???count_order_from_sap?????? count_order ??? bizStockTakeDataVo.getDocumentNumber()???????????????
				
			}
			SinobecBizStockTakeMatDao.insertBizStockTakeMat(itemList);
		}
	}

	/**
	 * ??????????????????????????????????????????(??????????????????)
	 */
	@Override
	public boolean checkAllDataStatus(String stockTakeCode) {
		BizStockTakeCo co = new BizStockTakeCo();
		co.setStockTakeCode(stockTakeCode);
		co.setStatus(EnumReceiptStatus.RECEIPT_STATUS_COUNTED.getValue());
		List <BizStockTakeMatItemVo> itemList = SinobecBizStockTakeMatDao.checkAllDataStatus(co);
		if(!CollectionUtils.isEmpty(itemList)) {
			throw new WMSException(EnumReturnCode.RETURN_CODE_NOT_ALL_ROW_DATE_COUNTED_STATUS);
		}
		return true;
	}
	/**
	 * ????????????(??????????????????)
	 */
	@Override
	@Transactional
	public void reInventory(String stockTakeCode, CurrentUser user) {
		BizStockTakeCo co = new BizStockTakeCo();
		co.setStockTakeCode(stockTakeCode);
		List<BizStockTakeItemVo> itemList = SinobecBizStockTakeDao.getStockTakeInfo(co);
		for(BizStockTakeItemVo vo : itemList) {
			if(!vo.getReceiptStatus().equals(EnumReceiptStatus.RECEIPT_STATUS_COUNTED.getValue())) {
				throw new WMSException(EnumReturnCode.RETURN_CODE_APPROVAL_NOT_ALL_STOCK_TAKE);
			}
		}
		co.setReceiptStatus(EnumReceiptStatus.RECEIPT_STATUS_UN_COUNTED.getValue());
		co.setIsReCount((byte) 1);
		SinobecBizStockTakeDao.updateAllStatusByStockTakeCode(co);
		co.setStatus(EnumReceiptStatus.RECEIPT_STATUS_DRAFT.getValue());
		SinobecBizStockTakeMatDao.updateStatusByStockTakeCode(co);
	}
	/**
	 * ?????????????????????(?????????????????????)
	 */
	@Override
	public List<BizStockTakeMatItemVo> getDifferenceList(BizStockTakeMatDataVo bizStockTakeMatDataVo,String langCode) {
		BizStockTakeCo co = new BizStockTakeCo();
		co.setStockTakeCode(bizStockTakeMatDataVo.getHead().getStockTakeCode());
		List<BizStockTakeMatItemVo> itemList = SinobecBizStockTakeMatDao.getDifferenceList(co);
		for(BizStockTakeMatItemVo vo : itemList) {
			if(vo.getWeightQty().compareTo(vo.getStockTakeQty()) < 0) {
				vo.setStockTakeResult(EnumStockTakeResult.STOCK_TAKE_RESULT_PROFIT.getName());
				vo.setStockTakeResultName(UtilText.getNameMessage(langCode, EnumStockTakeResult.getEnumName(EnumStockTakeResult.STOCK_TAKE_RESULT_PROFIT.getName())));
			}else {
				vo.setStockTakeResult(EnumStockTakeResult.STOCK_TAKE_RESULT_LOSS.getName());
				vo.setStockTakeResultName(UtilText.getNameMessage(langCode, EnumStockTakeResult.getEnumName(EnumStockTakeResult.STOCK_TAKE_RESULT_LOSS.getName())));
			}
		}
		return itemList;
	}


	/**
	 * ???????????????(?????????)
	 */
	@Override
	public void differenceReInventory(BizStockTakeMatDataVo bizStockTakeMatDataVo, CurrentUser user) {
		BizStockTakeCo co = new BizStockTakeCo();
		co.setStockTakeCode(bizStockTakeMatDataVo.getHead().getStockTakeCode());
		co.setReceiptStatus(EnumReceiptStatus.RECEIPT_STATUS_UN_COUNTED.getValue());
		List<Integer> takeIdList = new ArrayList<Integer>();
		for(BizStockTakeMatItemVo bizStockTakeMatItemVo : bizStockTakeMatDataVo.getItemList()) {
			takeIdList.add(bizStockTakeMatItemVo.getStockTakeId());
		}
		co.setTakeIdList(takeIdList);
		SinobecBizStockTakeDao.updateStatusByStockTakeCode(co);
		SinobecBizStockTakeDao.updateOrderStatusByStockTakeCode(co);
		List<Integer> idList = new ArrayList<Integer>();
		for(BizStockTakeMatItemVo bizStockTakeMatItemVo : bizStockTakeMatDataVo.getItemList()) {
			idList.add(bizStockTakeMatItemVo.getStockTakeMatId());
		}
		co.setMatIdList(idList);
		co.setStatus(EnumReceiptStatus.RECEIPT_STATUS_DRAFT.getValue());
		SinobecBizStockTakeMatDao.updateStatusByStockTakeCode(co);
	}
	/**
	 * ??????????????????
	 */
	@Override
	public BizStockTakeMatDataVo binDifferenceHandle(BizStockTakeMatDataVo bizStockTakeMatDataVo, CurrentUser user) throws Exception {
		try{
			for(BizStockTakeMatItemVo bizStockTakeMatItemVo : bizStockTakeMatDataVo.getItemList()) {
				if(bizStockTakeMatItemVo.getWeightQty().compareTo(bizStockTakeMatItemVo.getStockTakeQty()) > 0) {
				//??????
					bizStockTakeMatItemVo.setDebitCredit(EnumDebitCredit.CREDIT_H_SUBTRACT.getValue());
					bizStockTakeMatItemVo.setWeightQty(bizStockTakeMatItemVo.getWeightQty().subtract(bizStockTakeMatItemVo.getStockTakeQty()));
					bizStockTakeMatItemVo.setReceiptQty(bizStockTakeMatItemVo.getReceiptQty().subtract(bizStockTakeMatItemVo.getQty()));
				}else if(bizStockTakeMatItemVo.getWeightQty().compareTo(bizStockTakeMatItemVo.getStockTakeQty()) < 0){
				//??????
					bizStockTakeMatItemVo.setDebitCredit(EnumDebitCredit.DEBIT_S_ADD.getValue());
					bizStockTakeMatItemVo.setWeightQty(bizStockTakeMatItemVo.getStockTakeQty().subtract(bizStockTakeMatItemVo.getWeightQty()));
					bizStockTakeMatItemVo.setReceiptQty(bizStockTakeMatItemVo.getQty().subtract(bizStockTakeMatItemVo.getReceiptQty()));
				}
			}
			// ????????????
			this.outFreezeBin(bizStockTakeMatDataVo,Const.STRING_ONE);
			// ????????????
			this.modifyStock(bizStockTakeMatDataVo.getItemList());
			// ?????? ???????????????????????????????????????
			BizStockTakeCo co = new BizStockTakeCo();
			co.setStockTakeCode(bizStockTakeMatDataVo.getHead().getStockTakeCode());
			List<Integer> idList = new ArrayList<Integer>();
			for(BizStockTakeMatItemVo bizStockTakeMatItemVo : bizStockTakeMatDataVo.getItemList()) {
				idList.add(bizStockTakeMatItemVo.getStockTakeMatId());
			}
			co.setMatIdList(idList);
			co.setStatus(EnumReceiptStatus.RECEIPT_STATUS_FLAT_DIFF_BIN.getValue());
			SinobecBizStockTakeMatDao.updateStatusByStockTakeCode(co);
			BizStockTakeMatHeadVo head = bizStockTakeMatDataVo.getHead();
			head.setComplateStatus(Const.STRING_ONE);
			bizStockTakeMatDataVo.setHead(head);
		} finally {
			// ????????????
			this.freezeBinByMat(bizStockTakeMatDataVo, user);
		}
		return null;
	 }



	/**
	 * ??????????????????????????????
	 */
	@Transactional
	public void modifyStock(List<BizStockTakeMatItemVo> itemList) throws Exception {
		if(!CollectionUtils.isEmpty(itemList)) {
			SinobecInsMoveTypeVo insDoc = insTakeMoveType.generateInsDoc(itemList);
			// ????????????????????????????????????
			stockCommonServiceImpl.modifyStockByStockTake(insDoc);
		}
	}


	/**
	 * ????????????(???????????????????????????)
	 */
	public void outFreezeBin(BizStockTakeMatDataVo bizStockTakeMatDataVo,String flag) {
		byte freezeStockTake = this.getStockTakeInfo(bizStockTakeMatDataVo.getHead().getStockTakeCode()).get(0).getFreezeStockTake();
		// ???????????????????????????
		if(EnumIsFreeze.IS_FREEZE.getValue() == freezeStockTake) {
			BizStockTakeCo co = new BizStockTakeCo();
			co.setStockTakeCode(bizStockTakeMatDataVo.getHead().getStockTakeCode());
			List<BizStockTakeMatItemVo> differenceList = new ArrayList<BizStockTakeMatItemVo>();
			if(Const.STRING_ZERO.equals(flag)) {
				differenceList = SinobecBizStockTakeMatDao.getDifferenceList(co);
			}
			// ?????????????????????????????????????????????
			if(CollectionUtils.isEmpty(differenceList)) {
				for(BizStockTakeMatItemVo bizStockTakeMatItemVo : bizStockTakeMatDataVo.getItemList()) {
					bizStockTakeMatItemVo.setFreezeInput(EnumIsFreeze.UN_FREEZE.getValue());
					bizStockTakeMatItemVo.setFreezeOutput(EnumIsFreeze.UN_FREEZE.getValue());
				}
				dicWhStorageBinDao.updateWhStorageBinByMatList(bizStockTakeMatDataVo.getItemList());
			}
		}
	}
	/**
	 * ????????????(???????????????????????????)
	 */
	public void freezeBinByMat(BizStockTakeMatDataVo bizStockTakeMatDataVo, CurrentUser user) {
		byte freezeStockTake = this.getStockTakeInfo(bizStockTakeMatDataVo.getHead().getStockTakeCode()).get(0).getFreezeStockTake();
		// ??????????????????
		if(EnumIsFreeze.IS_FREEZE.getValue() == freezeStockTake) {
			String reasonCode = commonServiceSubImpl.getNextSequenceValue(EnumSequenceCode.SEQUENCE_FREEZE_REASON.getValue());
			for(BizStockTakeMatItemVo bizStockTakeMatItemVo : bizStockTakeMatDataVo.getItemList()) {
				bizStockTakeMatItemVo.setFreezeInput(EnumIsFreeze.IS_FREEZE.getValue());
				bizStockTakeMatItemVo.setFreezeOutput(EnumIsFreeze.IS_FREEZE.getValue());
			}
			dicWhStorageBinDao.updateWhStorageBinByMatList(bizStockTakeMatDataVo.getItemList());
			DicFreezeReason dicFreezeReason = new DicFreezeReason();
			dicFreezeReason.setModifyUserId(user.getUserId());
			dicFreezeReason.setCreateUserId(user.getUserId());
			dicFreezeReason.setReasonName(Const.FREEZE_REASON);
			dicFreezeReason.setReasonCode(reasonCode);
			dicFreezeReasonDao.insertFreezeReason(dicFreezeReason);
		}
	}



	/**
	 * ??????????????????????????????????????????????????????????????????(???????????????????????????)
	 */
	@Override
	public List<SysUserVo> selectUserByWhCode(SysUserInfoCo infoCo) {
		List<SysUserVo> sysList = sysUserDao.selectAllUserList();
		return sysList;
	}


	/**
	 * ????????????????????????(????????????????????????)
	 */
	@Override
	public boolean checkBinFreeze(BizStockTakeDataVo bizStockTakeDataVo) {
		List<DicWhStorageBinVo> list = dicWhStorageBinDao.selectIsFreeze(bizStockTakeDataVo.getItemList());
		for(DicWhStorageBinVo vo : list) {
			throw new WMSException(EnumReturnCode.RETURN_CODE_BIN_FREEZING, vo.getBinCode());
		}
		return true;
	}

	/**
	 * ????????????(????????????????????????)
	 */
	@Override
	public void freezeBin(BizStockTakeDataVo bizStockTakeDataVo, int userId) {
		if(EnumIsFreeze.IS_FREEZE.getValue().equals(bizStockTakeDataVo.getHead().getFreezeStockTake())) {
			String reasonCode = commonServiceSubImpl.getNextSequenceValue(EnumSequenceCode.SEQUENCE_FREEZE_REASON.getValue());
			for(BizStockTakeItemVo bizStockTakeItemVo : bizStockTakeDataVo.getItemList()) {
				bizStockTakeItemVo.setFreezeInput(EnumIsFreeze.IS_FREEZE.getValue());
				bizStockTakeItemVo.setFreezeOutput(EnumIsFreeze.IS_FREEZE.getValue());
			}
			dicWhStorageBinDao.updateWhStorageBinByList(bizStockTakeDataVo.getItemList());
			DicFreezeReason dicFreezeReason = new DicFreezeReason();
			dicFreezeReason.setModifyUserId(userId);
			dicFreezeReason.setCreateUserId(userId);
			dicFreezeReason.setReasonName(Const.FREEZE_REASON);
			dicFreezeReason.setReasonCode(reasonCode);
			dicFreezeReasonDao.insertFreezeReason(dicFreezeReason);
		}
	}

	/**
	 * ???????????????????????????(??????)
	 */
	@Override
	public boolean checkStockTakeUser(BizStockTakeDataVo bizStockTakeDataVo) {
		for(BizStockTakeItemVo vo : bizStockTakeDataVo.getItemList()) {
			if(!StringUtils.hasText(vo.getStockTakeUser())) {
				throw new WMSException(EnumReturnCode.RETURN_CODE_STOCK_TAKE_USER_NOT_EMPTY);
			}
		}
		return true;
	}

	/**
	 * ????????????????????????????????????????????????(??????)
	 */
	@Override
	public void updateStockTakeStatus(String stockTakeCode) {
		BizStockTakeCo co = new BizStockTakeCo();
		co.setStockTakeCode(stockTakeCode);
		co.setReceiptStatus(EnumReceiptStatus.RECEIPT_STATUS_COMPLETED.getValue());
		SinobecBizStockTakeDao.updateAllStatusByStockTakeCode(co);
		co.setStatus(EnumReceiptStatus.RECEIPT_STATUS_COMPLETED.getValue());
		SinobecBizStockTakeMatDao.updateStatusByStockTakeCode(co);
		List<BizStockTakeItemVo> itemList = SinobecBizStockTakeDao.getStockTakeInfo(co);
		byte freezeStockTake = this.getStockTakeInfo(stockTakeCode).get(0).getFreezeStockTake();
		// ???????????????????????????
		if(EnumIsFreeze.IS_FREEZE.getValue() == freezeStockTake) {
			// ????????????
			for(BizStockTakeItemVo bizStockTakeItemVo : itemList) {
				bizStockTakeItemVo.setFreezeInput(EnumIsFreeze.UN_FREEZE.getValue());
				bizStockTakeItemVo.setFreezeOutput(EnumIsFreeze.UN_FREEZE.getValue());
			}
			dicWhStorageBinDao.updateWhStorageBinByList(itemList);
		}
		
		//???????????????????????????sap??????????????????????????????sap????????????????????????
		//????????????????????????instock????????????????????????????????????????????????
		//????????????sap????????????????????????docnumber???sku?????????bundle_info??????????????????sku ?????????bundle????????????bundle???stock??????????????????sap?????????
		
	}



	/**
	 * ????????????????????????(??????)
	 */
	@Override
	public void updateStockTakeData(String stockTakeCode, CurrentUser user,byte status) {
		// ??????????????????
		BizStockTakeCo co = new BizStockTakeCo();
		co.setStockTakeCode(stockTakeCode);
		co.setReceiptStatus(status);
		SinobecBizStockTakeDao.updateAllStatusByStockTakeCode(co);
	}
	
	@Override
	public List<BizStockTakeMatItemVo> getStockTakeMatListByStockTakeCode(String stockTakeCode) {
		BizStockTakeCo co = new BizStockTakeCo();
		co.setStockTakeCode(stockTakeCode);

		List<BizStockTakeMatItemVo> itemList = SinobecBizStockTakeMatDao.getStockTakeMatInfo(co);
		List<BizStockTakeMatItemVo> list = itemList.stream().filter(il -> il.getDocNum()!=null).collect(Collectors.toList());

		return list;
	}

}
