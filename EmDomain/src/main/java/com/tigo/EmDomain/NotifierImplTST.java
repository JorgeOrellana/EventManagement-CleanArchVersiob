package com.tigo.EmDomain;

import com.tigo.EmShareKernel.core.event.INotification;
import com.tigo.EmShareKernel.core.event.INotifier;
import com.tigo.EmShareKernel.exception.NotificationException;
import com.tigo.EmShareKernel.port.IEventAdapter;

public class NotifierImplTST implements INotifier{

	@Override
	public void notifyEvent(INotification notification) throws NotificationException {
		notification.getPayload();
		//implementen a notification to destiny
	}

	@Override
	public void prepareAdapter(IEventAdapter adapter) {
		// TODO Auto-generated method stub
		
	}

}
