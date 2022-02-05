package com.inossem.wms.dao.dic;

import java.util.List;

import com.inossem.wms.model.dic.DicWhStorageBinType;

public interface DicWhStorageBinTypeMapper {
	
	/**
	 * 插入冻结原因
	 * 
	 * @param DicFreezeReason
	 * @return 
	 * @author yuely
	 */
	int insertWhStorageBinType(DicWhStorageBinType dicWhStorageBinType);
	/**
	 * 更新冻结原因
	 * 
	 * @param DicFreezeReason
	 * @return 
	 * @author yuely
	 */
	int updateWhStorageBinType(DicWhStorageBinType dicWhStorageBinType);
	
	/**
	 * 查询仓位类型
	 * 
	 * @param DicFreezeReason
	 * @return 
	 * @author yuely
	 */
	DicWhStorageBinType selectWhStorageBinTypeIsExist(DicWhStorageBinType dicWhStorageBinType);
	
	/**
	 * 查询仓位类型列表
	 * 
	 * @param 
	 * @return 
	 * @author yuely
	 */
	List<DicWhStorageBinType> selectAllWhStorageBinTypeList();
	
}