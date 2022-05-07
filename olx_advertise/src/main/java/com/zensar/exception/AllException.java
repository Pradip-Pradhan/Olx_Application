package com.zensar.exception;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class AllException {

	@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
	@ExceptionHandler(UserNotFound.class)
	public Map<String, String> handelIdNotFound(UserNotFound ex){
		Map<String , String> errorMap=new HashMap<String, String>();
		errorMap.put("errorMessage", ex.getMessage());
		return errorMap;
	}
}
