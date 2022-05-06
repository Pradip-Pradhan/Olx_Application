package com.zensar.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.zensar.entity.OlxStatus;

public interface StatusRepository extends JpaRepository<OlxStatus, Integer> {

}
