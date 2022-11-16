package com.opinion.viopinion.dao;

import com.opinion.viopinion.entity.Event;
import org.apache.ibatis.annotations.Mapper;
import java.util.List;

@Mapper
public interface EventDao {

    List<Event> queryEvent(Integer event_id, String title, String keyword, String abstract2);


    /**
     * 通过热点事件周期返回事件列表
     * @param news_cycle news_cycle
     * @return Event
     */
    List<Event> queryCycleEvent(Integer news_cycle);
}
