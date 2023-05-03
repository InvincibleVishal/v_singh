package com.loginRegistration.registration.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.loginRegistration.registration.entity.User;
import com.loginRegistration.registration.repository.RegistrationRepository;

@Service
public class RegistrationService {
	
	@Autowired
	private RegistrationRepository repo;
	
	public User fetchUserByEmailId(String emailId){
		
		return repo.findByEmailId(emailId);
		
	}

	public User registerUser(User user) {
		return repo.save(user);
	}

	public User fetchUserByEmailIdAndPaas(String emailId, String password) {
		// TODO Auto-generated method stub
		return repo.findByEmailIdAndPassword(emailId,password);
	}

}
