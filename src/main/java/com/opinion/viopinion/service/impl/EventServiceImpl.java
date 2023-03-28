package com.opinion.viopinion.service.impl;

import com.opinion.viopinion.entity.dto.EventDto;
import com.opinion.viopinion.repository.EventRepository;
import com.opinion.viopinion.service.EventService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EventServiceImpl implements EventService {

    private final EventRepository eventRepository;
    public EventServiceImpl(EventRepository eventRepository) {
        this.eventRepository = eventRepository;
    }

    @Override
    public List<EventDto> queryAllEvent() {
        return eventRepository.findAll();
    }

    /**
     * 通过热点事件周期返回事件列表
     * @return Event
     */
    @Override
    public List<EventDto> queryEventByCycle(Integer newsCycle) {
        return eventRepository.findEventByNewsCycle(newsCycle);
    }
}
