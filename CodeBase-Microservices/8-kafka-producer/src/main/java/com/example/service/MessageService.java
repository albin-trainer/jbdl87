package com.example.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;
import com.example.dto.Message;
@Service
public class MessageService {
	@Autowired
	private KafkaTemplate<String, String>  template;
 public void sendMessage(Message msg) {
	 template.send("JBDL87",msg.getUserName(), msg.getMessage());
	 System.out.println("Msg Send .....");
	 
 }
}
