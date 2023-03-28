package com.opinion.viopinion.repository;

import com.opinion.viopinion.entity.dto.EventDto;
import com.opinion.viopinion.repository.base.VisualRepository;
import org.springframework.stereotype.Repository;
import java.util.List;
@Repository
public interface EventRepository extends VisualRepository<EventDto, Integer> {
    List<EventDto> findAll();
    List<EventDto> findEventByNewsCycle(Integer newsCycle);
}
