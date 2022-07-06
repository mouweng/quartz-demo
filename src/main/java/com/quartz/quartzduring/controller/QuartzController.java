package com.quartz.quartzduring.controller;

import com.quartz.quartzduring.scheduler.QuartzScheduler;
import org.quartz.CronExpression;
import org.quartz.SchedulerException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: wengyifan
 * @description:
 * @date: 2022/7/6 11:03 上午
 */
@RestController
@RequestMapping("")
public class QuartzController {
    @Autowired
    private QuartzScheduler quartzSchedulerManager;

    // @Description: 获取定时器信息
    @GetMapping("/info")
    public String getQuartzJob(String name, String group) {
        String info = null;
        try {
            info = quartzSchedulerManager.getJobInfo(name, group);
        } catch (SchedulerException e) {
            e.printStackTrace();
        }
        return info;
    }

    // @Description: 修改定时器的 执行时间
    @PostMapping("/modify")
    public boolean modifyQuartzJob(String name, String group, String time) {
        boolean flag = true;
        if (!CronExpression.isValidExpression(time)) {
            throw new RuntimeException("非法的cron表达式");
        }
        try {
            flag = quartzSchedulerManager.modifyJob(name, group, time);
        } catch (SchedulerException e) {
            e.printStackTrace();
        }
        return flag;
    }

    // @Description: 启动所有定时器
    @PostMapping("/start")
    public void startQuartzJob() {
        try {
            quartzSchedulerManager.startJob();
        } catch (SchedulerException e) {
            e.printStackTrace();
        }
    }

    // @Description: 暂停指定 定时器
    @PostMapping(value = "/pause")
    public void pauseQuartzJob(String name, String group) {
        try {
            quartzSchedulerManager.pauseJob(name, group);
        } catch (SchedulerException e) {
            e.printStackTrace();
        }
    }

    // 暂停所有定时器
    @PostMapping(value = "/pauseAll")
    public void pauseAllQuartzJob() {
        try {
            quartzSchedulerManager.pauseAllJob();
        } catch (SchedulerException e) {
            e.printStackTrace();
        }
    }

    // @Description: 恢复指定 定时器
    @PostMapping(value = "/resume")
    public void resumeQuartzJob(String name, String group) {
        try {
            quartzSchedulerManager.resumeJob(name, group);
        } catch (SchedulerException e) {
            e.printStackTrace();
        }
    }

    // 暂停所有定时器
    @PostMapping(value = "/resumeAll")
    public void resumeAllQuartzJob() {
        try {
            quartzSchedulerManager.resumeAllJob();
        } catch (SchedulerException e) {
            e.printStackTrace();
        }
    }

    // 删除指定定时器
    @PostMapping(value = "/delete")
    public void deleteJob(String name, String group) {
        try {
            quartzSchedulerManager.deleteJob(name, group);
        } catch (SchedulerException e) {
            e.printStackTrace();
        }
    }

}
