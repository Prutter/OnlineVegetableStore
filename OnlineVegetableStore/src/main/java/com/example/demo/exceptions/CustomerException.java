package com.example.demo.exceptions;

public class CustomerException extends RuntimeException {
    public CustomerException() {};
    public CustomerException(String msg) {
    	super(msg);
    }
}
