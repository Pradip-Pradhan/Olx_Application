package com.zensar.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.zensar.entity.OlxCategory;

public interface CategoryRepository extends JpaRepository<OlxCategory, Integer> {

}
