package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class KafkaProducerController {
	
	@Autowired
	private KafkaTemplate<String, String> kafkaTemplate;
	 
	@RequestMapping(path = "/message/produce", method = RequestMethod.POST)
	public String produceMessage(@RequestBody String message) {
		kafkaTemplate.send("test", message); //test is the topic name.
		return "Message Produced Successfully";
	}
}
