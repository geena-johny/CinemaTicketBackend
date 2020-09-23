package com.example.UserService.service;

import com.example.UserService.model.Login;
import com.example.UserService.model.User;

public interface UserService {
	public void addUser(User user) throws Exception;
	public void authenticateUser(String userName, String password) throws Exception;
//	public User getUserDetails() throws Exception;
	public void updateProfile(User user) throws Exception;

	public void changePassword(String userName, String currentPassword, String newPassword) throws Exception;
}
