package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
public class KafkaConsumerRunner implements ApplicationRunner{
	   @KafkaListener(topics = "test", groupId = "group-id")
	   public void listen(String message) {
	      System.out.println("Received Message in group - group-id: " + message);
	   }
	   @Override
	   public void run(ApplicationArguments args) throws Exception {
	      System.out.println("Kafka Consumer Started...");
	   }
}
