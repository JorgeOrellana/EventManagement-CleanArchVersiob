package com.tigo.EmInfrastructure;

import java.time.LocalDateTime;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.tigo.EmDomain.model.event.EventHeader;
import com.tigo.EmDomain.model.event.EventMessage;
import com.tigo.EmDomain.valueobject.EventExternalId;
import com.tigo.EmDomain.valueobject.EventInput;
import com.tigo.EmDomain.valueobject.EventProducerTime;

@SpringBootApplication
@EnableFeignClients
public class EmInfrastructureApplication {

	public static void main(String[] args) {
		SpringApplication.run(EmInfrastructureApplication.class, args);
	}

}
