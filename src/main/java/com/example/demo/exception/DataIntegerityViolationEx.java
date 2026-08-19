package com.example.demo.exception;

import org.jspecify.annotations.Nullable;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class DataIntegerityViolationEx extends DataIntegrityViolationException {

	private String errorMsg;
	private HttpStatus httpStatus;

	public DataIntegerityViolationEx(@Nullable String errorMsg, HttpStatus httpStatus) {

		super(errorMsg);
		this.errorMsg = errorMsg;
		this.httpStatus = httpStatus;

		// TODO Auto-generated constructor stub
	}

}
