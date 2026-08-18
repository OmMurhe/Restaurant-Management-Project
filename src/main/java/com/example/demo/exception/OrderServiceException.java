package com.example.demo.exception;

import org.springframework.http.HttpStatus;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class OrderServiceException extends RuntimeException {

	private String errorMessage;
	private HttpStatus httpStatus;

}