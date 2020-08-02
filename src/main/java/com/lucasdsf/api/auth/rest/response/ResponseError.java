package com.lucasdsf.api.auth.rest.response;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.lucasdsf.api.auth.converter.CustomLocalDateTimeDeserializer;

public class ResponseError {

	private HttpStatus status;
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy hh:mm:ss")
	@JsonDeserialize(using = CustomLocalDateTimeDeserializer.class)
	private LocalDateTime timestamp;
	private String message;
	private String error;
	private int code;

	public ResponseError() {
		timestamp = LocalDateTime.now();
	}

	public ResponseError(HttpStatus status, String error) {
		this();
		this.status = status;
		this.code = status.value();
		this.error = error;
	}

	public ResponseError(HttpStatus status, String error,  String messagem) {
		this();
		this.status = status;
		this.error = error;
		this.code = status.value();
		this.message = messagem ;
	}

	public String getError() {
		return error;
	}
	public void setError(String error) {
		this.error = error;
	}

	public HttpStatus getStatus() {
		return status;
	}

	public LocalDateTime getTimestamp() {
		return timestamp;
	}

	public int getCode() {
		return code;
	}


	public void setStatus(HttpStatus status) {
		this.status = status;
	}

	public void setTimestamp(LocalDateTime timestamp) {
		this.timestamp = timestamp;
	}


	public void setCode(int code) {
		this.code = code;
	}


	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message= message;
	}
}