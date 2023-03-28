package com.opinion.viopinion.service;

import com.opinion.viopinion.entity.dto.EventDto;
import java.util.List;

public interface EventService {

    List<EventDto> queryAllEvent();

    List<EventDto> queryEventByCycle(Integer newsCycle);
}
