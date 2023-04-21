package com.opinion.viopinion.controller.quartz;

import com.opinion.viopinion.service.impl.ArticleServiceImpl;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
     * 新闻语料分词，词性标注，命名实体识别，以及依赖解析 (可选)
     * @param first_num 开始序号
     * @param last_num 结束序号
     */
    @GetMapping("/all/{first}/{last}")
    public ResponseEntity<String> articleAndWebUpdate(@PathVariable("first") Integer first_num, @PathVariable("last") Integer last_num) throws IOException {
        return ResponseEntity.ok(articleServiceImpl.vnCoreNLPExecute(first_num, last_num));
    }

    /**
     * 分词翻译 (越南语转中文)
     */
    @GetMapping("trans")
    public ResponseEntity<String> coreWordsTranslate() {
        return ResponseEntity.ok(articleServiceImpl.translateTest());
    }
}
