package com.example.demo.services;

import javax.security.auth.login.LoginException;

import com.example.demo.entities.LoggedSession;
import com.example.demo.entities.LoginCredential;

public interface UserLoginServices {

	public LoggedSession logIntoAccount(LoginCredential dto) throws LoginException;

	public String logOutFromAccount(String key) throws LoginException;
}
