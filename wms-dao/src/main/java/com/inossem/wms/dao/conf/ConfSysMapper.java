package com.inossem.wms.dao.conf;

import com.inossem.wms.model.conf.ConfSys;

public interface ConfSysMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(ConfSys record);

    int insertSelective(ConfSys record);

    ConfSys selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(ConfSys record);

    int updateByPrimaryKey(ConfSys record);
    
    ConfSys selectLimit1();
    ConfSys selectMaxCorp();
    ConfSys selectMaxWh();
}