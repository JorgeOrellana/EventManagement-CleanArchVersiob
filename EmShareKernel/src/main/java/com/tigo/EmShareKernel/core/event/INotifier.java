package com.tigo.EmShareKernel.core.event;

import com.tigo.EmShareKernel.exception.NotificationException;
import com.tigo.EmShareKernel.port.IEventAdapter;

public interface INotifier {

	void notifyEvent(INotification notification) throws NotificationException;
	void prepareAdapter(IEventAdapter adapter);
}
