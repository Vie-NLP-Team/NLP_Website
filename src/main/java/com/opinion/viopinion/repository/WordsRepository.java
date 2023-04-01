package com.opinion.viopinion.repository;

import com.opinion.viopinion.entity.dto.WordsDto;
import com.opinion.viopinion.repository.base.VisualRepository;
import java.util.List;

public interface WordsRepository extends VisualRepository<WordsDto, Integer> {

    List<WordsDto> findAll();
}
