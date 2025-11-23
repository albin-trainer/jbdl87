package com.example.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.example.dto.TransactionDto;
import com.example.entity.Transaction;
import com.example.service.TransactionService;

@RestController
public class TransactionApi {
	@Autowired
	private TransactionService service;
	@PostMapping("/fundTransfer")
	public Transaction fundTransfer(@RequestBody  TransactionDto dto) {
		return service.fundTransfer(dto);
	}
}
