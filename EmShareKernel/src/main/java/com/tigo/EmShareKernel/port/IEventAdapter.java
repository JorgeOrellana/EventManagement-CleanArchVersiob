package com.tigo.EmShareKernel.port;

import com.tigo.EmShareKernel.core.event.INotification;

public interface IEventAdapter {
	void send();
	void setMessage(INotification message);
}
