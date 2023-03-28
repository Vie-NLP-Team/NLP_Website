package com.opinion.viopinion.repository;

import com.opinion.viopinion.entity.dto.WebDto;
import com.opinion.viopinion.repository.base.StoreRepository;
import org.springframework.stereotype.Repository;
import java.util.List;
@Repository
public interface WebRepository extends StoreRepository<WebDto, Integer> {
    List<WebDto> findAll();
}
