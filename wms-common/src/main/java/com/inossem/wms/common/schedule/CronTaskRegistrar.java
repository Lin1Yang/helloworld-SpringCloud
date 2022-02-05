package com.inossem.wms.common.schedule;


import org.springframework.beans.factory.DisposableBean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.TaskScheduler;
import org.springframework.scheduling.config.CronTask;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 马永康，定时任务功能类
 */

@Configuration
public class CronTaskRegistrar implements DisposableBean {

    private final TaskScheduler taskScheduler;

    //任务池
    private static final Map<Runnable, ScheduledTask> scheduledTaskMap = new ConcurrentHashMap<>(16);

    public CronTaskRegistrar(TaskScheduler taskScheduler) {
        this.taskScheduler = taskScheduler;
    }

    /*
    添加定时任务
     */
    public void addCronTask(Runnable task, String cron){
        addCronTask(new CronTask(task,cron));
    }

    public void addCronTask(CronTask cronTask){
        if(cronTask != null){
            Runnable task = cronTask.getRunnable();
            if(scheduledTaskMap.containsKey(task)){
                removeCronTask(task);
            }
            scheduledTaskMap.put(task,scheduledCronTask(cronTask));
        }
    }


    /**
     * 移除任务
     * @param task 任务
     */
    public void removeCronTask(Runnable task){
        ScheduledTask scheduledTask = scheduledTaskMap.remove(task);
        if(scheduledTask != null){
            scheduledTask.cancel();
        }
    }

    public ScheduledTask scheduledCronTask(CronTask cronTask){
        ScheduledTask scheduledTask = new ScheduledTask();
        scheduledTask.future= this.taskScheduler.schedule(cronTask.getRunnable(),cronTask.getTrigger());
        return scheduledTask;
    }


    /*
    销毁
     */
    @Override
    public void destroy() throws Exception {
        for(ScheduledTask task : scheduledTaskMap.values()){
            task.cancel();
        }
        scheduledTaskMap.clear();
    }


}
