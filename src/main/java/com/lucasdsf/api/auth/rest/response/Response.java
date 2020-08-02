package com.lucasdsf.api.auth.rest.response;

import java.util.ArrayList;
import java.util.List;

public class Response<T> {
	
	private T data;
	private String status;
    private int code;
	private List<String> errors;
	
	public Response() {}
	
	public Response(String status, int code, List<String> errors) {
		this.status = status;
		this.code = code;
		this.errors = errors;
	}

	public Response(T data, String status, int code, List<String> errors) {
		this.data = data;
		this.status = status;
		this.code = code;
		this.errors = errors;
	}

	public T getData() {
		return data;
	}
	
	public void setData(T data) {
		this.data = data;
	}
	
	public List<String> getErrors() {
		if(this.errors == null) {
			return new ArrayList<String>();
		}
		return errors;
	}
	
	public void setErrors(List<String> errors) {
		this.errors = errors;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

}
