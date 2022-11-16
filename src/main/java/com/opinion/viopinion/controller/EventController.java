package com.opinion.viopinion.controller;

import com.opinion.viopinion.entity.Event;
import com.opinion.viopinion.service.EventService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("event")
public class EventController {

    private final EventService eventService;
    public EventController(EventService eventService) {
        this.eventService = eventService;
    }

    /**
     * 通过热点事件周期返回事件列表
     */
    @GetMapping("{news_cycle}")
    public ResponseEntity<List<Event>> queryCycleEvent(@PathVariable("news_cycle") Integer news_cycle) {
        return ResponseEntity.ok(this.eventService.queryCycleEvent(news_cycle));
    }

    /**
     * 返回全部事件内容
     * @param event_id event_id
     * @param title title
     * @param keyword keyword
     * @param abstract2 abstract2
     * @return Event
     */

    @GetMapping("/queryEvent")
    public ResponseEntity<List<Event>> queryEvent(Integer event_id, String title, String keyword, String abstract2){
        return ResponseEntity.ok(this.eventService.queryEvent(event_id,title,keyword,abstract2));
    }



}
