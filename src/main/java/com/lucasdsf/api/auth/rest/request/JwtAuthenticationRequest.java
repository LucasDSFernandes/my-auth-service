package com.lucasdsf.api.auth.rest.request;

import com.fasterxml.jackson.annotation.JsonProperty;

public class JwtAuthenticationRequest {
	
	private String login;
	private String password;
	@JsonProperty("grant_type")
	private String grant_type;

	public JwtAuthenticationRequest() {
	}

	public String getLogin() {
		return login;
	}

	public String getPassword() {
		return password;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public void setPassword(String password) {
		this.password = password;
	}


	public String getGrant_type() {
		return grant_type;
	}

	public void setGrant_type(String grant_type) {
		this.grant_type = grant_type;
	}
	@Override
	public String toString() {
		return "JwtAuthenticationRequestDto [Documento=" + login + ", senha=" + password + "]";
	}
}
