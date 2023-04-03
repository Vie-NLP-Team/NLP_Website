package com.opinion.viopinion.controller;

import com.kennycason.kumo.WordFrequency;
import com.opinion.viopinion.service.impl.WordsServiceImpl;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * (Words)表控制层
 * @since 2023-03-06 11:52:25
 */
@RestController
@RequestMapping("words")
public class WordsController {

    private final WordsServiceImpl wordsServiceImpl;
    public WordsController(WordsServiceImpl wordsServiceImpl) {
        this.wordsServiceImpl = wordsServiceImpl;
    }

    /**
     * 高频词词云可视化
     *
     */
    @GetMapping
    public ResponseEntity<List<WordFrequency>> wordsCloudVisual() {
        return ResponseEntity.ok(wordsServiceImpl.wordsCloud());
    }
}
