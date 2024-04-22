package com.tigo.EmDomain.valueobject;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import com.tigo.EmShareKernel.core.BussinessRuleValidationException;
import com.tigo.EmShareKernel.core.IBussinessRule;
import com.tigo.EmShareKernel.core.ValueObject;
import com.tigo.EmShareKernel.rule.NotNullRule;

public final class EventConsumptionTime extends ValueObject{

	private final LocalDateTime consumptionTime;
	
	public EventConsumptionTime(LocalDateTime dateTime) {
		super();
		consumptionTime = dateTime;
	}
	
	public String getEventConsumptionTime() {
		return consumptionTime.toString();
	}
	
}
