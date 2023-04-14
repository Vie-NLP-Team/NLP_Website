package com.opinion.viopinion.jobs.job;
import org.quartz.*;

public class ArticleWebJob implements Job {

    @Override
    public void execute(JobExecutionContext context) throws JobExecutionException {
        System.out.println("Hello");
    }
}
