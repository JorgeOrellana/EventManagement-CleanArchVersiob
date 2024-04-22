package com.tigo.EmApplication.usecase.dto;

import java.time.LocalDateTime;
import java.util.List;

import com.tigo.EmDomain.executor.EventExecutor;
import com.tigo.EmShareKernel.core.event.INotification;
import com.tigo.EmShareKernel.log.EventLogger;

public class DataOnDemandRequest{
	
	private static final EventLogger logger = new EventLogger(DataOnDemandRequest.class);
	
	private String category;
	  private LocalDateTime orderDate;
	  private List<Channel> channel;
	  private List<Note> note;
	  private List<ProductOrder> productOrderItem;
	  private List<Resource> realizingResource;

	  public String getCategory() {
	    return category;
	  }

	  public void setCategory(String category) {
	    this.category = category;
	  }

	  public LocalDateTime getOrderDate() {
	    return orderDate;
	  }

	  public void setOrderDate(LocalDateTime orderDate) {
	    this.orderDate = orderDate;
	  }

	  public List<Channel> getChannel() {
	    return channel;
	  }

	  public void setChannel(
	      List<Channel> channel) {
	    this.channel = channel;
	  }

	  public List<Note> getNote() {
	    return note;
	  }

	  public void setNote(List<Note> note) {
	    this.note = note;
	  }

	  public List<ProductOrder> getProductOrderItem() {
	    return productOrderItem;
	  }

	  public void setProductOrderItem(
	      List<ProductOrder> productOrderItem) {
	    this.productOrderItem = productOrderItem;
	  }

	  public List<Resource> getRealizingResource() {
	    return realizingResource;
	  }

	  public void setRealizingResource(
	      List<Resource> realizingResource) {
	    this.realizingResource = realizingResource;
	  }

	/*@Override
	public DataOnDemandRequest getPayload() {
		return "DataOnDemandRequest [category=" + category + ", orderDate=" + orderDate + ", channel=" + channel.get(0).getName()
				+ ", note=" + note.get(0).getText() + ", productOrderItem=" + productOrderItem.get(0).getAction() + ", realizingResource="
				+ realizingResource.get(0).getResourceCharacteristic().get(0).getValue() + "]";
	}*/

	@Override
	public String toString() {
		return "DataOnDemandRequest [category=" + category + ", orderDate=" + orderDate + ", channel=" + channel.get(0).getName()
				+ ", note=" + note.get(0).getText() + ", productOrderItem=" + productOrderItem.get(0).getAction() + ", realizingResource="
				+ realizingResource.get(0).getResourceCharacteristic().get(0).getValue() + "]";
	}
	
	

}
