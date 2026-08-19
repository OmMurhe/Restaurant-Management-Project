
package com.example.demo.exception;

import org.springframework.http.HttpStatus;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class UserServiceException extends RuntimeException {

	private String errorMessage;
	private HttpStatus httpStatus;
}
