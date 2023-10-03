package io.kafka.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;


public class KafkaProducer {
	@Autowired
	private static KafkaTemplate<String, String> kafkaTemplate;
	public void sendMessage(String msg) {
	    kafkaTemplate.send("quickstart-events", msg);
	}
}
