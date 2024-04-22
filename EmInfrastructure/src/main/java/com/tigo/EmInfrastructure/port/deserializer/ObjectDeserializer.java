package com.tigo.EmInfrastructure.port.deserializer;

import org.apache.kafka.common.serialization.Deserializer;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.tigo.EmInfrastructure.port.dto.EventMessageStructure;

public class ObjectDeserializer implements Deserializer<EventMessageStructure> {

	@Override
	public EventMessageStructure deserialize(String topic, byte[] data) {
		ObjectMapper mapper = new ObjectMapper();
		EventMessageStructure eventMessageStructure = null;
	    try {
	      eventMessageStructure = mapper.readValue(data, EventMessageStructure.class);
	    } catch (Exception e) {
	      e.printStackTrace();
	    }
	    return eventMessageStructure;
	}

}
