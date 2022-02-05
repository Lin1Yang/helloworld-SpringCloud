package com.inossem.wms.dao.dic;

import java.util.List;

import com.inossem.wms.model.dic.DicMaterialGroup;

public interface DicMaterialGroupMapper {
    int deleteByPrimaryKey(String matGroupCode);

    int insert(DicMaterialGroup record);

    int insertSelective(DicMaterialGroup record);
    int insertBatchDicMaterialGroup(List<DicMaterialGroup> list);
    
    int insertOrUpdateDicMaterialGroup(List<DicMaterialGroup> list);

    DicMaterialGroup selectByPrimaryKey(String matGroupCode);

    int updateByPrimaryKeySelective(DicMaterialGroup record);

    int updateByPrimaryKey(DicMaterialGroup record); 
    int updateBatchDicMaterialGroupByPrimaryKey(List<DicMaterialGroup> list);
    
    /**
     * 查询所有物料组
     * @return
     * @author 刘宇 2019年1月10日14:56:40
     */
    List<DicMaterialGroup> selectAllMatGroup();
    
}