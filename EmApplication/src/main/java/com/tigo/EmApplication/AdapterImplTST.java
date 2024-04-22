package com.tigo.EmApplication;

import com.tigo.EmApplication.usecase.dto.DataOnDemandRequest;
import com.tigo.EmShareKernel.core.event.INotification;
import com.tigo.EmShareKernel.port.IEventAdapter;

public class AdapterImplTST implements IEventAdapter{

	@Override
	public void send() {
		System.out.println("sending event from adapterImplTST....");
	}

	@Override
	public void setMessage(INotification message) {
		//INotification  = new DataOnDemandRequest();
	}

}
