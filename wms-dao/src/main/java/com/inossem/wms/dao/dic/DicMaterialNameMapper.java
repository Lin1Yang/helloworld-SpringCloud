package com.inossem.wms.dao.dic;

import java.util.List;

import com.inossem.wms.model.dic.DicMaterialName;
import com.inossem.wms.model.dic.DicMaterialNameKey;

public interface DicMaterialNameMapper {
	int deleteByPrimaryKey(DicMaterialNameKey key);

	int insert(DicMaterialName record);

	int insertSelective(DicMaterialName record);
	int insertBatchDicMaterialNames(List<DicMaterialName> list);
	

	DicMaterialName selectByPrimaryKey(DicMaterialNameKey key);

	int updateByPrimaryKeySelective(DicMaterialName record);

	int updateByPrimaryKey(DicMaterialName record);
	int updateBatchDicMaterialNamesByPrimaryKey(List<DicMaterialName> list);

	List<DicMaterialName> select();
	
	/**
	 * 查询物料多语言
	 * @param matCode
	 * @return
	 * @author 刘宇 2019-1-29 12:08:40
	 */
	List<DicMaterialName> selectDicMaterialNameByMatCode(String matCode);
	
	/**
	 * 逻辑删除物料名称
	 * @param matCode
	 * @return
	 */
	int deleteByTid(String tid);
	
}