package com.opinion.viopinion.jobs.job;
import com.opinion.viopinion.service.impl.ArticleServiceImpl;
import org.quartz.*;

public class ArticleWebJob implements Job {

    private final ArticleServiceImpl articleServiceImpl;
    public ArticleWebJob(ArticleServiceImpl articleServiceImpl) {
        this.articleServiceImpl = articleServiceImpl;
    }

    @Override
    public void execute(JobExecutionContext context) {
        articleServiceImpl.articleAndWebUpdate();
    }
}
