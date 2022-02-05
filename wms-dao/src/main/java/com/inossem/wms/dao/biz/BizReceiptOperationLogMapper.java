package com.inossem.wms.dao.biz;

import java.util.List;

import com.inossem.wms.co.biz.BizReceiptOperationLogCo;
import com.inossem.wms.common.ReceiptKey;
import com.inossem.wms.model.biz.BizReceiptOperationLog;
import com.inossem.wms.model.biz.BizReceiptOperationLogVo;

public interface BizReceiptOperationLogMapper {
    int deleteByPrimaryKey(Integer receiptLogId);

    int insert(BizReceiptOperationLog record);

    int insertSelective(BizReceiptOperationLog record);

    BizReceiptOperationLog selectByPrimaryKey(Integer receiptLogId);

    int updateByPrimaryKeySelective(BizReceiptOperationLog record);

    //int updateByPrimaryKey(BizReceiptOperationLog record);
    
    List<BizReceiptOperationLog> selectByReceipt(ReceiptKey key);
    
    int deleteByReceipt(ReceiptKey key);
    
    /**
	 * 查询仓储作业申请明细表是否有当前仓库号
	 * 
	 * @param String
	 * @return 
	 * @author yuely
	 */
    BizReceiptOperationLog whCodeIsExistCheck(String whCode);
    
    /**
     * 单据操作日志列表查询
     * @param condition
     * @return
     */
    List<BizReceiptOperationLogVo> selectReceiptByConditionOnPaging(BizReceiptOperationLogCo condition);
}