package com.inossem.wms.dao.conf;

import java.util.List;

import com.inossem.wms.model.conf.ConfWhAutoTask;
import com.inossem.wms.model.conf.ConfWhAutoTaskKey;

public interface ConfWhAutoTaskMapper {
    int deleteByPrimaryKey(ConfWhAutoTaskKey key);

    int insert(ConfWhAutoTask record);

    int insertSelective(ConfWhAutoTask record);

    ConfWhAutoTask selectByPrimaryKey(ConfWhAutoTaskKey key);

    int updateByPrimaryKeySelective(ConfWhAutoTask record);

    int updateByPrimaryKey(ConfWhAutoTask record);
    
    List<ConfWhAutoTask> selectAll();
}