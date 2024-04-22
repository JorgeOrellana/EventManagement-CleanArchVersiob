package com.tigo.EmApplication.usecase.cancelproduct;

import com.tigo.EmShareKernel.core.event.INotification;
import com.tigo.EmShareKernel.core.event.INotifier;
import com.tigo.EmShareKernel.exception.NotificationException;
import com.tigo.EmShareKernel.port.IEventAdapter;

public class CancelProductNotifier implements INotifier{

	private IEventAdapter adapter;
	
	public CancelProductNotifier() {
	}
	
	@Override
	public void notifyEvent(INotification notification) throws NotificationException {
		this.adapter.setMessage(notification);
		this.adapter.send();
	}

	@Override
	public void prepareAdapter(IEventAdapter adapter) {
		this.adapter = adapter;
	}

}
