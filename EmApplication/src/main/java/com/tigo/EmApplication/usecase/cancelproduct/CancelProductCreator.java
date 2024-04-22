package com.tigo.EmApplication.usecase.cancelproduct;

import java.time.LocalDateTime;
import java.util.UUID;

import com.tigo.EmDomain.model.event.EventEM;
import com.tigo.EmDomain.model.event.EventHeader;
import com.tigo.EmDomain.model.event.EventMessage;
import com.tigo.EmDomain.valueobject.EventExternalId;
import com.tigo.EmDomain.valueobject.EventInput;
import com.tigo.EmDomain.valueobject.EventProducerTime;
import com.tigo.EmShareKernel.core.event.ICreator;
import com.tigo.EmShareKernel.core.event.IEventEM;
import com.tigo.EmShareKernel.exception.CreationException;

public class CancelProductCreator implements ICreator<EventExternalId, String, EventProducerTime>{

	@Override
	public IEventEM createEvent(EventExternalId eventExternalId, String payload, EventProducerTime producerTime)
			throws CreationException {
		IEventEM event = new EventEM(new EventHeader(producerTime), new EventMessage(eventExternalId, new EventInput(payload)));
		return event;
	}

}
