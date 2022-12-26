package com.service.impl;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import com.entity.User;
import com.repository.LoginServiceRepository;
import com.service.LoginService;
import com.utils.PasswordValidator;

@Service
public class LoginServiceImpl implements LoginService{
	
	@Autowired
	LoginServiceRepository loginServiceRepository;
	
	@Autowired
	PasswordValidator passwordValidator;

	

	@Override
	public User getUser(String email) {
		return loginServiceRepository.getUser(email);
	}

	@Override
	public boolean validateLogin(String userName, String password) throws Exception {
		User user = loginServiceRepository.getUser(userName);
		try {
			return passwordValidator.validatePassword(user.getSaltString(),user.getHashString(),password);
		}
		catch(NullPointerException e) {
			return false;
		}
	}

	@Override
	public void signupUser(String email, String password, String dob) throws Exception {
		loginServiceRepository.signUpUser(email, password, dob);;
		
	}

	


	
	

}
