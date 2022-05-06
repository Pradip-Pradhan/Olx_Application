package com.zensar.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.zensar.entity.UserLogin;

public interface LoginRepository extends JpaRepository<UserLogin, Integer> {

}
