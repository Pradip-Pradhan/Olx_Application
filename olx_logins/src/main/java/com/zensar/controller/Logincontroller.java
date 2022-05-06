package com.zensar.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.zensar.entity.UserLogin;
import com.zensar.service.LoginService;

@RestController
@RequestMapping("/user")
public class Logincontroller {
	
	@Autowired
	private LoginService loginService;
	private String token=null;
	
	@PostMapping("/authenticate")
	public String authenticate(@RequestBody UserLogin login) {
		if((login.getUserName()=="anand") && (login.getPassword()=="anand@123")) {
			token="auth_token";
			return token;
		}else {
			return token;
		}
	}
	
	@DeleteMapping("/logout")
	public boolean deleteToken() {
		if(token==null) {
			return false;
		}else {
			return true;
		}
	}
	
	@PostMapping
	public ResponseEntity<UserLogin> createUser(@RequestBody UserLogin user) {
		UserLogin newUser=loginService.createUser(user);
		return new ResponseEntity<UserLogin>(newUser, HttpStatus.CREATED);
	}
	
	@GetMapping
	public List<UserLogin> getAllUsers() {
		return loginService.getAllUsers();
	}

}
