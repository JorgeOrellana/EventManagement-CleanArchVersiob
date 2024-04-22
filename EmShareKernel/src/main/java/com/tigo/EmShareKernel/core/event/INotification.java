package com.tigo.EmShareKernel.core.event;

public interface INotification<PayloadType> {
	PayloadType getPayload();
	void setPayload(PayloadType payload);
}
