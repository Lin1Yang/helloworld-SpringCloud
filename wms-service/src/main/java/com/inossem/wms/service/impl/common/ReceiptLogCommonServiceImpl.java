package com.inossem.wms.service.impl.common;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.inossem.wms.common.ReceiptKey;
import com.inossem.wms.common.exception.WMSException;
import com.inossem.wms.common.util.UtilText;
import com.inossem.wms.dao.biz.BizReceiptOperationLogMapper;
import com.inossem.wms.enums.EnumReceiptOperationType;
import com.inossem.wms.model.biz.BizReceiptOperationLog;
import com.inossem.wms.service.common.IReceiptLogCommonService;
@Service
public class ReceiptLogCommonServiceImpl implements IReceiptLogCommonService {
	
	
	@Autowired
	protected BizReceiptOperationLogMapper bizReceiptOperationLogDao;


	@Override
	public void saveBizReceiptOperationLogList(Integer receiptType,String receiptCode,Byte receiptOperationType,String logRemark,Integer userId)
			throws WMSException {		
		BizReceiptOperationLog receiptOperationLog = new BizReceiptOperationLog();
		receiptOperationLog.setReceiptType(receiptType);
		receiptOperationLog.setReceiptCode(receiptCode);
		receiptOperationLog.setReceiptOperationType(receiptOperationType);
		receiptOperationLog.setLogRemark(logRemark);
		receiptOperationLog.setCreateUserId(userId);
		receiptOperationLog.setModifyUserId(userId);
		bizReceiptOperationLogDao.insertSelective(receiptOperationLog);		
	}
	

	@Override
	public List<BizReceiptOperationLog> getBizReceiptOperationLogList(int receiptType, String receiptCode)throws WMSException {
		List<BizReceiptOperationLog>  logList = bizReceiptOperationLogDao.selectByReceipt(new ReceiptKey(receiptType, receiptCode));
		if (logList!=null&&logList.size()>0) {
			for (BizReceiptOperationLog bizReceiptOperationLog : logList) {
				bizReceiptOperationLog.setReceiptOperationTypeName(UtilText.getI18nText(EnumReceiptOperationType.getEnumName(bizReceiptOperationLog.getReceiptOperationType())));
			}
		}
		return logList;
	}


	@Override
	public void deleteBizReceiptOperationLogList(int receiptType, String receiptCode)
			throws WMSException {
		bizReceiptOperationLogDao.deleteByReceipt(new ReceiptKey(receiptType, receiptCode));
	}

}
