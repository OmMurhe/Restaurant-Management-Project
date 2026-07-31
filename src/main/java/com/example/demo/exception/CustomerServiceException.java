package com.example.demo.exception;

import org.springframework.http.HttpStatus;

public class CustomerServiceException extends RuntimeException {

    private HttpStatus httpStatus;

    public CustomerServiceException(String message, HttpStatus httpStatus) {
        super(message);
        this.httpStatus = httpStatus;
    }

    public HttpStatus getHttpStatus() {
        return httpStatus;
    }
}