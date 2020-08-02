package com.lucasdsf.api.auth.rest.resource;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;

import com.lucasdsf.api.auth.domain.model.UserDetailDto;
import com.lucasdsf.api.auth.rest.request.JwtAuthenticationRequest;
import com.lucasdsf.api.auth.rest.response.JwtAuthenticationResponse;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

public interface AuthResource {

	@ApiResponses(value = { 
			@ApiResponse(code = 200, message = "Created", response = JwtAuthenticationResponse.class),
			@ApiResponse(code = 400, message = "Bad Request"),
			@ApiResponse(code = 404, message = "Not Found"),
			@ApiResponse(code = 500, message = "Internal Server Error") })
	@ApiOperation(value = "Endpoint para gerar token")
	ResponseEntity<JwtAuthenticationResponse> gerarTokenJwt(@RequestBody JwtAuthenticationRequest authenticationDto);

	@ApiResponses(value = { 
			@ApiResponse(code = 200, message = "Created", response = JwtAuthenticationResponse.class),
			@ApiResponse(code = 400, message = "Bad Request"),
			@ApiResponse(code = 404, message = "Not Found"),
			@ApiResponse(code = 500, message = "Internal Server Error") })
	@ApiOperation(value = "Endpoint para regerar token")
	ResponseEntity<UserDetailDto> gerarRefreshTokenJwt(HttpServletRequest request);

}
