package com.zensar.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zensar.entity.UserLogin;
import com.zensar.repository.LoginRepository;

@Service
public class LoginServiceImpl implements LoginService {
	
	@Autowired
	private LoginRepository loginRepository;

	@Override
	public UserLogin createUser(UserLogin user) {
		return loginRepository.save(user);
	}

	@Override
	public List<UserLogin> getAllUsers() {
		return loginRepository.findAll();
	}

}
