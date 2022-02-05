package com.inossem.wms.dao.dic;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.inossem.wms.model.dic.DicExcelRuleItem;

public interface DicExcelRuleItemMapper {
    int deleteByPrimaryKey(Integer excelRuleItemId);

    int insert(DicExcelRuleItem record);

    int insertSelective(DicExcelRuleItem record);

    DicExcelRuleItem selectByPrimaryKey(Integer excelRuleItemId);

    int updateByPrimaryKeySelective(DicExcelRuleItem record);

    int updateByPrimaryKey(DicExcelRuleItem record);
    
    List<DicExcelRuleItem> selectExcelRuleItemByHeadId (Integer excelRuleHeadId);


    /**
     * 根据 条件查询
     *
     * 插入位置
     * @param param
     * @return
     */
    List<DicExcelRuleItem> selectExcelRuleItemByParams (Map<String,Object> param);


    
    void inserCommonList(HashMap<String,Object> paramMap);
    
}