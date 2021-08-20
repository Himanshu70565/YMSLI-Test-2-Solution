package com.customerapp.exceptions;

public class DaoException extends RuntimeException{
	
	private static final long serialVersionUID = 1L;

	public DaoException(String arg0) {
		super(arg0);
	}

	public DaoException(Throwable arg0) {
		super(arg0);
	}

}
