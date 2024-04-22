package com.tigo.EmDomain.valueobject;

import static org.junit.jupiter.api.Assertions.*;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;

import org.junit.jupiter.api.Test;

class EventConsumptionTimeTest {

	@Test
	void testgetEventConsumptionTime() {
		LocalDateTime time = LocalDateTime.now();
		EventConsumptionTime consumptionTime = new EventConsumptionTime(time);
		assertEquals(time.toString(), consumptionTime.getEventConsumptionTime());
	}

}
