package com.geek.advice;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.geek.dto.ApiError;
//Like a catch block for entire App
@RestControllerAdvice
public class GlobalExceptionHandler {
	@ExceptionHandler(exception = {Exception.class})
	public  ResponseEntity<ApiError> handleException(Exception e) {
		System.out.println("Exception handled .....");
		ApiError error=new ApiError(e.getMessage(),"404");
		return  new ResponseEntity<>(error,HttpStatus.NOT_FOUND);
	}

}
