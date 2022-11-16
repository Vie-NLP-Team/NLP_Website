package com.opinion.viopinion.service;

import com.opinion.viopinion.entity.Event;

import java.util.List;

public interface EventService {

    List<Event> queryEvent(Integer event_id, String title, String keyword, String abstract2);

    /**
     * 通过热点事件周期返回事件列表
     * @param news_cycle news_cycle
     * @return Event
     */
    List<Event> queryCycleEvent(Integer news_cycle);
}
