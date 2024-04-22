package com.tigo.EmInfrastructure.adapter;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tigo.EmApplication.usecase.dto.DataOnDemandRequest;
import com.tigo.EmShareKernel.core.event.INotification;
import com.tigo.EmShareKernel.log.EventLogger;
import com.tigo.EmShareKernel.log.IEventLogger;
import com.tigo.EmShareKernel.port.IEventAdapter;
import com.tigo.EmShareKernel.utils.JsonParser;

@Service
public class DataOnDemandAdapter implements IEventAdapter {
	
	private static final IEventLogger logger = new EventLogger(DataOnDemandAdapter.class);

	  @Autowired
	  private DataOnDemandAuthClient dataOnDemandAuthClient;
	  @Autowired
	  private DataOnDemandClient dataOnDemandClient;
	  @Autowired
	  private DataOnDemandCredentials dataOnDemandCredentials;
	  
	  private INotification<DataOnDemandRequest> message;
	  
	@Override
	public void send() {
		String accessToken = authenticateDataOnDemand();
		String dataOnDemandResponse = dataOnDemandClient.postDataOnDemand(message.getPayload(), accessToken);
		logger.log(LocalDateTime.now().toString() + " " + "respuesta :" + dataOnDemandResponse);
	    System.out.println(dataOnDemandResponse);
	}

	private String authenticateDataOnDemand() {
		String authResponse = dataOnDemandAuthClient.authenticateDataOnDemand(dataOnDemandCredentials.credentials());
	    return JsonParser.getFromJson(authResponse, "$.access_token", String.class);
	  }

	@Override
	public void setMessage(INotification message) {
		this.message = message; 
	}
	
}
