package com.tigo.EmApplication.usecase.port;

import com.tigo.EmApplication.usecase.cancelproduct.CancelProductExecutor;
import com.tigo.EmShareKernel.core.event.IEventEM;
import com.tigo.EmShareKernel.core.event.IExecutor;
import com.tigo.EmShareKernel.log.EventLogger;
import com.tigo.EmShareKernel.port.IEventListener;

public class EventListener implements IEventListener<IEventEM>{

	private static final EventLogger logger = new EventLogger(EventListener.class);
	
	@Override
	public void listen(IEventEM event, IExecutor executor) {
		logger.log("Capturando Evento desde capa de aplicacion");
		executor.sendEvent(event);
	}

}
