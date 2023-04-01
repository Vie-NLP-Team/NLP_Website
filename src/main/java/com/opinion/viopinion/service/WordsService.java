package com.opinion.viopinion.service;

import com.kennycason.kumo.WordFrequency;

import java.util.List;

public interface WordsService {

    List<WordFrequency> wordsCloud();
}
