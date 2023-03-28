package com.opinion.viopinion.repository;

import com.opinion.viopinion.entity.dto.ArticleDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ArticleRepository extends JpaRepository<ArticleDto, Integer> {
    ArticleDto findArticleById(Integer id);
    List<ArticleDto> findArticlesByBody(String body);
    Page<ArticleDto> findAll(Pageable pageable);
    List<ArticleDto> findArticleByWebsiteId(Integer websiteId);
}
