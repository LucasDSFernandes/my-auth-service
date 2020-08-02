package com.lucasdsf.api.auth.exception;

public class ErrorException extends RuntimeException{

	private static final long serialVersionUID = 4376437720874140662L;

	public ErrorException(String s) {
		super(s);
	}

	public ErrorException(String s, Throwable throwable) {
		super(s, throwable);
	}

}
