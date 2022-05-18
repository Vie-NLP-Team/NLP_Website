package com.opinion.viopinion.dao;

import com.opinion.viopinion.entity.Month;
import org.apache.ibatis.annotations.Mapper;
import java.util.List;

@Mapper
public interface MonthDao {

    /**
     * 通过热点事件id返回新闻列表
     * @param month_event
     * @return
     */
    List<Month> queryHotPointArticle(Integer month_event);
}
