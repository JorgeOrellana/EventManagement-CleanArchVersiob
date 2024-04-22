package com.tigo.EmDomain.model.event;

import java.time.LocalDateTime;
import java.util.UUID;

import com.tigo.EmDomain.valueobject.EventConsumptionTime;
import com.tigo.EmDomain.valueobject.EventProducerTime;
import com.tigo.EmShareKernel.core.Entity;
import com.tigo.EmShareKernel.core.event.IEventHeader;

public class EventHeader extends Entity<UUID> implements IEventHeader<UUID, EventProducerTime>{

	private EventConsumptionTime consumptionTime;
	private EventProducerTime producerTime;

	public EventHeader() {
		super();
		this.Id = UUID.randomUUID();
		consumptionTime = new EventConsumptionTime(LocalDateTime.now());
	}
	
	public EventHeader(EventProducerTime producerTime) {
		super();
		this.Id = UUID.randomUUID();
		this.consumptionTime = new EventConsumptionTime(LocalDateTime.now());
		this.producerTime = producerTime;
	}
	
	public EventHeader(UUID id, EventProducerTime producerTime) {
		super();
		this.Id = id;
		this.consumptionTime = new EventConsumptionTime(LocalDateTime.now());
		this.producerTime = producerTime;
	}
	
	@Override
	public UUID getId() {
		return this.Id;
	}

	@Override
	public EventProducerTime getProducerTime() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void updateProducerTime(EventProducerTime producerTime) {
		this.producerTime = producerTime;

		
	}

	
}
