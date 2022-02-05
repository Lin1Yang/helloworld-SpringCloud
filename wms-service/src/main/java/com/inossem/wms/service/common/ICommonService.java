package com.inossem.wms.service.common;


import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.inossem.wms.co.dic.DicMaterialWhInfoCo;
import com.inossem.wms.co.sys.SysUserInfoCo;
import com.inossem.wms.common.auth.CurrentUser;
import com.inossem.wms.common.exception.WMSException;
import com.inossem.wms.model.biz.BizHeadRemark;
import com.inossem.wms.model.dic.DicMaterialWhKey;
import com.inossem.wms.model.dic.DicNoticeVo;
import com.inossem.wms.model.dic.DicReceiptType;
import com.inossem.wms.model.dic.DicUnit;
import com.inossem.wms.model.dic.DicWhStorageBinKey;
import com.inossem.wms.model.rel.RelReceiptRidKey;
import com.inossem.wms.model.sys.SysUser;

public interface ICommonService {

	/**
	 * 根据流水号求下一位流水
	 * 详细方法见数据库next_value 函数
	 * @param sequenceCode	流水code
	 * @return
	 */
	public String getNextSequenceValue(String sequenceCode) throws WMSException;
	
	/**
	 * 根据流水号取当天的流水
	 * 详细方法见数据库next_value_daily 函数
	 * @param sequenceCode	流水code
	 * @return
	 */
	public String getNextSequenceValueDaily(String sequenceCode) throws WMSException;
	
	/**
	 * 获取下一个批次
	 * @return
	 * @throws Exception
	 */
	public String getBatch() throws WMSException;
	
	
	
	/**
	 * 获取下一个批次号（按日期流水取）
	 * @return
	 * @throws Exception
	 */
	public String getBatchDaily() throws WMSException;
	
	
	
	/**
	 * 查询单据抬头备注
	 * @param BizHeadRemark	(receiptType receiptCode)
	 * @return
	 * @throws Exception
	 */
	public BizHeadRemark getHeadRemark(BizHeadRemark headRemark) throws WMSException;
	
	/**
	 * 新增修改抬头备注
	 * @param headRemark
	 * @return
	 * @throws WMSException
	 */
	public void editHeadRemark(BizHeadRemark headRemark) throws WMSException;
	
	
	
	
	
	/**
	 * 同一单据号单据类型 只能存在一种后续单据号   当删除单据时   应查询采购订单是否还存在有效单据 有不删除  无 删除
	 * @param relReceipt
	 * @throws Exception
	 */
	public Boolean canCreateNextType(RelReceiptRidKey relReceiptRid) throws WMSException;


	
	
	
	
	/**
	 * 获取入库单据类型
	 * @return
	 * @throws WMSException
	 */
	List<Integer> getInputReceiptType() throws WMSException;

	

	/**
	 * 获取出库单据类型
	 * @return
	 * @throws WMSException
	 */
	List<Integer> getOutputReceiptType()  throws WMSException;
	
	
	

	

	/**
     * 查询所有单位下拉
     * @return
     * @author lys
     */
	List<DicUnit> getAllUnitList()throws WMSException;
	
	/**
	 * 获取公告滚动  未删除且发布
	 * @return
	 * @author cdq
	 */
	List<DicNoticeVo> getByConditionDicnoticeList() ;

	/**
	 * 是否是临时存储类型
	 * @param typeCode
	 * @return
	 */
	boolean isDefaultType(String typeCode);
	

	
    
    /**
     * 获取最新通知
     * @return
     */
	DicNoticeVo getNewByConditionDicnotice();
    
   
    
	/**
	 * 查询用户是否存在
	 * 
	 * @author lys 2018年12月28日19:26:30
	 * @return
	 * @throws WMSException
	 */
	boolean checkSysUserExist(String userCode) throws WMSException;
		
	/**
	 * 送货通知：注册
	 * 
	 * @author lys 2018年12月28日19:26:30
	 * @return
	 * @throws WMSException
	 */
	void registerSysUser(SysUserInfoCo infoCo,Integer userId) throws WMSException;
	    
	


	
	
	
	
	/**
	 * 获取物料凭证行项目rid
	 * @param matDocRid
	 * @return
	 * @throws WMSException
	 */
	String getMatDocRid(Integer matDocRid) throws WMSException;
	
	/**
	 * 获取单据已完成状态 时的行项目状态set
	 * @return
	 * @throws WMSException
	 */
	Set<Byte> getCompletedItemStatusSet() throws WMSException;
	
	/**
	 * 获取单据核销中状态 时的行项目状态set
	 * @return
	 * @throws WMSException
	 */
	Set<Byte> getDoingDebtOffsetItemStatusSet() throws WMSException;
	
	
	/**
	 * 获取单据已作业状态 时的行项目状态set
	 * @return
	 * @throws WMSException
	 */
	Set<Byte> getTaskedItemStatusSet() throws WMSException;
	/**
	 * 根据业务单据类型获取当前业务单据是否需要经办人 0 不需要 1需要
	 * @return
	 * @throws WMSException
	 */
	Byte actorRequired(Integer receiptType) throws WMSException;
	

	/**
	 * 根据仓库号,物料号查询仓库物料配置信息
	 */
	DicMaterialWhInfoCo getMaterialWhByKey(DicMaterialWhKey key) throws WMSException;


	/**
	 * 根据用户id查询用户
	 * @param userId
	 * @return
	 * @throws WMSException
	 */
	SysUser getUserById(Integer userId) throws WMSException;
	
	
	
	
	
	

	

    /**
	 * 判断单据类型是否为入库
	 * @param receiptType
	 * @return
	 * @throws WMSException
	 */
	boolean isInput(Integer receiptType) throws WMSException;
	
	/**
	 * 判断单据类型是否为出库
	 * @param receiptType
	 * @return
	 * @throws WMSException
	 */
	boolean isOutput(Integer receiptType) throws WMSException;
	
	

	/**
	 * 获取转换后的数量
	 * @param ftyCode
	 * @param sourceUnitCode	原单位
	 * @param targetUnitCode	目标单位
	 * @param sourceQty			原数量
	 * @return
	 * @throws WMSException
	 */
	BigDecimal getActualQty(String ftyCode,String matCode,String sourceUnitCode ,String targetUnitCode, BigDecimal sourceQty ) throws WMSException;

	
	
	
	
	/**
	 * 获取转换单位后的数量
	 * @param sourceUnitCode
	 * @param targetUnitCode
	 * @param matCode
	 * @param ftyCode
	 * @param qty
	 * @return
	 * @throws WMSException
	 */
	BigDecimal getRelUnitQty(String sourceUnitCode,String targetUnitCode, String matCode ,String ftyCode ,BigDecimal qty) throws WMSException;

	/**
	 * 用于根据userid获取CurrentUser对象的结构数据
	 * <p>注意</p>
	 * <p>这个方法与当前登录用户无关，仅根据提供的用户id来查询用户表</p>
	 * 
	 * @param userId
	 * @return
	 * @author libin
	 */
	CurrentUser getCurrentUserBeanById(Integer userId);
	

	
	

	/**
	 * WCS生成指令时冻结仓位入库标识
	 * @param key 
	 * @throws WMSException
	 */
	void freezeInputBinByWCS(DicWhStorageBinKey key)throws WMSException;
	/**
	 * WCS完成、删除指令时解冻仓位入库标识
	 * @param key
	 * @throws WMSException
	 */
	void unFreezeInputBinByWCS(DicWhStorageBinKey key)throws WMSException;
	/**
	 * WCS生成指令时冻结仓位出库标识
	 * @param key
	 * @throws WMSException
	 */
	void freezeOutputBinByWCS(DicWhStorageBinKey key)throws WMSException;
	/**
	 * WCS完成、删除指令时解冻仓位出库标识
	 * @param key
	 * @throws WMSException
	 */
	void unFreezeOutputBinByWCS(DicWhStorageBinKey key)throws WMSException;
	
	
	
	
	
	

	/**
	 * 处理国际化 递归转换i18n的值
	 * @param object 待转换对象
	 * @param langCode 语言码
	 */
	public void doFilterByLanguage(Object object, String langCode)throws WMSException;

	

	
	public Map<Integer, DicReceiptType> getReceiptType();

}
