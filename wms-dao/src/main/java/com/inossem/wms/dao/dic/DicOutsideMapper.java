package com.inossem.wms.dao.dic;

import com.inossem.wms.model.dic.DicOutside;

public interface DicOutsideMapper {
    int deleteByPrimaryKey(Integer userId);

    int insert(DicOutside record);

    int insertSelective(DicOutside record);

    DicOutside selectByPrimaryKey(Integer userId);

    int updateByPrimaryKeySelective(DicOutside record);

    int updateByPrimaryKey(DicOutside record);
}