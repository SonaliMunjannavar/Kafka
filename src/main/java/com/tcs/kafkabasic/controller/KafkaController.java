package com.tcs.kafkabasic.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tcs.kafkabasic.service.ServiceImpl;

@RestController
public class KafkaController {
	
	@Autowired
	private ServiceImpl service;
	
	@GetMapping("/ping")
	public String ping() {
		return "success";
	}
	
	@PostMapping("/sendmessage/{message}")
	public String kafkaProducer(@PathVariable("message") String message) {
		return service.kafkaProducer(message);
	}

}
