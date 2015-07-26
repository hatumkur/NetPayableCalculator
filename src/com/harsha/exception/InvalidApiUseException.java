package com.harsha.exception;

public class InvalidApiUseException extends Exception {

	private static final long serialVersionUID = 1997753363232807011L;

	public InvalidApiUseException(){
	}

	public InvalidApiUseException(String message){
		super(message);
	}

	public InvalidApiUseException(Throwable cause){
		super(cause);
	}

	public InvalidApiUseException(String message, Throwable cause){
		super(message, cause);
	}

	public InvalidApiUseException(String message, Throwable cause, 
			boolean enableSuppression, boolean writableStackTrace){
		super(message, cause, enableSuppression, writableStackTrace);
	}

}