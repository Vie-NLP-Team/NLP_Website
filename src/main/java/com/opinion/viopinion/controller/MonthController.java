package com.opinion.viopinion.controller;

import com.opinion.viopinion.entity.Month;
import com.opinion.viopinion.service.MonthService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("montharticle")
public class MonthController {

    @Resource
    private MonthService monthService;

    /**
     * 通过热点事件id返回新闻列表
     */
    @GetMapping("{month_event}")
    public ResponseEntity<List<Month>> queryHotPointArticle(@PathVariable("month_event") Integer month_event) {
        return ResponseEntity.ok(this.monthService.queryHotPointArticle(month_event));
    }
}
