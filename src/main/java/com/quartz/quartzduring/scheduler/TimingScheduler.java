package com.quartz.quartzduring.scheduler;

import com.quartz.quartzduring.job.HiJob;
import org.quartz.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

/**
 * @author: wengyifan
 * @description:
 * @date: 2022/7/6 11:18 上午
 */
@Component
public class TimingScheduler {
    @Autowired
    private Scheduler scheduler;


    public void startJob() throws SchedulerException, ParseException {
        TimeZone.setDefault(TimeZone.getTimeZone("Asia/Shanghai"));
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String input = "2022-07-06 11:36:00";
        Date t = simpleDateFormat.parse(input);

        SimpleTrigger simple= TriggerBuilder.newTrigger()
                .withIdentity("job5","group5")
                .startAt(t)
                .withSchedule(
                        SimpleScheduleBuilder.simpleSchedule()
                                .withIntervalInSeconds(0)
                                .withRepeatCount(0))
                .build();

        JobDetail jobDetail=JobBuilder.newJob(HiJob.class).withIdentity("job5","group5").build();

        scheduler.scheduleJob(jobDetail,simple);
        scheduler.start();
    }
}
