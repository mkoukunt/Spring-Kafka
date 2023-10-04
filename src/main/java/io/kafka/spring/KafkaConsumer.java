package io.kafka.spring;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class KafkaConsumer {
	@KafkaListener(topics = "topic100", groupId = "foo")
	public void listenGroupFoo(String message) {
	    System.out.println("Received Message in group foo: " + message);
	}

}
