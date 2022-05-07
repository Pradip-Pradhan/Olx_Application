package com.zensar.service;

import java.util.List;

import org.springframework.web.bind.annotation.RequestBody;

import com.zensar.entity.UserLogin;
import com.zensar.entitydto.UserLoginDto;

public interface LoginService {

	UserLoginDto createUser(UserLoginDto user);
	List<UserLoginDto> getAllUsers();
}
