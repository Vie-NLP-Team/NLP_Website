package com.opinion.viopinion.controller.quartz;

import com.opinion.viopinion.service.impl.ArticleServiceImpl;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

/**
 * (Article)表控制层
 * @since 2023-04-06 11:52:25
 */
@RestController
@RequestMapping("analyse")
public class SentimentController {
    private final ArticleServiceImpl articleServiceImpl;
    public SentimentController(ArticleServiceImpl articleServiceImpl) {
        this.articleServiceImpl = articleServiceImpl;
    }

    /**
     * 新闻语料分词，词性标注，命名实体识别，以及依赖解析
     */
    @GetMapping("/all")
    public ResponseEntity<String> articleAndWebUpdate() throws IOException {
        articleServiceImpl.vnCoreNLPExecute();
        return ResponseEntity.ok("Preprocessing completed");
    }
}
