package com.opinion.viopinion.repository.base;

import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.data.repository.Repository;

@NoRepositoryBean
public interface VisualRepository<T, ID> extends Repository<T, ID> {

}
