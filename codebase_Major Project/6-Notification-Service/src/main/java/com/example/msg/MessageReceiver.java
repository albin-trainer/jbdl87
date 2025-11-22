package com.example.msg;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.example.dto.MessageDto;

import tools.jackson.databind.ObjectMapper;

@Service
public class MessageReceiver {
	@Autowired
		private ObjectMapper objectMapper;
	@Autowired
	private SimpleMailMessage mailMailMsg;
	@Autowired
	private JavaMailSender mailSender;
		@KafkaListener(topics = "NEW_USER",groupId = "grp1")
	public void messageConsumer(ConsumerRecord<String, String> record  ) {
			System.out.println("Msg received .....");
			System.out.println(record.key());
			System.out.println(record.value());
			//restoring json to Java object
		   MessageDto msgDto=     objectMapper.readValue(record.value(), MessageDto.class);
		   System.out.println(msgDto.getMsg()+" "+msgDto.getEmail());
		   ///send the mail ....
		   
		   //creating the message 
			mailMailMsg.setTo(msgDto.getEmail());
			mailMailMsg.setSubject("Registration Success");
			//String msg="Hi "+userDto.getUserName()+", congratulations !!!!";
			mailMailMsg.setText(msgDto.getMsg());
			mailSender.send(mailMailMsg);
			System.out.println("Mail send ...");
		
	}

}
