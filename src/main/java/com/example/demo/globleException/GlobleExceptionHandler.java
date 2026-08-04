package com.example.demo.globleException;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.example.demo.exception.DataIntegerityViolationEx;
import com.example.demo.exception.ProductServiceException;
import com.example.demo.exception.RestaurantTableServiceException;
import com.example.demo.exception.UserServiceException;



@ControllerAdvice
@Component
public class GlobleExceptionHandler {
	
	@ExceptionHandler
	public ResponseEntity<String> handleProductServiceException(ProductServiceException productException) {
		return new ResponseEntity<>(productException.getErrorMessage(),productException.getHttpStatus());
	}
	
	@ExceptionHandler
	public ResponseEntity<String> handleUserServiceException(UserServiceException userException) {
		return new ResponseEntity<>(userException.getErrorMessage(),userException.getHttpStatus());
	}
	
	@ExceptionHandler
	public ResponseEntity<String> handleRestraruantServiceException (RestaurantTableServiceException tableException) {
			return new ResponseEntity<>(tableException.getErrorMsg(), tableException.getHttpStatus());
	}

	@ExceptionHandler
	public ResponseEntity<String> handleException(Exception e) {
		return new ResponseEntity<>(e.getMessage(),HttpStatus.BAD_REQUEST);
	}
	
	 @ExceptionHandler(MethodArgumentNotValidException.class)
	    public ResponseEntity<String> handleValidationException(MethodArgumentNotValidException ex) {

	        String message = ex.getBindingResult()
	                           .getFieldError()
	                           .getDefaultMessage();

	        return new ResponseEntity<>(message, HttpStatus.BAD_REQUEST);
	    }


	@ExceptionHandler(DataIntegerityViolationEx.class)
	public ResponseEntity<String> handleDataIntegrityViolation(DataIntegerityViolationEx ex) {

	    return new ResponseEntity<>(ex.getErrorMsg(), ex.getHttpStatus());
	}
}
