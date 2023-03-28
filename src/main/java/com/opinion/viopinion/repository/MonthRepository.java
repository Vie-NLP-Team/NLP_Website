package com.opinion.viopinion.repository;

import com.opinion.viopinion.entity.dto.MontharticleDto;
import com.opinion.viopinion.repository.base.VisualRepository;
import org.springframework.stereotype.Repository;
import java.util.List;
@Repository
public interface MonthRepository extends VisualRepository<MontharticleDto, Integer> {
    List<MontharticleDto> findMontharticleByMonthevent(Integer monthevent);
}
