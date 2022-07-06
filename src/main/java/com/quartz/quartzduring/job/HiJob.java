package com.quartz.quartzduring.job;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author: wengyifan
 * @description:
 * @date: 2022/7/5 5:19 下午
 */
public class HiJob implements Job {
    @Override
    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String nowTime = simpleDateFormat.format(new Date());
        //这里为了演示, 只进行打印
        System.out.println(nowTime + ":你好");
    }
}
