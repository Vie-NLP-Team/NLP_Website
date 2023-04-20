package com.opinion.viopinion.jobs.excute;
import com.opinion.viopinion.jobs.job.ArticleWebJob;
import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;

import static org.quartz.CronScheduleBuilder.cronSchedule;

public class ArticleWebQuartz {

    public static void main(String[] args) throws Exception {
        JobDetail jobDetail = JobBuilder.newJob(ArticleWebJob.class)
                .withIdentity("articleWebJob") //标识
                .build();
        CronTrigger trigger = TriggerBuilder
                .newTrigger()
                .withIdentity("preTrigger") //标识
                .startNow()
                .withSchedule(cronSchedule("0 0 2 1 * ?")) //在每月的1日的凌晨2点执行任务
                .forJob("articleWebJob")
                .build();
        StdSchedulerFactory factory = new StdSchedulerFactory();
        Scheduler scheduler = factory.getScheduler();
        scheduler.start();
        scheduler.scheduleJob(jobDetail, trigger);
    }
}
