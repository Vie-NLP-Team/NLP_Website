package com.opinion.viopinion.controller.crud;

import com.opinion.viopinion.entity.vo.MonthVo;
import com.opinion.viopinion.service.impl.MonthServiceImpl;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

/**
 * (Month)表控制层
 * @since 2023-03-06 11:52:25
 */
@RestController
@RequestMapping("montharticle")
public class MonthController {

    private final MonthServiceImpl monthServiceImpl;
    public MonthController(MonthServiceImpl monthServiceImpl) {
        this.monthServiceImpl = monthServiceImpl;
    }

    /**
     * 通过热点事件id返回新闻列表
     *
     * @param monthevent 热点事件id
     */
    @GetMapping("{monthevent}")
    public ResponseEntity<List<MonthVo>> queryHotPointArticle(@PathVariable("monthevent") Integer monthevent) {
        return ResponseEntity.ok(monthServiceImpl.queryMonthOfArticle(monthevent));
    }
}