package com.inossem.wms.dao.schedule;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.inossem.wms.model.schedule.ConfScheduled;

@Repository
public interface ConfScheduledMapper {
    int deleteByPrimaryKey(String taskCode);

    int insert(ConfScheduled record);

    int insertSelective(ConfScheduled record);

    ConfScheduled selectByPrimaryKey(String taskCode);

    int updateByPrimaryKeySelective(ConfScheduled record);

    int updateByPrimaryKey(ConfScheduled record);

    List<ConfScheduled> selectScheduledList();

    /*
    通过主键查询定时任务
     */
    int selectConfScheduledCountByKey(ConfScheduled record);

    /*
    删除任务
     */
    int updateDeleteStatus(ConfScheduled record);

    int updateExecute(ConfScheduled record);

    ConfScheduled selectScheduled(ConfScheduled record);
}
