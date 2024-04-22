package com.tigo.EmApplication.usecase.dto;

public class ProductOrder {
	private String id;
	  private String action;
	  private Product product;

	  public String getId() {
	    return id;
	  }

	  public void setId(String id) {
	    this.id = id;
	  }

	  public String getAction() {
	    return action;
	  }

	  public void setAction(String action) {
	    this.action = action;
	  }

	  public Product getProduct() {
	    return product;
	  }

	  public void setProduct(Product product) {
	    this.product = product;
	  }
}
