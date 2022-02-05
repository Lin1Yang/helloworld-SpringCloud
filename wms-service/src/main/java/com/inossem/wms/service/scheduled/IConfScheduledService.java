package com.inossem.wms.service.scheduled;


import com.inossem.wms.model.schedule.ConfScheduled;

public interface IConfScheduledService {


    /*
    添加定时任务
     */
    boolean addScheduled(ConfScheduled scheduled);

    /*
    修改定时任务
     */
    boolean editScheduled(ConfScheduled scheduled);

    /*
    删除定时任务
     */
    boolean removeScheduled(ConfScheduled scheduled);

    /*
    启动，停止任务
     */
    boolean changeExecute(ConfScheduled scheduled);
}
