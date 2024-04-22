package com.tigo.EmApplication.usecase.cancelproduct;

import com.tigo.EmApplication.usecase.dto.DataOnDemandRequest;
import com.tigo.EmShareKernel.core.event.INotification;

public class CancelProductNotification implements INotification<DataOnDemandRequest>{

	private DataOnDemandRequest payload;
	
	@Override
	public DataOnDemandRequest getPayload() {
		return this.payload;
	}

	@Override
	public void setPayload(DataOnDemandRequest payload) {
		this.payload = payload;		
	}

}
