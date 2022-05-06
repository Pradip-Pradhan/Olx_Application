package com.zensar.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.zensar.entity.AdvertiseDetails;

public interface AdvertiseRepository extends JpaRepository<AdvertiseDetails, Integer> {

}
