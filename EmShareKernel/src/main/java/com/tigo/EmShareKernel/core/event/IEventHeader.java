package com.tigo.EmShareKernel.core.event;

import java.time.LocalDateTime;

public interface IEventHeader<TId, producerTime> {

	TId getId();
	producerTime getProducerTime();
	void updateProducerTime(producerTime producerTime);
}
