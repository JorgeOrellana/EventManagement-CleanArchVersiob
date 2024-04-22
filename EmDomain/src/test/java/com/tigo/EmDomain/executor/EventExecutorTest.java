package com.tigo.EmDomain.executor;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDateTime;

import org.junit.jupiter.api.Test;

import com.tigo.EmDomain.CreatorImplTST;
import com.tigo.EmDomain.NotifierImplTST;
import com.tigo.EmDomain.TransformerImplTST;
import com.tigo.EmShareKernel.core.event.ICreator;
import com.tigo.EmShareKernel.core.event.IEventExecution;
import com.tigo.EmShareKernel.core.event.INotifier;
import com.tigo.EmShareKernel.core.event.ITransformer;

class EventExecutorTest {

	@Test
	void testProcessEvent() {
		ICreator creator = new CreatorImplTST();
		ITransformer transformer = new TransformerImplTST();
		INotifier notifier = new NotifierImplTST();
		
		IEventExecution executor = new EventExecutor(creator, transformer, notifier);
		boolean result = executor.executeEvent("externalId_example", "payload_example", LocalDateTime.now());
		assertTrue(result);
	}

}
