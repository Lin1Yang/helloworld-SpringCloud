package com.inossem.wms.service.common;

import java.util.List;

import com.inossem.wms.common.exception.WMSException;
import com.inossem.wms.model.biz.BizReceiptOperationLog;

public interface IReceiptLogCommonService {
	  
    /**
	 * 保存单据操作日志
	 * @param 
	 * @return
	 */
    void saveBizReceiptOperationLogList(Integer receiptType,String receiptCode,Byte receiptOperationType,String logRemark,Integer userId) throws WMSException;
	
	/**
	 * 根据单据类型和单据号查询单据操作日志
	 * @param receiptType
	 * @param receiptCode
	 * @return
	 */
	public List<BizReceiptOperationLog> getBizReceiptOperationLogList(int receiptType, String receiptCode) throws WMSException;
	
	/**
	 * 根据单据类型和单据号删除单据操作日志
	 * @param receiptType
	 * @param receiptCode
	 * @return
	 */
	void deleteBizReceiptOperationLogList(int receiptType, String receiptCode) throws WMSException;

}
