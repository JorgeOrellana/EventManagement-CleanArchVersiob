package com.tigo.EmDomain.executor;

import java.time.LocalDateTime;
import java.util.UUID;

import com.tigo.EmDomain.model.event.EventHeader;
import com.tigo.EmDomain.model.event.EventMessage;
import com.tigo.EmDomain.valueobject.EventExternalId;
import com.tigo.EmDomain.valueobject.EventProducerTime;
import com.tigo.EmShareKernel.core.AggregateRoot;
import com.tigo.EmShareKernel.core.event.ICreator;
import com.tigo.EmShareKernel.core.event.IEventEM;
import com.tigo.EmShareKernel.core.event.IEventExecution;
import com.tigo.EmShareKernel.core.event.INotification;
import com.tigo.EmShareKernel.core.event.INotifier;
import com.tigo.EmShareKernel.core.event.ITransformer;
import com.tigo.EmShareKernel.exception.CreationException;
import com.tigo.EmShareKernel.exception.NotificationException;
import com.tigo.EmShareKernel.exception.TransformationException;
import com.tigo.EmShareKernel.log.EventLogger;
import com.tigo.EmShareKernel.log.IEventLogger;

public class EventExecutor implements IEventExecution<EventExternalId, String, EventProducerTime> {
	
	private static final EventLogger logger = new EventLogger(EventExecutor.class);
	
	private ICreator creator;
	private ITransformer transformer;
	private INotifier notifier;
	
	public EventExecutor(ICreator creator, ITransformer transformer, INotifier notifier) {
		super();
		this.creator = creator;
		this.transformer = transformer;
		this.notifier = notifier;
	}

	@Override
	public boolean executeEvent(EventExternalId eventExternalId, String payload, EventProducerTime producerTime) {
		try {
			IEventEM event = creator.createEvent(eventExternalId, payload, producerTime);
			logger.logInfo(event.getHeader().getId().toString(), "event created");			
			INotification notification = transformer.transform(event);
			logger.logInfo(event.getHeader().getId().toString(), "event transformed");
			notifier.notifyEvent(notification);
			logger.logInfo(event.getHeader().getId().toString(), "event notified");
			return true;
		} catch (CreationException | TransformationException | NotificationException e) {
			logger.logException(e.getMessage(), e);
			return false;
		} catch (Exception e) {
			logger.logException("Salto una exepcion", e);
			return false;
		}
	}
	
}