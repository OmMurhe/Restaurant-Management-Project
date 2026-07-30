package com.example.demo.globleException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.example.demo.exception.ProductServiceException;

@ControllerAdvice
@Component
public class GlobleExceptionHandler {
	
	@ExceptionHandler
	public ResponseEntity handleProductServiceException(ProductServiceException productException) {
		return new ResponseEntity<>(productException.getMessage(),productException.getHttpStatus());
	}
	
	@ExceptionHandler
	public ResponseEntity handleException(Exception e) {
		return new ResponseEntity(e.getMessage(),HttpStatus.BAD_REQUEST);
	}
	
	 @ExceptionHandler(MethodArgumentNotValidException.class)
	    public ResponseEntity<String> handleValidationException(MethodArgumentNotValidException ex) {

	        String message = ex.getBindingResult()
	                           .getFieldError()
	                           .getDefaultMessage();

	        return new ResponseEntity<>(message, HttpStatus.BAD_REQUEST);
	    }


}
