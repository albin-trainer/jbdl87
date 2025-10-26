package com.geek.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.geek.dto.AuthourDto;
import com.geek.dto.BookDto;
import com.geek.entity.Authour;
import com.geek.entity.Book;
import com.geek.service.BookService;

import jakarta.validation.Valid;

@RestController
public class AuthourApi {
	@Autowired
private BookService bookService;
	@PostMapping("/authours")
	@PreAuthorize("hasAuthority('ADMIN')")
	public ResponseEntity<Authour> addNewAuthour( @RequestBody @Valid AuthourDto a){
	Authour authour=bookService.addAuthour(a);
	return new ResponseEntity<Authour>(authour,HttpStatus.CREATED);
	}
	
}
