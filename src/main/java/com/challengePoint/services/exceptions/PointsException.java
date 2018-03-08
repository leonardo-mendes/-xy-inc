package com.challengePoint.services.exceptions;

public class PointsException extends RuntimeException{

	private static final long serialVersionUID = 1L;
	
	public PointsException(String msg) {
		super(msg);
	}
	
	public PointsException(String msg, Throwable cause) {
		super(msg, cause);
	}
	

}
