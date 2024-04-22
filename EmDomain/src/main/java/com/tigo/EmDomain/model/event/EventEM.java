package com.tigo.EmDomain.model.event;

import java.util.UUID;

import com.tigo.EmShareKernel.core.AggregateRoot;
import com.tigo.EmShareKernel.core.event.IEventEM;
import com.tigo.EmShareKernel.core.event.IEventHeader;
import com.tigo.EmShareKernel.core.event.IEventMessage;

public class EventEM extends AggregateRoot<UUID> implements IEventEM{

	private IEventMessage message;
	private IEventHeader header;
	
	public EventEM() {
	}
	
	public EventEM(IEventHeader header, IEventMessage message) {
		this.Id = UUID.randomUUID();
		this.header = header;
		this.message = message;
	}
	
	public EventEM(UUID id,IEventHeader header, IEventMessage message) {
		this.Id = id;
		this.header = header;
		this.message = message;
	}

	@Override
	public IEventHeader getHeader() {
		return header;
	}
	
	@Override
	public IEventMessage getMessage(){
		return message;
		
	}
	
}
