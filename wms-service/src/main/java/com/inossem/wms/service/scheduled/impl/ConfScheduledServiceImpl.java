package com.inossem.wms.service.scheduled.impl;


import com.inossem.wms.common.exception.WMSException;
import com.inossem.wms.common.schedule.CronTaskRegistrar;
import com.inossem.wms.common.schedule.SchedulingRunnable;
import com.inossem.wms.dao.schedule.ConfScheduledMapper;
import com.inossem.wms.enums.EnumReturnCode;
import com.inossem.wms.enums.EnumScheduledExecute;
import com.inossem.wms.model.schedule.ConfScheduled;
import com.inossem.wms.service.scheduled.IConfScheduledService;
import org.springframework.stereotype.Service;

/**
 * 马永康，定时任务
 */
@Service
public class ConfScheduledServiceImpl implements IConfScheduledService {

    private final ConfScheduledMapper confScheduledMapper;

    private final CronTaskRegistrar cronTaskRegistrar;

    public ConfScheduledServiceImpl(ConfScheduledMapper confScheduledMapper, CronTaskRegistrar cronTaskRegistrar) {
        this.confScheduledMapper = confScheduledMapper;
        this.cronTaskRegistrar = cronTaskRegistrar;
    }

    /**
     * 添加任务
     * @param scheduled 定时任务
     * @return boolean
     */
    @Override
    public boolean addScheduled(ConfScheduled scheduled) {
        //用taskClass,和method做主键，判读是否存在同样的任务
        if (confScheduledMapper.selectConfScheduledCountByKey(scheduled) > 0) {
            throw new WMSException(EnumReturnCode.RETURN_CODE_SCHEDULED_IS_EXISTED);
        }
        boolean success = confScheduledMapper.insertSelective(scheduled) > 0;
        //如果添加状态为执行状态直接启用
        if(EnumScheduledExecute.ENUM_SCHEDULED_IS_EXECUTE.getValue().equals(scheduled.getExecute())){
            SchedulingRunnable task = new SchedulingRunnable(scheduled.getTaskClass(),scheduled.getMethod());
            cronTaskRegistrar.addCronTask(task,scheduled.getTaskCron());
        }
        return success;
    }

    /**
     * 更新任务
     * @param scheduled 定时任务
     * @return boolean
     */
    @Override
    public boolean editScheduled(ConfScheduled scheduled) {

        if (confScheduledMapper.selectConfScheduledCountByKey(scheduled) > 1) {
            throw new WMSException(EnumReturnCode.RETURN_CODE_SCHEDULED_IS_EXISTED);
        }
        boolean success = confScheduledMapper.updateByPrimaryKeySelective(scheduled) > 0;

        //先移除再添加,编辑页不允许修改定时任务的类名和方法名，不允许修改状态
        SchedulingRunnable task = new SchedulingRunnable(scheduled.getTaskClass(),scheduled.getMethod());
        cronTaskRegistrar.removeCronTask(task);
        cronTaskRegistrar.addCronTask(task,scheduled.getTaskCron());
        return success;
    }

    /**
     * 删除任务
     * @param scheduled 定时任务
     * @return boolean
     */
    @Override
    public boolean removeScheduled(ConfScheduled scheduled) {
        boolean success = confScheduledMapper.updateDeleteStatus(scheduled) > 0;

        //如果任务是启动状态则先删除任务
        if(EnumScheduledExecute.ENUM_SCHEDULED_IS_EXECUTE.getValue().equals(scheduled.getExecute())){
            SchedulingRunnable task = new SchedulingRunnable(scheduled.getTaskClass(),scheduled.getMethod());
            cronTaskRegistrar.removeCronTask(task);
        }
        return success;
    }

    @Override
    public boolean changeExecute(ConfScheduled scheduled) {
        //判断是启动还是停止
        SchedulingRunnable task = new SchedulingRunnable(scheduled.getTaskClass(),scheduled.getMethod());
        confScheduledMapper.updateExecute(scheduled);
        //从数据库获取一遍最新定时信息
        ConfScheduled now = confScheduledMapper.selectScheduled(scheduled);
        if(EnumScheduledExecute.ENUM_SCHEDULED_IS_EXECUTE.getValue().equals(now.getExecute())){
            cronTaskRegistrar.addCronTask(task,now.getTaskCron());
        }else {
            cronTaskRegistrar.removeCronTask(task);
        }
        return true;
    }
}
