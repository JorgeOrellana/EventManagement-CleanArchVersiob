package com.tigo.EmShareKernel.core.event;

import java.time.LocalDateTime;

import com.tigo.EmShareKernel.exception.CreationException;

public interface ICreator<ExternalId, PayloadType, ProducerTime> {

	IEventEM createEvent(ExternalId eventExternalId, PayloadType payload, ProducerTime producerTime) throws CreationException;
	
}
