package com.example.demo.exceptions;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.NoHandlerFoundException;

@ControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(CustomerException.class)
	public ResponseEntity<MyErrorDetails> getCustomerException(CustomerException e,WebRequest res){
		 MyErrorDetails errorDetails= new MyErrorDetails();
		 errorDetails.setTimestamp(LocalDateTime.now());
		 errorDetails.setMessage(e.getMessage());
		 errorDetails.setDescription(res.getDescription(false));
		
		 return new ResponseEntity<MyErrorDetails>(errorDetails, HttpStatus.BAD_REQUEST);
	}
	
	
	@ExceptionHandler(CustomerNotFoundException.class)
	public ResponseEntity<MyErrorDetails> getCustomerNotFoundException(CustomerNotFoundException e,WebRequest res){
		 MyErrorDetails errorDetails= new MyErrorDetails();
		 errorDetails.setTimestamp(LocalDateTime.now());
		 errorDetails.setMessage(e.getMessage());
		 errorDetails.setDescription(res.getDescription(false));
		
		 return new ResponseEntity<MyErrorDetails>(errorDetails, HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<MyErrorDetails> getException(Exception e,WebRequest res){
		 MyErrorDetails errorDetails= new MyErrorDetails();
		 errorDetails.setTimestamp(LocalDateTime.now());
		 errorDetails.setMessage(e.getMessage());
		 errorDetails.setDescription(res.getDescription(false));
		
		 return new ResponseEntity<MyErrorDetails>(errorDetails, HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<MyErrorDetails> getMethodArgumentNotValidException(MethodArgumentNotValidException e){
		 MyErrorDetails errorDetails= new MyErrorDetails();
		 errorDetails.setTimestamp(LocalDateTime.now());
		 errorDetails.setMessage(e.getMessage());
		 errorDetails.setDescription(e.getBindingResult().getFieldError().getDefaultMessage());
		
		 return new ResponseEntity<MyErrorDetails>(errorDetails, HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(NoHandlerFoundException.class)
	public ResponseEntity<MyErrorDetails> getNoHandlerFoundException(NoHandlerFoundException e,WebRequest req){
		 MyErrorDetails errorDetails= new MyErrorDetails();
		 errorDetails.setTimestamp(LocalDateTime.now());
		 errorDetails.setMessage(e.getMessage());
		 errorDetails.setDescription(req.getDescription(false));
		
		 return new ResponseEntity<MyErrorDetails>(errorDetails, HttpStatus.BAD_REQUEST);
	}
	
}
