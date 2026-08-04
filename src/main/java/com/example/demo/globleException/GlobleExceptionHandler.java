package com.example.demo.globleException;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

<<<<<<< HEAD
import com.example.demo.exception.DataIntegerityViolationEx;
=======
import com.example.demo.exception.CustomerServiceException;
>>>>>>> 4bdc65e555d8eb7fa1500e59b8644c3fd1d478d8
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
<<<<<<< HEAD
	
	@ExceptionHandler
	public ResponseEntity<String> handleUserServiceException(UserServiceException userException) {
		return new ResponseEntity<>(userException.getErrorMessage(),userException.getHttpStatus());
	}
	
	@ExceptionHandler
	public ResponseEntity<String> handleRestraruantServiceException (RestaurantTableServiceException tableException) {
			return new ResponseEntity<>(tableException.getErrorMsg(), tableException.getHttpStatus());
=======

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
>>>>>>> 4bdc65e555d8eb7fa1500e59b8644c3fd1d478d8
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
