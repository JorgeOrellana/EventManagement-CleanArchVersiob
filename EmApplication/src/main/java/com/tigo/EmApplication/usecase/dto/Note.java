package com.tigo.EmApplication.usecase.dto;

public class Note {
	  private String text;
	  private boolean isSendSMS;

	  public String getText() {
	    return text;
	  }

	  public void setText(String text) {
	    this.text = text;
	  }

	  public boolean isSendSMS() {
	    return isSendSMS;
	  }

	  public void setSendSMS(boolean sendSMS) {
	    isSendSMS = sendSMS;
	  }
}
