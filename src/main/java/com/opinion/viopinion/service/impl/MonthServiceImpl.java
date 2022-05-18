package com.opinion.viopinion.service.impl;

import com.opinion.viopinion.dao.MonthDao;

import com.opinion.viopinion.entity.Month;
import com.opinion.viopinion.service.MonthService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;


@Service("monthService")
public class MonthServiceImpl implements MonthService {


    @Resource
    private MonthDao monthDao;
    /**
     * 热点事件操作
     * 通过热点事件id返回新闻列表(再加上摘要文章内容和url)
     */
    @Override
    public List<Month> queryHotPointArticle(Integer month_event) {
        return this.monthDao.queryHotPointArticle(month_event);
    }
}
