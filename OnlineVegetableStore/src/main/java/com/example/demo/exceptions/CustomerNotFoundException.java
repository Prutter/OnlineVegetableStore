package com.example.demo.exceptions;

public class CustomerNotFoundException extends RuntimeException {
   public CustomerNotFoundException() {};
   public CustomerNotFoundException(String msg) {
	   super(msg);
   }
	
	
}
