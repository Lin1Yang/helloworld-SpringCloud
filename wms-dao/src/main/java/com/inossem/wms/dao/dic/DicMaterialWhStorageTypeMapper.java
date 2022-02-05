package com.inossem.wms.dao.dic;

import java.util.List;

import com.inossem.wms.co.dic.DicMaterialWhInfoCo;
import com.inossem.wms.model.dic.DicMaterialWhKey;
import com.inossem.wms.model.dic.DicMaterialWhStorageType;
import com.inossem.wms.model.dic.DicMaterialWhStorageTypeKey;
import com.inossem.wms.model.dic.DicMaterialWhStorageTypeVo;

public interface DicMaterialWhStorageTypeMapper {
    int deleteByPrimaryKey(DicMaterialWhStorageTypeVo vo);

    int insert(DicMaterialWhStorageType record);

    int insertSelective(DicMaterialWhStorageType record);
    
    int insertBatchDicMaterialWhStorageType(List<DicMaterialWhStorageType> list);

    DicMaterialWhStorageType selectByPrimaryKey(DicMaterialWhStorageTypeKey key);

    int updateByPrimaryKeySelective(DicMaterialWhStorageType record);

    int updateByPrimaryKey(DicMaterialWhStorageType record);

	void deleteByWh(DicMaterialWhInfoCo infoCo);

	List<DicMaterialWhStorageType> getList(DicMaterialWhKey key);
}