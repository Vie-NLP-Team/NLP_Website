package com.opinion.viopinion.repository;

import com.opinion.viopinion.entity.dto.ArticleDto;
import com.opinion.viopinion.repository.base.StoreRepository;
import org.jetbrains.annotations.NotNull;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ArticleRepository extends StoreRepository<ArticleDto, Integer> {
    ArticleDto findArticleDtoById(Integer id);
    List<ArticleDto> findArticleDtoByIdBetween(Integer first_id, Integer last_id);
    List<ArticleDto> findArticleDtoByBodyContaining(String body);
    @NotNull
    Page<ArticleDto> findAll(@NotNull Pageable pageable);
    List<ArticleDto> findArticleDtoByWebsiteId(Integer websiteId);
}
