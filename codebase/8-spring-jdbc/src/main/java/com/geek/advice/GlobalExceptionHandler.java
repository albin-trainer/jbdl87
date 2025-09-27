package com.geek.advice;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.geek.dto.ApiError;
import com.geek.exception.ApplicationException;
//Like a catch block for entire App
@RestControllerAdvice
public class GlobalExceptionHandler {
	@ExceptionHandler(exception = {ApplicationException.class})
	public  ResponseEntity<ApiError> handleException(Exception e) {
		System.out.println("Exception handled .....");
		ApiError error=new ApiError(e.getMessage(),"404");
		return  new ResponseEntity<>(error,HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(exception = MethodArgumentNotValidException.class)
	public ResponseEntity<Map<String, String>> handleValidationException(MethodArgumentNotValidException e){
		System.out.println("validation exception occured .....");
		Map<String, String> errors=new HashMap<>();
		//e.getFieldErrors().forEach(f-> errors.put(f.getField(), f.getDefaultMessage()) );
		 List<FieldError> fieldErrors=   e.getFieldErrors();
		 for(FieldError f:fieldErrors) {
			 errors.put(f.getField(),f.getDefaultMessage());
		 }
		return   new ResponseEntity<Map<String,String>>(errors, HttpStatus.BAD_REQUEST);
	}

}
