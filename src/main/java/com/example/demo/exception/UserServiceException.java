package com.example.demo.exception;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@Service
@AllArgsConstructor
public class UserServiceException extends RuntimeException {

	private String errorMessage;
	private HttpStatus httpStatus;
}
