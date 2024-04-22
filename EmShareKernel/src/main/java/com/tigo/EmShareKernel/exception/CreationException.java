package com.tigo.EmShareKernel.exception;

public class CreationException extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public CreationException(String message) {
		super(message);
	}
	
	public CreationException(String message, Throwable er) {
		super(message, er);
	}
	
}
