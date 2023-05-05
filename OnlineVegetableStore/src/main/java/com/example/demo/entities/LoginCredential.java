package com.example.demo.entities;

public class LoginCredential {
	private String username;
	private String password;
	public LoginCredential(String username, String password) {
		super();
		this.username = username;
		this.password = password;
	}
	public LoginCredential() {
		super();
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	@Override
	public String toString() {
		return "LoginCredential [username=" + username + ", password=" + password + "]";
	}
}
