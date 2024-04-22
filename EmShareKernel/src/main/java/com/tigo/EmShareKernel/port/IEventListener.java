package com.tigo.EmShareKernel.port;

import com.tigo.EmShareKernel.core.event.IExecutor;

public interface IEventListener<EventType> {

	void listen(EventType event, IExecutor executor);
	
}
