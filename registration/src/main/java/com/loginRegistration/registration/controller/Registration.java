package com.loginRegistration.registration.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.loginRegistration.registration.entity.User;
import com.loginRegistration.registration.serviceImpl.RegistrationService;
// this is Controller
@RestController
@RequestMapping(value = "/user")
@CrossOrigin(origins = "http://localhost:4200/")
public class Registration {

	@Autowired
	private RegistrationService _service;
	
	@CrossOrigin(origins = "http://localhost:4200")
	@PostMapping(value = "/register")
	public User registerUser(@RequestBody User user) throws Exception {
		User userObj = null;
		String emailId = user.getEmailId();
		if (emailId != null && !emailId.isEmpty()) {
			userObj = _service.fetchUserByEmailId(emailId);
		}
		if (userObj != null) {
			throw new Exception("User with emailid " + emailId + "Already Exists");
		} else {
			userObj = _service.registerUser(user);
		}

		return userObj;

	}
	
	@CrossOrigin(origins = "http://localhost:4200")
	@PostMapping(value="/login")
	public User login (@RequestBody User user) throws Exception{
		User userObj=null;
		String emailId=user.getEmailId();
		String password=user.getPassword();
		
		if(emailId!=null && password!=null){
			userObj = _service.fetchUserByEmailIdAndPaas(emailId,password);
		}
		if(userObj==null){
			throw new Exception("User Doesnot Exist. please register");
		}
		
		
		return userObj;
	}

}
