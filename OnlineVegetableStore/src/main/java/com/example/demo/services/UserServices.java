package com.example.demo.services;
import com.example.demo.exceptions.*;
import com.example.demo.entities.*;

public interface UserServices {
	public User createUser(User user) throws UserException;
	public User deleteUser(Integer userId) throws UserException;
	public User UpdateUser(Integer userId, User user) throws UserException;
}
