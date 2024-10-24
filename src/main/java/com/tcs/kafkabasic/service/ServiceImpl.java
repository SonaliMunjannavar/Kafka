package com.tcs.kafkabasic.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class ServiceImpl {

	@Autowired
	private KafkaTemplate<String, String> template;

	public String kafkaProducer(String message) {
		template.send("messageavailable", message);
		return message;
	}

	@KafkaListener(topics = "messageavailable", groupId = "consumer group")
	public String kafkaConsumer(String message) {
		System.out.println(message);
		return message;
	}

}
