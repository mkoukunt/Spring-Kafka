package io.kafka.spring;

import java.util.concurrent.CompletableFuture;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;

@SpringBootApplication
public class SpringKafkaApplication {
	

	public static void main(String[] args) {
		SpringApplication.run(SpringKafkaApplication.class, args);
		System.out.println(ApplicationContextProvider.getApplicationContext());
		KafkaTemplate<String, String> kafkaTemplate =(KafkaTemplate<String, String>) ApplicationContextProvider.getApplicationContext().getBean("kafkaTemplate");
		Stream.iterate(0, n -> n + 1)
        .limit(10)
        .forEach(x -> {
        	String message="Testdjfjdjdvkjd";
        	CompletableFuture<SendResult<String, String>> future = kafkaTemplate.send("quickstart-events", message);
            future.whenComplete((result, ex) -> {
                if (ex == null) {
                    System.out.println("Sent message=[" + message + 
                        "] with offset=[" + result.getRecordMetadata().offset() + "]");
                } else {
                    System.out.println("Unable to send message=[" + 
                        message + "] due to : " + ex.getMessage());
                }
            });
        	});
		
	}
	

}

	
