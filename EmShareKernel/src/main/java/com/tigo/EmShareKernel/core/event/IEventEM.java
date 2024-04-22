package com.tigo.EmShareKernel.core.event;

public interface IEventEM<EventId, ProducerTime, EventExternalId, PayloadType> {

	IEventHeader<EventId, ProducerTime> getHeader();
	IEventMessage<EventExternalId, PayloadType> getMessage();
}
