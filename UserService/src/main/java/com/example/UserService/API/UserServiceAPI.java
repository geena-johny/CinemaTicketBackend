package com.example.UserService.API;

import org.json.simple.JSONObject;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
//import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
//import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.server.ResponseStatusException;

import com.example.UserService.model.Login;
import com.example.UserService.model.User;
import com.example.UserService.service.UserService;



@RestController
@CrossOrigin
@RequestMapping(value="/userservice")
public class UserServiceAPI {
	
	@Autowired
	private UserService userService;
	@Autowired
	Environment env;
	
	@PostMapping(value="/addUser")
	public JSONObject addUser(@RequestBody User userDetails) throws Exception{
		try {
			userService.addUser(userDetails);
			String name=userDetails.getUserName();
			JSONObject obj=new JSONObject();
			obj.put(name, "You are successfully Registered");
			return obj;
		} catch(Exception e) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST,env.getProperty(e.getMessage()));
		}
	}
	
	
	
	@PostMapping(value="/authenticateUser")
	public JSONObject authenticateUser(@RequestBody Login loginDetails) throws Exception{
		JSONObject obj=new JSONObject();
		try {
			userService.authenticateUser(loginDetails.getUserName(),loginDetails.getPassword());
			
			obj.put("Message", "Authenticated");
			return obj;
		} 
		catch(Exception e){
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST,env.getProperty(e.getMessage()));
		}
	}
	
	@PostMapping(value = "/updateProfile")
	public ResponseEntity<String> updateCustomerProfile(@RequestBody User user) throws Exception {

		try
		{
			userService.updateProfile(user);
			String modificationSuccessMsg = env.getProperty("UserAPI.USER_DETAILS_UPDATION_SUCCESS");
			return new ResponseEntity<String>(modificationSuccessMsg, HttpStatus.OK);
			
		}
		catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, env.getProperty(e.getMessage()));
		}

	}
	
	@PostMapping(value = "/changePassword")
	public ResponseEntity<String> changePassword(@RequestBody User user) throws Exception {

		try
		{
			userService.changePassword(user.getUserName(), user.getPassword(), user.getNewPassword());
			String modificationSuccessMsg = env.getProperty("UserAPI.USER_PASSWORD_CHANGE_SUCCESS");
			return new ResponseEntity<String>(modificationSuccessMsg, HttpStatus.OK);
			
		}
		catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, env.getProperty(e.getMessage()));
		}

	}

}
