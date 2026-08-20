package com.example.demo.globleException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.example.demo.exception.DataIntegerityViolationEx;
import com.example.demo.exception.CustomerServiceException;
import com.example.demo.exception.OrderServiceException;
import com.example.demo.exception.ProductServiceException;
import com.example.demo.exception.RestaurantTableServiceException;
import com.example.demo.exception.UserServiceException;

@ControllerAdvice
@Component
public class GlobleExceptionHandler {
	@ExceptionHandler(ProductServiceException.class)
	public ResponseEntity<?> handleProductServiceException(ProductServiceException productException) {
		return new ResponseEntity<>(productException.getMessage(), productException.getHttpStatus());
	}
	
	@ExceptionHandler(UserServiceException.class)
	public ResponseEntity<?> handleUserServiceException(UserServiceException userException) {
		return new ResponseEntity<>(userException.getErrorMessage(),userException.getHttpStatus());
	}
	
	@ExceptionHandler(CustomerServiceException.class)
	public ResponseEntity<?> handleCustomerServiceException(CustomerServiceException customerException) {
		return new ResponseEntity<>(customerException.getErrorMsg(), customerException.getHttpStatus());
	}

	@ExceptionHandler(Exception.class)
	public ResponseEntity<?> handleException(Exception e) {
		return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler(RestaurantTableServiceException.class)
	public ResponseEntity <?> handleRestaruantServiceException (RestaurantTableServiceException tableException) {
		return new ResponseEntity<>(tableException.getErrorMsg(), tableException.getHttpStatus());
	}

	@ExceptionHandler(OrderServiceException.class)
	public ResponseEntity<?> handleOrderServiceException(OrderServiceException orderException) {

		return new ResponseEntity<>(orderException.getErrorMessage(), orderException.getHttpStatus());
	}

	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<String> handleValidationException(MethodArgumentNotValidException ex) {

	@ExceptionHandler(DataIntegerityViolationEx.class)
	public ResponseEntity<String> handleDataIntegrityViolation(DataIntegerityViolationEx ex) {

	    return new ResponseEntity<>(ex.getErrorMsg(), ex.getHttpStatus());
	}

	
}
