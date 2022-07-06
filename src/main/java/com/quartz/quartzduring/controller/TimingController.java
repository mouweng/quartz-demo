package com.quartz.quartzduring.controller;

import com.quartz.quartzduring.scheduler.CronScheduler;
import com.quartz.quartzduring.scheduler.TimingScheduler;
import org.quartz.SchedulerException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.text.ParseException;

/**
 * @author: wengyifan
 * @description:
 * @date: 2022/7/6 11:26 上午
 */
@RestController
@RequestMapping("")
public class TimingController {
    @Autowired
    TimingScheduler timingScheduler;

    @GetMapping("/timingScheduler")
    public String startQuartzJob() throws SchedulerException, ParseException {
        timingScheduler.startJob();
        return "success";
    }
}
