package com.inossem.wms.dao.conf;

import java.util.List;

import com.inossem.wms.co.conf.MqRetryListCo;
import com.inossem.wms.vo.conf.MqRetryVo;

public interface MqRetryMapper {
	
	List<MqRetryVo> selectOnPaging(MqRetryListCo co);
	
    int deleteByPrimaryKey(Long id);

    int insert(MqRetryVo record);

    MqRetryVo selectByPrimaryKey(Long id);

    int updateRetryTimes(Long id);
}