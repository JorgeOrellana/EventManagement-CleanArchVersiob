package com.tigo.EmApplication.usecase.cancelproduct;

import java.time.LocalDateTime;

import com.tigo.EmApplication.AdapterImplTST;
import com.tigo.EmDomain.executor.EventExecutor;
import com.tigo.EmDomain.valueobject.EventExternalId;
import com.tigo.EmDomain.valueobject.EventProducerTime;
import com.tigo.EmShareKernel.core.event.ICreator;
import com.tigo.EmShareKernel.core.event.IEventEM;
import com.tigo.EmShareKernel.core.event.IEventExecution;
import com.tigo.EmShareKernel.core.event.IExecutor;
import com.tigo.EmShareKernel.core.event.INotifier;
import com.tigo.EmShareKernel.core.event.ITransformer;
import com.tigo.EmShareKernel.exception.CreationException;
import com.tigo.EmShareKernel.port.IEventAdapter;

public class CancelProductExecutor implements IExecutor<IEventEM>{

	private IEventAdapter adapter;
	
	public CancelProductExecutor() {
	}

	@Override
	public void sendEvent(IEventEM event) {
		ICreator creator = new CancelProductCreator();
		ITransformer transformer = new CancelProductTransformer();
		INotifier notifier = new CancelProductNotifier();
		notifier.prepareAdapter(adapter);
		IEventExecution executor = new EventExecutor(creator, transformer, notifier);
		executor.executeEvent(event.getMessage().getId(), event.getMessage().getInput().getPayload(), event.getHeader().getProducerTime());
	}

	@Override
	public void setAdapter(IEventAdapter adapter) {
		this.adapter = adapter;
	}	
	
}
