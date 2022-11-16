package com.opinion.viopinion.service.impl;

import com.opinion.viopinion.dao.EventDao;
import com.opinion.viopinion.entity.Event;
import com.opinion.viopinion.service.EventService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service("eventService")
public class EventServiceImpl implements EventService {
    @Resource
    private EventDao eventDao;

    @Override
    public List<Event> queryEvent(Integer event_id, String title, String keyword, String abstract2){return eventDao.queryEvent(event_id,title,keyword,abstract2);}


    /**
     * 通过热点事件周期返回事件列表
     * @param news_cycle news_cycle
     * @return Event
     */

    @Override
    public List<Event> queryCycleEvent(Integer news_cycle) {
        return this.eventDao.queryCycleEvent(news_cycle);
    }
}
