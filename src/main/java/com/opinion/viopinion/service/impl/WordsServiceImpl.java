package com.opinion.viopinion.service.impl;

import com.kennycason.kumo.WordFrequency;
import com.kennycason.kumo.nlp.FrequencyAnalyzer;
import com.kennycason.kumo.nlp.tokenizers.ChineseWordTokenizer;
import com.opinion.viopinion.repository.WordsRepository;
import com.opinion.viopinion.service.WordsService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class WordsServiceImpl implements WordsService {

    private final WordsRepository wordsRepository;
    public WordsServiceImpl(WordsRepository wordsRepository) {
        this.wordsRepository = wordsRepository;
    }

    @Override
    public List<WordFrequency> wordsCloud() {
        FrequencyAnalyzer frequencyAnalyzer = new FrequencyAnalyzer();
        frequencyAnalyzer.setWordFrequenciesToReturn(600);
        frequencyAnalyzer.setMinWordLength(2);
        frequencyAnalyzer.setWordTokenizer(new ChineseWordTokenizer());
        List<String> words = new ArrayList<>();
        wordsRepository.findAll().forEach(word -> words.add(word.getCnWord()));
        return frequencyAnalyzer.load(words);
    }
}
