package com.quartz.quartzduring.controller;

import com.quartz.quartzduring.scheduler.CronScheduler;
import com.quartz.quartzduring.scheduler.MyScheduler;
import org.quartz.SchedulerException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: wengyifan
 * @description:
 * @date: 2022/7/5 5:55 下午
 */
@RestController
@RequestMapping("")
public class testController {

    @GetMapping("/cronScheduler")
    public String startQuartzJob() throws SchedulerException {
        CronScheduler.cronScheduler();
        return "success";
    }

    @GetMapping("/stopScheduler")
    public String stopQuartzJob() throws SchedulerException {
        CronScheduler.stopScheduler();
        return "success";
    }

    @GetMapping("/myScheduler")
    public String myQuartzJob() throws SchedulerException {
        MyScheduler.myScheduler();
        return "success";
    }
    @GetMapping("/stopMyScheduler")
    public String stopMyQuartzJob() throws SchedulerException {
        MyScheduler.stopMyScheduler();
        return "success";
    }

}
