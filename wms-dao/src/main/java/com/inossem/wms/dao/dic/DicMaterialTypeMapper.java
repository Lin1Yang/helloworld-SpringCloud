package com.inossem.wms.dao.dic;

import java.util.List;

import com.inossem.wms.model.dic.DicMaterialType;

public interface DicMaterialTypeMapper {
    int deleteByPrimaryKey(String matTypeCode);

    int insert(DicMaterialType record);

    int insertSelective(DicMaterialType record);
    
    int insertBatchDicMaterialType(List<DicMaterialType> list);

    DicMaterialType selectByPrimaryKey(String matTypeCode);

    int updateByPrimaryKeySelective(DicMaterialType record);

    int updateByPrimaryKey(DicMaterialType record);
    
    int updateBatchDicMaterialTypeByPrimaryKey(List<DicMaterialType> list); 
    /**
     * 获取所以物料类型 
     * @return
     * @author 刘宇 2019-1-10 10:40:39
     */
    List<DicMaterialType> selectAllMatType();
    
    
}