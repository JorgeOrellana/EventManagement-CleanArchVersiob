package com.tigo.EmDomain;

import com.tigo.EmShareKernel.core.event.INotification;

public class NotificationImpTST implements INotification<String>{

	private String id;
	private String payload;
	
	public NotificationImpTST() {
	}
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	@Override
	public String getPayload() {
		return this.payload;
	}

	@Override
	public void setPayload(String payload) {
		this.payload = payload;
	}

}
