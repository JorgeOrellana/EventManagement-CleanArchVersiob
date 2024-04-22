package com.tigo.EmDomain.valueobject;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;

import com.tigo.EmShareKernel.core.ValueObject;

public final class EventProducerTime extends ValueObject{

	private final LocalDateTime consumptionTime;
	private final String date_format;
	
	public EventProducerTime(LocalDateTime dateTime) {
		super();
		consumptionTime = dateTime;
		date_format = "YYYY-MM-DDThh:mm:ss";
	}
	
	public String getEventConsumptionTime() {
		SimpleDateFormat sdf = new SimpleDateFormat(date_format);
		return sdf.format(consumptionTime);
	}
	
}
