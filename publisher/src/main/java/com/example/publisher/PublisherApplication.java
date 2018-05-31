package com.example.publisher;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.Output;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@EnableBinding(Source.class)
@RestController
public class PublisherApplication {

	@Output(Source.OUTPUT)
	@Autowired
	private MessageChannel messageChannel;

	
	public static void main(String[] args) throws FileNotFoundException, IOException {
		SpringApplication.run(PublisherApplication.class, args);
	}
	
	@PostMapping("/sendEvent")
	public void sendMessage(@RequestBody String message){
		this.messageChannel.send(MessageBuilder.withPayload(message).build());
	}
	
}
