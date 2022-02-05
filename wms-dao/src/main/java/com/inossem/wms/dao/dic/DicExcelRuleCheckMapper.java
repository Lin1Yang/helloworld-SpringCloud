package com.inossem.wms.dao.dic;

import java.util.List;

import com.inossem.wms.model.dic.DicExcelRuleCheck;

public interface DicExcelRuleCheckMapper {
	
    int deleteByPrimaryKey(Integer excelRuleCheckId);

    int insert(DicExcelRuleCheck record);

    int insertSelective(DicExcelRuleCheck record);

    DicExcelRuleCheck selectByPrimaryKey(Integer excelRuleCheckId);

    int updateByPrimaryKeySelective(DicExcelRuleCheck record);

    int updateByPrimaryKey(DicExcelRuleCheck record);
    
    List<DicExcelRuleCheck> selectExcelRuleCheckByHeadId (Integer excelRuleHeadId);
    
}