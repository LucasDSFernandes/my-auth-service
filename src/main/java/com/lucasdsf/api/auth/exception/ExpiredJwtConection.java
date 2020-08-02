package com.lucasdsf.api.auth.exception;

public class ExpiredJwtConection extends RuntimeException{

	private static final long serialVersionUID = 4376437720874140662L;

	public ExpiredJwtConection(String s) {
		super(s);
	}

	public ExpiredJwtConection(String s, Throwable throwable) {
		super(s, throwable);
	}

}
