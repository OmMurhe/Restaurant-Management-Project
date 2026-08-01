package com.example.demo.exception;

import org.springframework.http.HttpStatus;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Setter
@Getter
public class ProductServiceException extends RuntimeException{

	private String errorMessage;
	private HttpStatus httpStatus;
	
}
