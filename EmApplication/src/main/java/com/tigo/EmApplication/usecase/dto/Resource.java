package com.tigo.EmApplication.usecase.dto;

import java.util.List;

public class Resource {
	private String id;
	  private String name;
	  private List<ResourceCharacteristic> resourceCharacteristic;

	  public String getId() {
	    return id;
	  }

	  public void setId(String id) {
	    this.id = id;
	  }

	  public String getName() {
	    return name;
	  }

	  public void setName(String name) {
	    this.name = name;
	  }

	  public List<ResourceCharacteristic> getResourceCharacteristic() {
	    return resourceCharacteristic;
	  }

	  public void setResourceCharacteristic(
	      List<ResourceCharacteristic> resourceCharacteristic) {
	    this.resourceCharacteristic = resourceCharacteristic;
	  }
}
