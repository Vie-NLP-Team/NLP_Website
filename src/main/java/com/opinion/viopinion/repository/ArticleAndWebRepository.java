package com.opinion.viopinion.repository;

import com.opinion.viopinion.entity.dto.ArticleAndWebDto;
import com.opinion.viopinion.repository.base.StoreRepository;

import java.util.List;

public interface ArticleAndWebRepository extends StoreRepository<ArticleAndWebDto, Integer> {
    List<ArticleAndWebDto> findArticleAndWebDtoByMontheventAndSentiment(Integer monthevent, Integer sentiment);
}
