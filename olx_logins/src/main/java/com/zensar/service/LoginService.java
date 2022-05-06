package com.zensar.service;

import java.util.List;

import org.springframework.web.bind.annotation.RequestBody;

import com.zensar.entity.UserLogin;

public interface LoginService {

	UserLogin createUser(UserLogin user);
	List<UserLogin> getAllUsers();
}
