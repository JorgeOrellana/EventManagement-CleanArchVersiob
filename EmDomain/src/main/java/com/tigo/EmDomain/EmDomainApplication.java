package com.tigo.EmDomain;

import java.time.LocalDateTime;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.tigo.EmDomain.executor.EventExecutor;
import com.tigo.EmDomain.valueobject.EventConsumptionTime;
import com.tigo.EmDomain.valueobject.EventExternalId;
import com.tigo.EmDomain.valueobject.EventProducerTime;
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

@SpringBootApplication
public class EmDomainApplication {

	public static void main(String[] args) {
		SpringApplication.run(EmDomainApplication.class, args);
		
		ICreator creator = new CreatorImplTST();
		ITransformer transformer = new TransformerImplTST();
		INotifier notifier = new NotifierImplTST();
		
		IEventExecution<EventExternalId, String, EventProducerTime> executor = new EventExecutor(creator, transformer, notifier);
		executor.executeEvent(new EventExternalId("externalId_example"), "payload_example", new EventProducerTime(LocalDateTime.now()));
		
	}

}
