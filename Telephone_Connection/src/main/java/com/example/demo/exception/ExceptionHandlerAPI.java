package com.example.demo.exception;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
public class ExceptionHandlerAPI {
	
	//handling specific exceptions
	
		@ExceptionHandler(value= {TelephoneConnectionNotFoundException.class})
		public ResponseEntity<Object> handleAnyRequest(TelephoneConnectionNotFoundException ex, WebRequest request) {
			return new ResponseEntity<>(ex.getLocalizedMessage(), HttpStatus.NOT_FOUND);
		}
		
	    //handling specific exceptions
		
		@ExceptionHandler(value= {Exception.class})
		public ResponseEntity<Object> handleAnyRequest(Exception ex, WebRequest request) {
			return new ResponseEntity<>(ex.getLocalizedMessage(), HttpStatus.NOT_FOUND);
		}
		
		//handling Custom validation errors
		
		  @ExceptionHandler(MethodArgumentNotValidException.class)
		  public ResponseEntity<?> customValidationErrorHandling(MethodArgumentNotValidException ex,WebRequest request){
		  ErrorDetails error =new ErrorDetails(new Date(), "Validation Error",ex.getBindingResult().getFieldError().getDefaultMessage());
			return new ResponseEntity<>(error,HttpStatus.BAD_REQUEST);

		  }
}
