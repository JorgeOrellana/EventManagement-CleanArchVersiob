package com.tigo.EmShareKernel.core.event;

public interface IEventMessage<exId, payloadType> {

	IEventInput<payloadType> getInput();	
	exId getId();
}
