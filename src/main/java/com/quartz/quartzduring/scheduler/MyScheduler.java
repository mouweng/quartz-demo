package com.quartz.quartzduring.scheduler;

import com.quartz.quartzduring.job.HiJob;
import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;

import java.util.Date;

/**
 * @author: wengyifan
 * @description:
 * @date: 2022/7/6 10:40 上午
 */
public class MyScheduler {
    public static void myScheduler() throws SchedulerException {
        JobDetail build = JobBuilder.newJob(HiJob.class).withIdentity("my_job", "my_group").build();

        CronTrigger c = TriggerBuilder.newTrigger()
                .startAt(new Date())
                .withIdentity("my_job", "my_group")
                .withSchedule(CronScheduleBuilder.cronSchedule("3/5 * * * * ?"))
                .build();

        SchedulerFactory schedulerFactory = new StdSchedulerFactory();
        Scheduler scheduler = schedulerFactory.getScheduler();
        scheduler.scheduleJob(build, c);
        scheduler.start();
    }

    public static void stopMyScheduler() throws SchedulerException {
        //创建SchedulerFactory对象  注意是new的是StdSchedulerFactory Std开头
        SchedulerFactory schedulerFactory = new StdSchedulerFactory();
        //获得Scheduler
        Scheduler scheduler = schedulerFactory.getScheduler();
        //暂停Scheduler
        scheduler.pauseJob(new JobKey("my_job", "my_group"));
        //删除Scheduler
        scheduler.deleteJob(new JobKey("my_job", "my_group"));
    }
}
