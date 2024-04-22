package com.tigo.EmShareKernel.core.event;

import com.tigo.EmShareKernel.port.IEventAdapter;

public interface IExecutor<EventType> {
	void sendEvent(EventType event);
	void setAdapter(IEventAdapter adapter);
}
