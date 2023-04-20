package com.opinion.viopinion.controller.quartz;

import com.opinion.viopinion.service.impl.ArticleServiceImpl;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * (Article_website)表控制层
 * @since 2023-04-06 11:52:25
 */
@RestController
@RequestMapping("pre")
public class PretreatmentController {
    private final ArticleServiceImpl articleServiceImpl;
    public PretreatmentController(ArticleServiceImpl articleServiceImpl) {
        this.articleServiceImpl = articleServiceImpl;
    }

    /**
     * 新闻事件统计的预处理
     */
    @GetMapping("/count")
    public ResponseEntity<String> articleAndWebUpdate() {
        articleServiceImpl.articleAndWebUpdate();
        return ResponseEntity.ok("Preprocessing completed");
    }
}
