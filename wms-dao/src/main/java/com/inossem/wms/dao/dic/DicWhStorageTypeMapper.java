package com.inossem.wms.dao.dic;

import java.util.List;

import com.inossem.wms.co.dic.DicWhStorageTypeListCo;
import com.inossem.wms.model.dic.DicWhStorageType;
import com.inossem.wms.model.dic.DicWhStorageTypeKey;
import com.inossem.wms.vo.auth.DicWhStorageTypeTreeVo;
import com.inossem.wms.vo.dic.DicWhStorageTypeVo;

public interface DicWhStorageTypeMapper {
	int deleteByPrimaryKey(DicWhStorageTypeKey key);

	int insert(DicWhStorageType record);

	int insertSelective(DicWhStorageType record);

	DicWhStorageType selectByPrimaryKey(DicWhStorageTypeKey key);

	int updateByPrimaryKeySelective(DicWhStorageType record);

	// int updateByPrimaryKey(DicWhStorageType record);

	/**
	 * 查询所有 is_delete = 0
	 * 
	 * @return
	 */
	List<DicWhStorageTypeVo> selectAllTypeList();

	/**
	 * 仓库号查询存储类型列表
	 * 
	 * @param whCode
	 * @return
	 */
	List<DicWhStorageTypeTreeVo> selectDicWhStorageTypeTreeVoByWhCode(String whCode);

	/**
	 * 仓库号列表查询存储类型列表
	 * 
	 * @param whCodeList
	 * @return
	 */
	List<DicWhStorageTypeTreeVo> selectDicWhStorageTypeTreeVoByWhCodeList(List<String> whCodeList);
	
	/**
	 * 查询存储类型列表
	 * 
	 * @param DicWhStorageTypeListCo
	 * @return DicWhStorageTypeTreeVo
	 * @author yuely
	 */
	List<DicWhStorageTypeVo> selectDicWhStorageTypeVoOnPaging(DicWhStorageTypeListCo co);
	
	/**
	 * 查询仓库号和存储类型是否存在
	 * 
	 * @param DicWhStorageTypeListCo
	 * @return DicWhStorageTypeVo
	 * @author yuely
	 */
	DicWhStorageTypeVo selectWhStorageTypeCodeIsExist(DicWhStorageTypeListCo co);
	
	
	/**
	 * 保存存储类型
	 * 
	 * @param DicWhStorageTypeListCo
	 * @return 
	 * @author yuely
	 */
	int insertWhStorageType(DicWhStorageTypeVo vo);
	
	/**
	 * 修改存储类型
	 * 
	 * @param DicWhStorageTypeListCo
	 * @return 
	 * @author yuely
	 */
	int updateWhStorageType(DicWhStorageTypeVo vo);
	
	/**
	 * 修改存储类型的状态
	 * 
	 * @param DicWhStorageTypeVo
	 * @return 
	 * @author yuely
	 */
	int deleteWhStorageType(DicWhStorageTypeVo vo);
	
	/**
	 * 查询仓库号、存储类型信息
	 * 
	 * @param DicWhStorageTypeListCo
	 * @return DicWhStorageTypeVo
	 * @author yuely
	 */
	DicWhStorageTypeVo getWhStorageTypeInfo(DicWhStorageTypeListCo co);
	
	/**
	 * 查询存储类型列表
	 * 
	 * @param DicWhStorageTypeListCo
	 * @return DicWhStorageTypeVo
	 * @author yuely
	 */
	List<DicWhStorageTypeVo> getAllStorageTypeList(DicWhStorageTypeListCo co);
	
	
	int insertOrUpdateWhStorageType(DicWhStorageType record);
}