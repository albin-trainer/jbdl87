package com.example.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.dto.Message;
import com.example.service.MessageService;

@RestController
public class MessageApi {
	@Autowired
	private MessageService service;
	@PostMapping("/send")
	public String sendMessage(@RequestBody Message msg) {
		service.sendMessage(msg);
		return  "MSG SEND";
	}
}
