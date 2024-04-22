package com.tigo.EmApplication;

import java.time.LocalDateTime;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.tigo.EmApplication.usecase.cancelproduct.CancelProductExecutor;
import com.tigo.EmApplication.usecase.port.EventListener;
import com.tigo.EmDomain.model.event.EventEM;
import com.tigo.EmDomain.model.event.EventHeader;
import com.tigo.EmDomain.model.event.EventMessage;
import com.tigo.EmDomain.valueobject.EventExternalId;
import com.tigo.EmDomain.valueobject.EventInput;
import com.tigo.EmDomain.valueobject.EventProducerTime;
import com.tigo.EmShareKernel.core.event.IEventEM;
import com.tigo.EmShareKernel.core.event.IEventHeader;
import com.tigo.EmShareKernel.core.event.IEventMessage;
import com.tigo.EmShareKernel.core.event.IExecutor;

@SpringBootApplication
public class EmApplication {

	public static void main(String[] args) {
		SpringApplication.run(EmApplication.class, args);
		
		String payload = "{\n"
				+ " \"CommonMsgStructureDef\" : {\n"
				+ "  \"businessCode\" : \"ForcibleDropSubs\",\n"
				+ "  \"beId\" : 101,\n"
				+ "  \"operatorInfo\" : {\n"
				+ "   \"operatorCode\" : \"101\",\n"
				+ "   \"orgId\" : 101\n"
				+ "  },\n"
				+ "  \"channelType\" : \"622\"\n"
				+ " },\n"
				+ " \"serviceNumber\" : \"91002735\",\n"
				+ " \"businessTime\" : 1702531873000,\n"
				+ " \"subscriberStatus\" : \"9\",\n"
				+ " \"customerCode\" : 11000000205005,\n"
				+ " \"acctCode\" : \"11000000215006\",\n"
				+ " \"ICCID\" : \"71102000000053\",\n"
				+ " \"primaryOfferingID\" : 3570\n"
				+ "}";
		
		IEventHeader header = new EventHeader(new EventProducerTime(LocalDateTime.now()));
		IEventMessage message = new EventMessage(new EventExternalId("external id"), new EventInput(payload));
		IEventEM event = new EventEM(header, message);
		
		IExecutor executor = new CancelProductExecutor();
		executor.setAdapter(new AdapterImplTST());
		
		EventListener listener = new EventListener();
		listener.listen(event, executor);
	}

}
