package com.inossem.wms.dao.dic;

import com.inossem.wms.model.dic.DicFreezeReason;

public interface DicFreezeReasonMapper {
	
	/**
	 * 插入冻结原因
	 * 
	 * @param DicFreezeReason
	 * @return 
	 * @author yuely
	 */
	int insertFreezeReason(DicFreezeReason dicFreezeReason);
	/**
	 * 更新冻结原因
	 * 
	 * @param DicFreezeReason
	 * @return 
	 * @author yuely
	 */
	int updateFreezeReason(DicFreezeReason dicFreezeReason);
	
	/**
	 * 查询冻结原因
	 * 
	 * @param DicFreezeReason
	 * @return 
	 * @author yuely
	 */
	DicFreezeReason selectFreezeReasonIsExist(DicFreezeReason dicFreezeReason);
	
}