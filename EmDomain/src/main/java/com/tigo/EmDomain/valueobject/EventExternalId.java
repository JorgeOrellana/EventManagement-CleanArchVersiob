package com.tigo.EmDomain.valueobject;

import com.tigo.EmShareKernel.core.ValueObject;

public final class EventExternalId extends ValueObject{
	
	private final String externalId;
	
	public EventExternalId(String externalId) {
		super();
		this.externalId = externalId;
	}
	
	public String getExternalId() {
		return externalId;
	}

}
