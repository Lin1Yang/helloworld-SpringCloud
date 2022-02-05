package com.inossem.wms.dao.conf;

import com.inossem.wms.model.conf.ConfWh;

public interface ConfWhMapper {
    int deleteByPrimaryKey(String confWhCode);

    int insert(ConfWh record);

    int insertSelective(ConfWh record);

    ConfWh selectByPrimaryKey(String confWhCode);

    int updateByPrimaryKeySelective(ConfWh record);

    int updateByPrimaryKey(ConfWh record);
}