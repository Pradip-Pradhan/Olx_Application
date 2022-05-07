package com.zensar.service;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import com.zensar.entity.UserLogin;
import com.zensar.entitydto.UserLoginDto;
import com.zensar.repository.LoginRepository;

@Service
public class LoginServiceImpl implements LoginService {
	
	
	@Autowired
	private LoginRepository loginRepository;
	
	@Autowired
	private ModelMapper modelMapper;

	@Override
	public UserLoginDto createUser(UserLoginDto user) {
		UserLogin newUser=modelMapper.map(user, UserLogin.class);
		UserLogin save=loginRepository.save(newUser);
		return modelMapper.map(save, UserLoginDto.class);
		
	}

	@Override
	public List<UserLoginDto> getAllUsers() {
		List<UserLogin> content=loginRepository.findAll();
		List<UserLoginDto> userLoginDtos=new ArrayList<UserLoginDto>();
		for(UserLogin login:content) {
			UserLoginDto dto=modelMapper.map(login, UserLoginDto.class);
			userLoginDtos.add(dto);
		}
		return userLoginDtos;
	}

}
