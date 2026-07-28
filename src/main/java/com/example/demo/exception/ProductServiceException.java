package com.example.demo.exception;

import org.springframework.http.HttpStatus;

public class ProductServiceException extends RuntimeException{

	private String errorMessage;
	private HttpStatus httpStatus;
	
	
	
	public ProductServiceException(String errorMessage, HttpStatus httpStatus) {
		super();
		this.errorMessage = errorMessage;
		this.httpStatus = httpStatus;
	}


	@Override
	public String getMessage() {
		return errorMessage;
	}


	public HttpStatus getHttpStatus() {
		return httpStatus;
	}

	public void setHttpStatus(HttpStatus httpStatus) {
		this.httpStatus = httpStatus;
	}
	
	
}
