package com.quartz.quartzduring;

import com.quartz.quartzduring.scheduler.CronScheduler;
import org.junit.jupiter.api.Test;
import org.quartz.SchedulerException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.stereotype.Component;

@SpringBootTest
class QuartzDuringApplicationTests {


    @Test
    void contextLoads() throws SchedulerException {
        CronScheduler.cronScheduler();
    }

}
