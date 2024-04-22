package com.tigo.EmShareKernel.core.event;

import java.time.LocalDateTime;

public interface IEventExecution<ExternalId, PayloadType, ProducerTime> {

	boolean executeEvent(ExternalId eventExternalId, PayloadType payload, ProducerTime producerTime);
	
}
