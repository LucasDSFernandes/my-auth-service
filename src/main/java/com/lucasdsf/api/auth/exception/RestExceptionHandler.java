package com.lucasdsf.api.auth.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.fasterxml.jackson.databind.exc.InvalidFormatException;
import com.lucasdsf.api.auth.rest.response.ResponseError;

@RestControllerAdvice
public class RestExceptionHandler extends ResponseEntityExceptionHandler {
	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	@Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        logError(ex);
        ResponseError response = new ResponseError(HttpStatus.BAD_REQUEST, "Arugument Not Valid",ex.getMessage());
        return handleExceptionInternal(ex, response, headers, HttpStatus.BAD_REQUEST, request);
    }
	
	@Override
    protected ResponseEntity<Object> handleHttpMessageNotReadable(HttpMessageNotReadableException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        logError(ex);
        Object message = null;
        
        if (ex.getCause() instanceof InvalidFormatException) {
            InvalidFormatException exception = (InvalidFormatException) ex.getCause();
            message = exception.getValue();
        }

        ResponseError response = new ResponseError(HttpStatus.BAD_REQUEST, "Request invalido.");
        return new ResponseEntity<>(response, new HttpHeaders(), HttpStatus.BAD_REQUEST);
    }
	 
	@ExceptionHandler({ErrorException.class})
    public ResponseEntity<Object> handleApiException(ErrorException ex) {
        logError(ex);
        
        ResponseError response = new ResponseError(HttpStatus.BAD_REQUEST, ex.getMessage());
        return new ResponseEntity<>(response, new HttpHeaders(), HttpStatus.BAD_REQUEST);
    }
	@ExceptionHandler({ExpiredJwtConection.class})
	public ResponseEntity<Object> handleApiExpiredException(ExpiredJwtConection ex) {
		logError(ex);
		
		ResponseError response = new ResponseError(HttpStatus.UNAUTHORIZED, ex.getMessage());
		return new ResponseEntity<>(response, new HttpHeaders(), HttpStatus.UNAUTHORIZED);
	}

	@ExceptionHandler({ BadCredentialsException.class })
	public ResponseEntity<Object> handleBadCredentialsException(BadCredentialsException ex) {
		logError(ex);
		
		ResponseError response = new ResponseError(HttpStatus.UNAUTHORIZED, "Invalid login or password");
		return new ResponseEntity<>(response, new HttpHeaders(), HttpStatus.UNAUTHORIZED);
	}

	@ExceptionHandler({Exception.class})
    public ResponseEntity<Object> handleGenericException(Exception ex) {
        logError(ex);
        
        ResponseError response = new ResponseError(HttpStatus.INTERNAL_SERVER_ERROR, "Erro na api", ex.getMessage());
        return new ResponseEntity<>(response, new HttpHeaders(), HttpStatus.INTERNAL_SERVER_ERROR);
    }
	
    private void logError(Exception ex) {
        logger.error(ex.getClass().getName(), ex);
        logger.error(ex.getClass().getName(), ex.getMessage());
        logger.error(ex.getClass().getName(), ex.getLocalizedMessage());
    }
}
