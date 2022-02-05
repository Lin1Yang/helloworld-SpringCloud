package com.inossem.wms.service.job.impl;

import com.inossem.wms.service.job.ISyncTaskService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

/**
 * @ClassName SyncTaskServiceImpl
 * @Description 
 * @Author wsail
 * @Date 2020/3/20 12:09
 **/
@Service
public class SyncTaskServiceImpl implements ISyncTaskService {

    private static final Logger log = LoggerFactory.getLogger(SyncTaskServiceImpl.class);

    @Override
    public void test() {
        //log.error("定时任务触发了！！");
    }
}
