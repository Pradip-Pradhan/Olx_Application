package com.zensar.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.zensar.entity.Product;

public interface ProductServiceRepository extends JpaRepository<Product, Integer> {

}
