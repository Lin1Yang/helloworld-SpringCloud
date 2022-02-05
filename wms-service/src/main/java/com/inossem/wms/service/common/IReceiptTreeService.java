package com.inossem.wms.service.common;

import java.util.List;

import com.inossem.wms.common.exception.WMSException;
import com.inossem.wms.model.rel.RelReceiptRidKey;
import com.inossem.wms.vo.rel.RelReceiptRidVo;

public interface IReceiptTreeService {
	
	/**
	 * 单条新增单据流
	 * @param RelReceiptRidKey rel 
	 */
	void  addReceiptTree(RelReceiptRidKey rel) throws WMSException;
	
	/**
	 * 批量新增单据流
	 * @param RelReceiptRidKey rel 
	 */
	void  addReceiptTree(List<RelReceiptRidKey> list) throws WMSException;
	
	/**
	 * 根据单据类型和单号删除单据流
	 * @param receiptCode
	 * @param receiptType
	 */
	void  deleteReceiptTree(Integer receiptType,String receiptCode) throws WMSException;
	
	/**
	 * 根据单据类型和单号和行项目删除单据流
	 * @param receiptCode
	 * @param receiptType
	 */
	void  deleteReceiptRidTree(Integer receiptType,String receiptCode,List<String> receiptRidList) throws WMSException;
	
	/**
	 * 根据单据类型和单号和行号集合查询 单据流
	 * @throws WMSException
	 */
	List<RelReceiptRidVo> getReceiptTree(Integer receiptType, String receiptCode,List<String> receiptRidList) throws WMSException;

}
