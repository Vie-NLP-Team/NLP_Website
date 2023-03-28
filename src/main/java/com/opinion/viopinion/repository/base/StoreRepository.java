package com.opinion.viopinion.repository.base;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

@NoRepositoryBean
public interface StoreRepository<T, ID> extends JpaRepository<T, ID> {

}
