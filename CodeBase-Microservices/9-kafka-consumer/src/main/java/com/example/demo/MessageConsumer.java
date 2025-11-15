package com.example.demo;

import java.util.Date;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class MessageConsumer {
	//ITS PULL based not PUSH (Kafka never send messages)
	@KafkaListener(topics = "JBDL87" ,groupId = "grp1")
	public void consumeMessage( ConsumerRecord<String,String> record ) {
			String k=record.key();
			String v=record.value();
			long timestamp=  record.timestamp();
			System.out.println(v +" "+k +" "+ new Date(timestamp) );
	}

}
