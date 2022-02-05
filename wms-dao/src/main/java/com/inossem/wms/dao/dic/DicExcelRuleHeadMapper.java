package com.inossem.wms.dao.dic;

import java.util.List;

import org.apache.poi.ss.formula.functions.T;

import com.inossem.wms.model.dic.DicExcelRuleHead;

public interface DicExcelRuleHeadMapper {
    int deleteByPrimaryKey(Integer excelRuleHeadId);

    int insert(DicExcelRuleHead record);

    int insertSelective(DicExcelRuleHead record);

    DicExcelRuleHead selectByPrimaryKey(Integer excelRuleHeadId);

    int updateByPrimaryKeySelective(DicExcelRuleHead record);

    int updateByPrimaryKey(DicExcelRuleHead record);
    
    /**
     * 根据类型查找要操作的配置
     * @param enumExcelType
     * @return
     */
    List<DicExcelRuleHead> selectExcelRuleByEnumExcelType(String enumExcelType);

    List<DicExcelRuleHead> selectOutputExcelRuleByEnumExcelType(String enumExcelType);


    void insertObjectList(List<T> resultList);
    
    
}