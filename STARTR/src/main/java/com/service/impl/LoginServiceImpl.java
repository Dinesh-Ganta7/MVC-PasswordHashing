package com.service.impl;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import com.entity.User;
import com.repository.LoginServiceRepository;
import com.service.LoginService;

@Service
public class LoginServiceImpl implements LoginService{
	
	@Autowired
	LoginServiceRepository loginServiceRepository;

	@Override
	public void signupUser(User user) {
		loginServiceRepository.signUpUser(user);
		
	}

	@Override
	public User getUser(String email) {
		return loginServiceRepository.getUser(email);
	}

	@Override
	public boolean validateLogin(String userName, String password) {
		User user = loginServiceRepository.getUser(userName);
		try {
			if (userName.equals(user.getEmail()) && password.equals(user.getPassword())) {
				
				return true;
			} else {
				return false;
			}
		}
		catch(NullPointerException e) {
			return false;
		}
	}


	
	

}
