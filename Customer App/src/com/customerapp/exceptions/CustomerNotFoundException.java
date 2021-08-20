package com.customerapp.exceptions;

public class CustomerNotFoundException extends RuntimeException{

	private static final long serialVersionUID = 1L;

	public CustomerNotFoundException(String message) {
		super(message);
	}

	public CustomerNotFoundException(Throwable cause) {
		super(cause);
	}
	
	
}
