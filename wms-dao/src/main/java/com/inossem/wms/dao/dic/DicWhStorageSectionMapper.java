package com.inossem.wms.dao.dic;

import java.util.List;

import com.inossem.wms.co.dic.DicWhStorageSectionCo;
import com.inossem.wms.model.dic.DicDeleteCheckCo;
import com.inossem.wms.model.dic.DicWhStorageSection;
import com.inossem.wms.model.dic.DicWhStorageSectionKey;
import com.inossem.wms.vo.dic.DicWhStorageSectionVo;

public interface DicWhStorageSectionMapper {
    int deleteByPrimaryKey(DicWhStorageSectionKey key);

    int insert(DicWhStorageSection record);

    int insertSelective(DicWhStorageSection record);

    DicWhStorageSection selectByPrimaryKey(DicWhStorageSectionKey key);
    
    int updateByPrimaryKeySelective(DicWhStorageSection record);

    //int updateByPrimaryKey(DicWhStorageSection record);
    
    /**
     * 查询所有	is_delete = 0
     * @return
     */
    List<DicWhStorageSectionVo> selectAllSectionList();
    
    
    /**
     * 分页存储区列表
     * @param co
     * @return
     */
    List<DicWhStorageSectionVo> selectByConditionOnPaging(DicWhStorageSectionCo co);
    
    /**
     * 详情数据
     * @param co
     * @return
     */
    DicWhStorageSectionVo selectDetailByPrimaryKey(DicWhStorageSectionCo co);
    
    
    /**
     * 存储区列表
     * @param co
     * @return
     */
    List<DicWhStorageSectionVo> selectAllWhStorageSectionList(DicWhStorageSectionCo co);
    
    /**
     * 主数据删除校验 是否存在未删除的存储区
     * @param 
     * @return
     */
    List<DicWhStorageSection> selectByDicDeleteCheckCo(DicDeleteCheckCo deleteCheckCo);
    
    /**
     * 按照条件插入或者更新
     * @param dicCorp
     */
    void insertOrUpdateSelective(DicWhStorageSectionCo co);
    
}