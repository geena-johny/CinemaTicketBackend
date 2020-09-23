package com.example.UserService.user;

import com.example.UserService.model.Login;
import com.example.UserService.model.User;

public interface UserDAO {
	
	public void addUser(User user) throws Exception;
	public User getUser(String userName) throws Exception;
	public Login authenticateUser(String userName, String password) throws Exception;
	
	public String getPasswordOfUser(String userName) ;
	public User getUserByPhoneNumber(String phoneNumber);

	public void updateProfile(User user);
	public void changePassword(String userName, String newHashedPassword);
	
}
