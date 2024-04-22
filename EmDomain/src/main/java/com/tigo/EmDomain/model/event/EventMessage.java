package com.tigo.EmDomain.model.event;

import java.time.LocalDateTime;
import java.util.UUID;

import com.tigo.EmDomain.valueobject.EventConsumptionTime;
import com.tigo.EmDomain.valueobject.EventExternalId;
import com.tigo.EmDomain.valueobject.EventInput;
import com.tigo.EmDomain.valueobject.EventProducerTime;
import com.tigo.EmShareKernel.core.Entity;
import com.tigo.EmShareKernel.core.event.IEventInput;
import com.tigo.EmShareKernel.core.event.IEventMessage;

public class EventMessage extends Entity<EventExternalId> implements IEventMessage {
	
	private EventInput input;

	public EventMessage(EventExternalId externalId, EventInput input) {
		super();
		this.Id = new EventExternalId(externalId.getExternalId());
		this.input = input;
	}

	@Override
	public IEventInput getInput() {
		return input;
	}
	
	@Override
	public EventExternalId getId() {
		return this.Id;
	}
	
}
