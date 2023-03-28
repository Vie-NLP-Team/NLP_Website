package com.opinion.viopinion.repository;

import com.opinion.viopinion.entity.dto.ArticleDto;
import com.opinion.viopinion.repository.base.StoreRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ArticleRepository extends StoreRepository<ArticleDto, Integer> {
    ArticleDto findArticleById(Integer id);
    List<ArticleDto> findArticlesByBody(String body);
    Page<ArticleDto> findAll(Pageable pageable);
    List<ArticleDto> findArticleByWebsiteId(Integer websiteId);
}
