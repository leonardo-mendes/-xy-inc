package com.challengePoint.services.exceptions;

public class ParametersException extends RuntimeException{

	private static final long serialVersionUID = 1L;
	
	public ParametersException(String msg) {
		super(msg);
	}
	
	public ParametersException(String msg, Throwable cause) {
		super(msg, cause);
	}
	

}
