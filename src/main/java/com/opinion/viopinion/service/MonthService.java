package com.opinion.viopinion.service;

import com.opinion.viopinion.entity.Month;
import java.util.List;

public interface MonthService {

    /**
     * 热点事件操作
     * 通过热点事件id返回新闻列表(再加上摘要文章内容和url)
     */

    List<Month> queryHotPointArticle(Integer month_event);
}
