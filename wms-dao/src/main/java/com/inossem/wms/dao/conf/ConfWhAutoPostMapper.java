package com.inossem.wms.dao.conf;

import java.util.List;

import com.inossem.wms.model.conf.ConfWhAutoPost;
import com.inossem.wms.model.conf.ConfWhAutoPostKey;

public interface ConfWhAutoPostMapper {
    int deleteByPrimaryKey(ConfWhAutoPostKey key);

    int insert(ConfWhAutoPost record);

    int insertSelective(ConfWhAutoPost record);

    ConfWhAutoPost selectByPrimaryKey(ConfWhAutoPostKey key);

    int updateByPrimaryKeySelective(ConfWhAutoPost record);

    int updateByPrimaryKey(ConfWhAutoPost record);
    
    List<ConfWhAutoPost> selectAll();
}