package com.tigo.EmApplication.usecase.cancelproduct;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.UUID;

import com.tigo.EmApplication.usecase.dto.*;
import com.tigo.EmShareKernel.core.event.IEventEM;
import com.tigo.EmShareKernel.core.event.INotification;
import com.tigo.EmShareKernel.core.event.ITransformer;
import com.tigo.EmShareKernel.exception.TransformationException;
import com.tigo.EmShareKernel.log.EventLogger;
import com.tigo.EmShareKernel.utils.JsonParser;

public class CancelProductTransformer implements ITransformer{

	private static final EventLogger logger = new EventLogger(CancelProductTransformer.class);
	
	@Override
	public INotification transform(IEventEM event) throws TransformationException {
		DataOnDemandRequest newDataOnDemandRequest = new DataOnDemandRequest();
		String message = event.getMessage().getInput().getPayload().toString();
	    newDataOnDemandRequest.setCategory("mobile");
	    newDataOnDemandRequest.setOrderDate(LocalDateTime.now());

	    newDataOnDemandRequest.setChannel(Collections.singletonList(createChannel()));

	    newDataOnDemandRequest.setNote(Collections.singletonList(
	        createNote(getTag(event), isSendSMS(event))));

	    ProductOrder newProductOrder = new ProductOrder();
	    newProductOrder.setId("1");
	    newProductOrder.setAction(getBusinessCodeAction(event));
	    newProductOrder.setProduct(createProduct(getPrimaryOfferingID(event)));
	    newDataOnDemandRequest.setProductOrderItem(Collections.singletonList(newProductOrder));

	    List<Resource> newResourceList = new ArrayList<>();
	    newResourceList.add(createResource("MSISDN", JsonParser.getFromJson(event.getMessage().getInput().getPayload().toString(),
	        serviceNumberPath(getBusinessCodeAction(event)), String.class), "1"));

	    newResourceList.add(createResource("MSISDN_OLD", getOldServiceNumber(event), "2"));

	    newDataOnDemandRequest.setRealizingResource(newResourceList);
	    
	    logger.logInfo(event.getHeader().getId().toString(), newDataOnDemandRequest.toString());

	    INotification notification = new CancelProductNotification();
	    notification.setPayload(newDataOnDemandRequest);
	    
	    return notification;
	}
	
	private Channel createChannel() {
	    Channel newChannel = new Channel();
	    newChannel.setId("1");
	    newChannel.setName("SnC");
	    return newChannel;
	  }
	
	  private Note createNote(String text, boolean isSendSMS) {
	    Note newNote = new Note();
	    newNote.setText(text);
	    newNote.setSendSMS(isSendSMS);
	    return newNote;
	  }

	  private Product createProduct(String primaryOfferingID) {
	    ProductOffering newProductOffering = new ProductOffering();
	    newProductOffering.setId(primaryOfferingID);
	    Product newProduct = new Product();
	    newProduct.setProductOffering(newProductOffering);
	    return newProduct;
	  }

	  private Resource createResource(String name, String value, String id) {
	    Resource newResource = new Resource();
	    newResource.setId(id);
	    newResource.setName(name);
	    ResourceCharacteristic newResourceCharacteristic = new ResourceCharacteristic();
	    newResourceCharacteristic.setName("resourceNumber");
	    newResourceCharacteristic.setValue(value);
	    List<ResourceCharacteristic> newResourceCharacteristicList = new ArrayList<>();
	    newResourceCharacteristicList.add(newResourceCharacteristic);
	    newResource.setResourceCharacteristic(newResourceCharacteristicList);
	    return newResource;
	  }

	  private String getBusinessCodeAction(IEventEM message) {
	    String businessCode = JsonParser.getFromJson(message.getMessage().getInput().getPayload().toString(), "$.CommonMsgStructureDef.businessCode",
	        String.class);
	    return businessCode != null ? businessCode : "";
	  }

	  private String getTag(IEventEM message) {
	    String onDemand = JsonParser.getFromJson(message.getMessage().getInput().getPayload().toString(), "$.OnDemand",
	        String.class);
	    return onDemand != null ? (onDemand.equalsIgnoreCase("Activated") ? "Activate" : "Deactivate")
	        : "";
	  }

	  private String getPrimaryOfferingID(IEventEM message) {
	    Integer primaryOfferingID = JsonParser.getFromJson(message.getMessage().getInput().getPayload().toString(), "$.primaryOfferingID",
	        Integer.class);
	    return primaryOfferingID != null ? Integer.toString(primaryOfferingID) : "";
	  }

	  private String getOldServiceNumber(IEventEM message) {
	    String oldServiceNumber = JsonParser.getFromJson(message.getMessage().getInput().getPayload().toString(), "$.oldServiceNumber",
	        String.class);
	    return oldServiceNumber != null ? oldServiceNumber : "";
	  }

	  private boolean isSendSMS(IEventEM message) {
	    String smsNotification = JsonParser.getFromJson(message.getMessage().getInput().getPayload().toString(), "$.smsNotification",
	        String.class);
	    return smsNotification != null ? ((smsNotification.isBlank() || smsNotification.isEmpty())
	        ? Boolean.FALSE : Boolean.TRUE) : Boolean.FALSE;
	  }

	  private String serviceNumberPath(String businessCode) {
	    return switch (businessCode) {
	      case "ModifySubscriber", "ChangeNum", "ForcibleDropSubs", "PortOut" -> "$.serviceNumber";
	      case "TransferOwner" -> "$.transferInfo.subscriberInfo.serviceNumber";
	      default -> "";
	    };
	  }

	  /*private String authenticateDataOnDemand() {
	    String authResponse = dataOnDemandAuthClient.authenticateDataOnDemand(
	        dataOnDemandCredentials.credentials());
	    return getFromJson(authResponse, "$.access_token", String.class);
	  }*/

}
