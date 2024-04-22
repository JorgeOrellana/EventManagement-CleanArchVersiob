package com.tigo.EmInfrastructure.port;

import java.time.LocalDateTime;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.tigo.EmApplication.usecase.cancelproduct.CancelProductExecutor;
import com.tigo.EmApplication.usecase.port.EventListener;
import com.tigo.EmDomain.executor.EventExecutor;
import com.tigo.EmDomain.model.event.EventEM;
import com.tigo.EmDomain.model.event.EventHeader;
import com.tigo.EmDomain.model.event.EventMessage;
import com.tigo.EmDomain.valueobject.EventExternalId;
import com.tigo.EmDomain.valueobject.EventInput;
import com.tigo.EmDomain.valueobject.EventProducerTime;
import com.tigo.EmInfrastructure.adapter.DataOnDemandAdapter;
import com.tigo.EmInfrastructure.port.dto.EventMessageStructure;
import com.tigo.EmShareKernel.core.event.IEventEM;
import com.tigo.EmShareKernel.core.event.IExecutor;
import com.tigo.EmShareKernel.log.EventLogger;
import com.tigo.EmShareKernel.port.IEventListener;

@Component
public class KafkaEventListener {
	
	private static final EventLogger logger = new EventLogger(KafkaEventListener.class);
	private IEventListener eventListener;
	
	@Autowired
	private DataOnDemandAdapter adapter;
	
	@KafkaListener(
	    topics = {"#{'${spring.kafka.consumer.topics}'.split(',')}"},
	    groupId = "${spring.kafka.consumer.group-id}"
	)
	public void listener(@Payload EventMessageStructure event) throws Exception {
		logger.logInfo(event.getHeader().getEventId(), "capturando Event from kafka - internal");
		
		IExecutor executor = new CancelProductExecutor();
		executor.setAdapter(adapter);
		
		eventListener = new EventListener();
		eventListener.listen(convertMessage(event), executor);
		
	}
	
	private IEventEM convertMessage(EventMessageStructure event) {
		IEventEM eventConverted = new EventEM(new EventHeader(UUID.fromString(event.getHeader().getEventId()) ,new EventProducerTime(LocalDateTime.now())), new EventMessage(new EventExternalId(event.getEvent().getExternalEventId()), new EventInput(event.getEvent().getInput().getPayload()))); 
		return eventConverted;
	}
}
