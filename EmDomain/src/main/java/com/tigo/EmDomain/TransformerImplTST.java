package com.tigo.EmDomain;

import java.util.UUID;

import com.tigo.EmDomain.model.event.EventEM;
import com.tigo.EmDomain.valueobject.EventExternalId;
import com.tigo.EmShareKernel.core.event.IEventEM;
import com.tigo.EmShareKernel.core.event.INotification;
import com.tigo.EmShareKernel.core.event.ITransformer;
import com.tigo.EmShareKernel.exception.TransformationException;
import com.tigo.EmShareKernel.log.IEventLogger;

public class TransformerImplTST implements ITransformer{
	
	public TransformerImplTST() {
	}

	@Override
	public INotification transform(IEventEM event) throws TransformationException {
		INotification<String> notification = new NotificationImpTST();
		IEventEM eventEM = event;
		notification.setPayload(eventEM.getMessage().getInput().getPayload().toString());
		return notification;
	}


}
