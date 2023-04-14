package com.opinion.viopinion.controller.crud;

import com.opinion.viopinion.entity.dto.EventDto;
import com.opinion.viopinion.service.impl.EventServiceImpl;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

/**
 * (Event)表控制层
 * @since 2023-03-06 11:52:25
 */
@RestController
@RequestMapping("event")
public class EventController {

    private final EventServiceImpl eventServiceImpl;
    public EventController(EventServiceImpl eventServiceImpl) {
        this.eventServiceImpl = eventServiceImpl;
    }

    /**
     * 返回全部事件内容
     *
     * @return Event
     */
    @GetMapping
    public ResponseEntity<List<EventDto>> queryEvent() {
        return ResponseEntity.ok(eventServiceImpl.queryAllEvent());
    }

    /**
     * 通过热点事件周期返回事件列表
     *
     * @param newsCycle news_cycle
     * @return Event
     */
    @GetMapping("{newscycle}")
    public ResponseEntity<List<EventDto>> queryCycleEvent(@PathVariable("newscycle") Integer newsCycle) {
        return ResponseEntity.ok(eventServiceImpl.queryEventByCycle(newsCycle));
    }
}
