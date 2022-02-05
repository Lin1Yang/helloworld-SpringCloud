package com.inossem.wms.common.schedule;

import com.inossem.wms.dao.schedule.ConfScheduledMapper;
import com.inossem.wms.model.schedule.ConfScheduled;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.List;

@Service
public class SysJobRunner implements CommandLineRunner {

    private static final Logger log = LoggerFactory.getLogger(SysJobRunner.class);

    private final ConfScheduledMapper scheduledMapper;

    private final CronTaskRegistrar cronTaskRegistrar;


    public SysJobRunner(ConfScheduledMapper scheduledMapper, CronTaskRegistrar cronTaskRegistrar) {
        this.scheduledMapper = scheduledMapper;
        this.cronTaskRegistrar = cronTaskRegistrar;
    }

    @Override
    public void run(String... args) {
        List<ConfScheduled> scheduledList = scheduledMapper.selectScheduledList();
        if(!CollectionUtils.isEmpty(scheduledList)){
            scheduledList.forEach(e -> {
                SchedulingRunnable task = new SchedulingRunnable(e.getTaskClass(),e.getMethod());
                cronTaskRegistrar.addCronTask(task,e.getTaskCron());
            });
            log.info("定时任务加载完毕");
        }

    }
}
