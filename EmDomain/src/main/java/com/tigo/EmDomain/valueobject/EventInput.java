package com.tigo.EmDomain.valueobject;

import com.tigo.EmShareKernel.core.ValueObject;
import com.tigo.EmShareKernel.core.event.IEventInput;

public class EventInput extends ValueObject implements IEventInput<String>{
	
	private String payload;
	
	public EventInput(String payload) {
		super();
		this.payload = payload;
	}

	@Override
	public String getPayload() {
		return payload;
	}
	


}
