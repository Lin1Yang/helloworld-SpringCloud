package com.inossem.wms.service.impl.common;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.inossem.wms.co.dic.DicMaterialWhInfoCo;
import com.inossem.wms.co.sys.SysUserInfoCo;
import com.inossem.wms.common.auth.CurrentUser;
import com.inossem.wms.common.exception.ParameterErrorException;
import com.inossem.wms.common.exception.PrimaryKeyNotExistException;
import com.inossem.wms.common.exception.WMSException;
import com.inossem.wms.common.util.UtilBean;
import com.inossem.wms.common.util.UtilConst;
import com.inossem.wms.common.util.UtilObject;
import com.inossem.wms.common.util.UtilString;
import com.inossem.wms.common.util.UtilText;
import com.inossem.wms.constant.Const;
import com.inossem.wms.dao.biz.BizHeadRemarkMapper;
import com.inossem.wms.dao.biz.BizStockInputMapper;
import com.inossem.wms.dao.conf.ConfMaterialWhMapper;
import com.inossem.wms.dao.dic.DicAccountPeriodMapper;
import com.inossem.wms.dao.dic.DicMaterialMapper;
import com.inossem.wms.dao.dic.DicMaterialWhMapper;
import com.inossem.wms.dao.dic.DicMaterialWhStorageTypeMapper;
import com.inossem.wms.dao.dic.DicNoticeMapper;
import com.inossem.wms.dao.dic.DicReceiptTypeMapper;
import com.inossem.wms.dao.dic.DicUnitMapper;
import com.inossem.wms.dao.dic.DicWhStorageBinMapper;
import com.inossem.wms.dao.sequence.SequenceDAO;
import com.inossem.wms.dao.sys.SysUserMapper;
import com.inossem.wms.enums.EnumEnable;
import com.inossem.wms.enums.EnumFreezeType;
import com.inossem.wms.enums.EnumReceiptOperationType;
import com.inossem.wms.enums.EnumReceiptStatus;
import com.inossem.wms.enums.EnumReceiptType;
import com.inossem.wms.enums.EnumReturnCode;
import com.inossem.wms.enums.EnumSequenceCode;
import com.inossem.wms.model.biz.BizHeadRemark;
import com.inossem.wms.model.conf.ConfMaterialWh;
import com.inossem.wms.model.dic.DicMaterialWh;
import com.inossem.wms.model.dic.DicMaterialWhKey;
import com.inossem.wms.model.dic.DicNoticeVo;
import com.inossem.wms.model.dic.DicReceiptType;
import com.inossem.wms.model.dic.DicUnit;
import com.inossem.wms.model.dic.DicWhStorageBin;
import com.inossem.wms.model.dic.DicWhStorageBinKey;
import com.inossem.wms.model.rel.RelReceiptRidKey;
import com.inossem.wms.model.rel.RelUnit;
import com.inossem.wms.model.rel.RelUnitKey;
import com.inossem.wms.model.sys.SysUser;
import com.inossem.wms.service.common.ICommonService;
import com.inossem.wms.service.common.IConstService;
import com.inossem.wms.service.common.IDictionaryService;
import com.inossem.wms.vo.dic.DicMaterialManageVo;

@Component
public class CommonServiceImpl implements ICommonService {

    private static final Logger logger = LoggerFactory.getLogger(CommonServiceImpl.class);

    @Autowired
    protected SequenceDAO sequenceDao;


    @Autowired
    protected BizHeadRemarkMapper bizHeadRemarkDao;

    

    @Autowired
    protected IDictionaryService dictionaryServiceSubImpl;



    @Autowired
    protected DicWhStorageBinMapper dicWhStorageBinDao;

   

    @Autowired
    protected DicUnitMapper dicUnitDao;

    @Autowired
    protected DicNoticeMapper dicNoticeMapper;


    @Autowired
    protected SysUserMapper sysUserDao;


    @Autowired
    protected IConstService constServiceSubImpl;


    @Autowired
    protected BizStockInputMapper stockInputDao;

    @Autowired
    protected DicMaterialWhMapper dicMaterialWhDao;

    @Autowired
    protected DicMaterialWhStorageTypeMapper dicMaterialWhStorageTypeMapper;

    @Autowired
    protected ConfMaterialWhMapper confMaterialWhDao;

    @Autowired
    protected DicMaterialMapper dicMaterialDao;

  

    @Autowired
    protected DicAccountPeriodMapper periodDao;
    


    @Autowired 
    protected DicReceiptTypeMapper dicReceiptTypeDao;
    
    @Override
    public String getNextSequenceValue(String sequenceCode) throws WMSException {
        try {
            return sequenceDao.selectNextValue(sequenceCode);
        } catch (Exception e) {
            logger.error(e.getMessage());
            throw new WMSException(EnumReturnCode.RETURN_CODE_SEQUENCE_GENERATE_FAILURE);
        }
    }

    @Override
    public String getNextSequenceValueDaily(String sequenceCode) throws WMSException {
        try {
            return sequenceDao.selectNextValueDaily(sequenceCode);
        } catch (Exception e) {
            logger.error(e.getMessage());
            throw new WMSException(EnumReturnCode.RETURN_CODE_SEQUENCE_GENERATE_FAILURE);
        }
    }

    @Override
    public String getBatch() throws WMSException {
        try {
            return sequenceDao.selectNextValue(EnumSequenceCode.SEQUENCE_BATCH.getValue());
        } catch (Exception e) {
            logger.error(e.getMessage());
            throw new WMSException(EnumReturnCode.RETURN_CODE_BATCH_GENERATE_FAILURE);
        }
    }

   

    @Override
    public String getBatchDaily() throws WMSException {
        try {
            return sequenceDao.selectNextValueDaily(EnumSequenceCode.SEQUENCE_BATCH.getValue());
        } catch (Exception e) {
            logger.error(e.getMessage());
            throw new WMSException(EnumReturnCode.RETURN_CODE_BATCH_GENERATE_FAILURE);
        }
    }

    
   

    @Override
    public BizHeadRemark getHeadRemark(BizHeadRemark headRemark) throws WMSException {
        try {
            return bizHeadRemarkDao.selectRemark(headRemark);
        } catch (Exception e) {
            logger.error(e.getMessage());
            throw new WMSException(EnumReturnCode.RETURN_CODE_RECEIPT_REMARK);
        }
    }

    @Override
    public void editHeadRemark(BizHeadRemark headRemark) throws WMSException {
        try {
            bizHeadRemarkDao.insertOrUpdate(headRemark);
        } catch (Exception e) {
            logger.error(e.getMessage());
            throw new WMSException(EnumReturnCode.RETURN_CODE_RECEIPT_REMARK_INSERT_OR_UPDATE_EXCEPTION);
        }
    }

    


    @Override
    public Boolean canCreateNextType(RelReceiptRidKey relReceipt) throws WMSException {
        boolean returnValue = false;
//		if (relReceipt != null && StringUtils.hasText(relReceipt.getReceiptCode())
//				&& relReceipt.getReceiptType() != null && relReceipt.getNextType() != null) {
//
//			RelReceipt findValue = relReceiptBinDao.selectByPrimaryKey(relReceipt);
//			if (findValue == null) {
//				// 无历史记录
//				returnValue = true;
//			} else if (relReceipt.getNextType().equals(findValue.getNextType())) {
//				// 有记录 相同类型
//				returnValue = true;
//			}
//		} else {
//			throw new ParameterLostException();
//		}
        return returnValue;
    }


 

    

   

    @Override
    public List<Integer> getInputReceiptType() {
        List<Integer> list = new ArrayList<Integer>();
        list.add(EnumReceiptType.SINOBEC_INPUT_PURCHASE.getValue());
        list.add(EnumReceiptType.SINOBEC_INPUT_CUSTOMER_RETURN.getValue());
        list.add(EnumReceiptType.SINOBEC_INPUT_ADJUSTMENT_IN.getValue());
        list.add(EnumReceiptType.SINOBEC_INPUT_TRANSFER_IN.getValue());
        list.add(EnumReceiptType.SINOBEC_INPUT_MASK_IN.getValue());
        return list;
    }

   

    @Override
    public List<Integer> getOutputReceiptType() {
        List<Integer> list = new ArrayList<Integer>();
        list.add(EnumReceiptType.SINOBEC_OUTPUT_SALE.getValue());
        list.add(EnumReceiptType.SINOBEC_OUTPUT_TRANSFER_OUT.getValue());
        list.add(EnumReceiptType.SINOBEC_OUTPUT_COMMISSIONED_PROCESSING.getValue());
        list.add(EnumReceiptType.SINOBEC_OUTPUT_VENDOR_RETURN.getValue());
        list.add(EnumReceiptType.SINOBEC_OUTPUT_MASK_OUT.getValue());
        return list;
    }

   

   
   

    @Override
    public List<DicUnit> getAllUnitList() throws WMSException {
        return dicUnitDao.selectAllUnitList();
    }

    @Override
    public List<DicNoticeVo> getByConditionDicnoticeList() {
        List<DicNoticeVo> selList = dicNoticeMapper.selectNoDelAndFbNoticeList();
        return selList;
    }

    @Override
    public DicNoticeVo getNewByConditionDicnotice() {
        DicNoticeVo selList = dicNoticeMapper.selectNewNoDelAndFbNotice();
        return selList;
    }

    @Override
    public boolean isDefaultType(String typeCode) {
        boolean returnValue = false;
        if (typeCode == null) {
            return returnValue;
        }
        Set<String> defaultTypeSet = new HashSet<String>();
        defaultTypeSet.add(UtilConst.getInstance().getInputDefaultType());
        defaultTypeSet.add(UtilConst.getInstance().getOutputDefaultType());
        defaultTypeSet.add(UtilConst.getInstance().getPickingDefaultType());
        defaultTypeSet.add(UtilConst.getInstance().getInputReturnDefaultType());
        defaultTypeSet.add(UtilConst.getInstance().getOutputReturnDefaultType());
        defaultTypeSet.add(UtilConst.getInstance().getSetupCellDefaultType());
        defaultTypeSet.add(UtilConst.getInstance().getStocktakeDefaultType());
        defaultTypeSet.add(UtilConst.getInstance().getWriteOffDefaultType());
        defaultTypeSet.add(UtilConst.getInstance().getTransportDefaultType());
        defaultTypeSet.add(UtilConst.getInstance().getUnrealDefaultType());
        defaultTypeSet.add(UtilConst.getInstance().getUnrealDefaultType());
        defaultTypeSet.add(UtilConst.getInstance().getWcsLoadDefaultType());
        defaultTypeSet.add(UtilConst.getInstance().getWcsUnLoadDefaultType());
        if (defaultTypeSet.contains(typeCode)) {
            returnValue = true;
        }
        return returnValue;
    }




    


    @Override
    public boolean checkSysUserExist(String userCode) throws WMSException {
        // 查询用户编码是否重复
        SysUser users = sysUserDao.selectSysUserCountByUserCode(userCode);
        // 用户编码已存在
        if (null != users) {
            throw new WMSException(EnumReturnCode.RETURN_CODE_USER_CODE_ALREADY_EXIST);
        }
        return true;
    }

    @Override
    public void registerSysUser(SysUserInfoCo infoCo, Integer userId) throws WMSException {
        sysUserDao.insertSelective(infoCo);
    }


   



   


    @Override
    public String getMatDocRid(Integer matDocRid) throws WMSException {

        return UtilObject.getStringOrEmpty(matDocRid);
    }

    @Override
    public Set<Byte> getCompletedItemStatusSet() throws WMSException {
        Set<Byte> itemStatusSet = new HashSet<Byte>();
        itemStatusSet.add(EnumReceiptStatus.RECEIPT_STATUS_COMPLETED.getValue());
        itemStatusSet.add(EnumReceiptStatus.RECEIPT_STATUS_WRITED_OFF.getValue());
        itemStatusSet.add(EnumReceiptStatus.RECEIPT_STATUS_WRITING_OFF.getValue());
        return itemStatusSet;
    }

    @Override
    public Set<Byte> getDoingDebtOffsetItemStatusSet() throws WMSException {
        Set<Byte> itemStatusSet = new HashSet<Byte>();
        itemStatusSet.add(EnumReceiptStatus.RECEIPT_STATUS_COMPLETED.getValue());
        itemStatusSet.add(EnumReceiptStatus.RECEIPT_STATUS_WRITED_OFF.getValue());
        itemStatusSet.add(EnumReceiptStatus.RECEIPT_STATUS_WRITING_OFF.getValue());
        itemStatusSet.add(EnumReceiptStatus.RECEIPT_STATUS_DOING_DEBT_OFFSET.getValue());
        return itemStatusSet;
    }

    @Override
    public Set<Byte> getTaskedItemStatusSet() throws WMSException {
        Set<Byte> itemStatusSet = new HashSet<Byte>();
        itemStatusSet.add(EnumReceiptStatus.RECEIPT_STATUS_TASK.getValue());
        itemStatusSet.add(EnumReceiptStatus.RECEIPT_STATUS_UNSYNC.getValue());
        return itemStatusSet;
    }

    @Override
    public Byte actorRequired(Integer receiptType) throws WMSException {
        if (UtilConst.getInstance().getActorByReceiptType(receiptType)) {
            return EnumEnable.ENABLE.getValue();
        } else {
            return EnumEnable.UNABLE.getValue();
        }
    }

   

    /**
     * 根据仓库号,物料号查询仓库物料配置信息
     */
    @Override
    public DicMaterialWhInfoCo getMaterialWhByKey(DicMaterialWhKey key) throws WMSException {
        DicMaterialWhInfoCo info = new DicMaterialWhInfoCo();
        DicMaterialWh mWh = dicMaterialWhDao.selectByPrimaryKey(key);
        if (null == mWh) {
            // 若无信息,从配置表中取
            ConfMaterialWh confMaterialWh = confMaterialWhDao.selectByPrimaryKey(key.getWhCode());
            if (null == confMaterialWh) {
                // 新增时返回
                return null;
            }
            UtilBean.getBean(confMaterialWh, info);
            info.setIsAdd(true);
        } else {
            UtilBean.getBean(mWh, info);
            info.setIsAdd(false);
        }
        // 物料基础信息查询
        DicMaterialManageVo vo = dicMaterialDao.selectDicMaterialManage(key.getMatCode());
        UtilBean.getBean(vo, info);
        // 存储类型信息列表
        info.setStorageTypeList(dicMaterialWhStorageTypeMapper.getList(key));
        return info;
    }


    @Override
    public SysUser getUserById(Integer userId) throws WMSException {

        return sysUserDao.selectByPrimaryKey(userId);
    }
    
    @Override
    public CurrentUser getCurrentUserBeanById(Integer userId) {
    	CurrentUser cUser = new CurrentUser();
		UtilBean.getBean(this.getUserById(userId), cUser);
		// cUser.setLocationList(dicStockLocationDao.selectLocationTreeForUser(userId));
		return cUser;
    }

    

   

   


   
    @Override
    public boolean isInput(Integer receiptType) throws WMSException {
        boolean returnValue = false;
        if (receiptType == null) {
            return returnValue;
        } else {
            if (this.getInputReceiptType().contains(receiptType)) {
                returnValue = true;
            }
        }
        return returnValue;
    }

    @Override
    public boolean isOutput(Integer receiptType) throws WMSException {
        boolean returnValue = false;
        if (receiptType == null) {
            return returnValue;
        } else {
            if (this.getOutputReceiptType().contains(receiptType)) {
                returnValue = true;
            }
        }
        return returnValue;
    }


    
   

    @Override
    public BigDecimal getActualQty(String ftyCode, String matCode, String sourceUnitCode, String targetUnitCode, BigDecimal sourceQty)
            throws WMSException {
    	if (sourceUnitCode.equalsIgnoreCase(targetUnitCode)) {
            return sourceQty;
        }
        Map<RelUnitKey, RelUnit> relUnitMap = dictionaryServiceSubImpl.getAllRelUnitCache();
        if (ftyCode == null || matCode == null || sourceUnitCode == null || targetUnitCode == null || sourceQty == null) {
            throw new ParameterErrorException();
        }
        

        RelUnitKey keyST = new RelUnitKey(ftyCode, sourceUnitCode, targetUnitCode, matCode);
        BigDecimal actualQty = null;
        RelUnit relUnitST = relUnitMap.get(keyST);

        if (relUnitST == null) {
            RelUnitKey keyTS = new RelUnitKey(ftyCode, targetUnitCode, sourceUnitCode, matCode);
            RelUnit relUnitTS = relUnitMap.get(keyTS);
            if (relUnitTS == null) {
                throw new PrimaryKeyNotExistException(EnumReturnCode.RETURN_CODE_REL_UNIT_NOT_EXIST, 
                        matCode, sourceUnitCode, targetUnitCode);
            }
            actualQty = sourceQty.multiply(relUnitTS.getSourceQty()).divide(relUnitTS.getTargetQty(), 3, RoundingMode.HALF_UP);
        } else {
            actualQty = sourceQty.multiply(relUnitST.getTargetQty()).divide(relUnitST.getSourceQty(), 3, RoundingMode.HALF_UP);
        }
        return actualQty;
    }


    @Override
    public BigDecimal getRelUnitQty(String sourceUnitCode, String targetUnitCode, String matCode, String ftyCode,
                                    BigDecimal qty) throws WMSException {

        BigDecimal updateQty = BigDecimal.ZERO;

        if (sourceUnitCode.equalsIgnoreCase(targetUnitCode)) {
            return qty;
        }

        // 所有单位关系map
        Map<RelUnitKey, RelUnit> relUnitMap = dictionaryServiceSubImpl.getAllRelUnitCache();
        RelUnit relUnit = relUnitMap.get(
                new RelUnitKey(ftyCode, targetUnitCode, sourceUnitCode, matCode));
        if (relUnit != null) {
            updateQty = qty.multiply(relUnit.getSourceQty()).divide(relUnit.getTargetQty(), 3,
                    RoundingMode.HALF_UP);
        } else {
            relUnit = relUnitMap.get(new RelUnitKey(ftyCode, sourceUnitCode, targetUnitCode,
                    matCode));

            if (relUnit != null) {
                updateQty = qty.multiply(relUnit.getTargetQty()).divide(relUnit.getSourceQty(), 3,
                        RoundingMode.HALF_UP);
            } else {
            	throw new PrimaryKeyNotExistException(EnumReturnCode.RETURN_CODE_REL_UNIT_NOT_EXIST, 
                        matCode, sourceUnitCode, targetUnitCode);
            }
        }
        return updateQty;


    }

	

	@Override
	public void freezeInputBinByWCS(DicWhStorageBinKey key) throws WMSException {
		DicWhStorageBin bin = new DicWhStorageBin();
		bin.setWhCode(key.getWhCode());
		bin.setTypeCode(key.getTypeCode());
		bin.setBinCode(key.getBinCode());
		bin.setFreezeInput(EnumFreezeType.FREEZE_WCS_BIN.getValue());
		dicWhStorageBinDao.updateByPrimaryKeySelective(bin);
	}

	@Override
	public void unFreezeInputBinByWCS(DicWhStorageBinKey key) throws WMSException {
		DicWhStorageBin bin = new DicWhStorageBin();
		bin.setWhCode(key.getWhCode());
		bin.setTypeCode(key.getTypeCode());
		bin.setBinCode(key.getBinCode());
		bin.setFreezeInput(EnumFreezeType.FREEZE_NON.getValue());
		dicWhStorageBinDao.updateByPrimaryKeySelective(bin);
	}

	@Override
	public void freezeOutputBinByWCS(DicWhStorageBinKey key) throws WMSException {
		DicWhStorageBin bin = new DicWhStorageBin();
		bin.setWhCode(key.getWhCode());
		bin.setTypeCode(key.getTypeCode());
		bin.setBinCode(key.getBinCode());
		bin.setFreezeOutput(EnumFreezeType.FREEZE_WCS_BIN.getValue());
		dicWhStorageBinDao.updateByPrimaryKeySelective(bin);
	}

	@Override
	public void unFreezeOutputBinByWCS(DicWhStorageBinKey key) throws WMSException {
		DicWhStorageBin bin = new DicWhStorageBin();
		bin.setWhCode(key.getWhCode());
		bin.setTypeCode(key.getTypeCode());
		bin.setBinCode(key.getBinCode());
		bin.setFreezeOutput(EnumFreezeType.FREEZE_NON.getValue());
		dicWhStorageBinDao.updateByPrimaryKeySelective(bin);
	}

	
	
	
	
	

    @Override
    public void doFilterByLanguage(Object object, String langCode) throws WMSException {
        if (object instanceof JSONArray) {
            JSONArray ary = (JSONArray) object;
            for (Object obj : ary) {
                doFilterByLanguage(obj, langCode);
            }
        } else if (object instanceof JSONObject) {
            JSONObject json = (JSONObject) object;
            Set<String> keys = json.keySet();
            String[] array = keys.toArray(new String[keys.size()]);
            for (String key : array) {
                Object value = json.get(key);
                if (key.endsWith(Const.ECEIPT_TYPE) || key.endsWith(Const.ECEIPT_SUB_TYPE)) {
                    String nameKey = key + Const.NAME;
                    Integer receiptType = UtilObject.getIntegerOrNull(value);
                    if (receiptType != null && receiptType > 0 && json.containsKey(nameKey)) {
                        String nameValue = EnumReceiptType.getEnumName(receiptType);
                        if (!UtilString.isNullOrEmpty(nameValue)) {
                            if (json.containsKey(nameKey)) {
                                Object nameObject = json.get(nameKey);
                                if (nameObject == null || nameObject.toString().trim().length() == 0) {
                                    json.put(nameKey, UtilText.getNameMessage(langCode, nameValue));
                                }
                            }
                        }
                    }
                } else if (key.endsWith(Const.STATUS)) {
                    String nameKey = key + Const.NAME;
                    Byte status = UtilObject.getByteOrNull(value);
                    if (status != null && status > 0 && json.containsKey(nameKey)) {
                        String nameValue = EnumReceiptStatus.getEnumName(status);
                        if (!UtilString.isNullOrEmpty(nameValue)) {
                            if (json.containsKey(nameKey)) {
                                Object nameObject = json.get(nameKey);
                                if (nameObject == null || nameObject.toString().trim().length() == 0) {
                                    json.put(nameKey, UtilText.getNameMessage(langCode, nameValue));
                                }
                            }
                        }
                    }
                } else if (key.endsWith(Const.OPERATION_TYPE)) {
                    String nameKey = key + Const.NAME;
                    Byte receipt = UtilObject.getByteOrNull(value);
                    if (receipt != null && receipt > 0 && json.containsKey(nameKey)) {
                        String nameValue = EnumReceiptOperationType.getEnumName(receipt);
                        if (!UtilString.isNullOrEmpty(nameValue)) {
                            if (json.containsKey(nameKey)) {
                                Object nameObject = json.get(nameKey);
                                if (nameObject == null || nameObject.toString().trim().length() == 0) {
                                    json.put(nameKey, UtilText.getNameMessage(langCode, nameValue));
                                }
                            }
                        }
                    }
                } else if (value != null) {
                    if (value instanceof String) {
                        String valueString = (String) value;
                        // i18n开头代表国际化
                        if (valueString.startsWith(Const.I18N_)) {
                            if (valueString.endsWith(Const._MID)) {
                                // mid结尾代表物料国际化
                                String matName = dictionaryServiceSubImpl.getMatI18nNameCache(langCode, valueString);
                                json.put(key, matName);
                            } else if (valueString.endsWith(Const._TID)) {
                                // tid结尾代表其他国际化
                                String name = dictionaryServiceSubImpl.getTextCache(langCode, valueString);
                                json.put(key, name);
                            } else if (valueString.endsWith(Const._MSG)) {
                                // msg结尾代表消息国际化
                                String msg = UtilText.getTextMessage(langCode, valueString);
                                json.put(key, msg);
                            } else if (valueString.endsWith(Const._NAME)) {
                                String bundleName = valueString.substring(5, valueString.length() - 5);
                                String msg = UtilText.getNameMessage(langCode, bundleName);
                                json.put(key, msg);
                            }
                        }
                    } else {
                        doFilterByLanguage(value, langCode);
                    }
                }
            }
        }
    }

    

	@Override
	public Map<Integer, DicReceiptType> getReceiptType() {
		
		return dicReceiptTypeDao.getReceiptTypeMap();
	}

	

}
