package com.example.demo.services;

import com.example.demo.exceptions.AuthorizationException;

public interface AuthorizationServices {
	public boolean Auth(Integer id,String key)throws AuthorizationException;
}
