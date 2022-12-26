package com.repository;

import com.entity.User;

public interface LoginServiceRepository {

	public void signUpUser (String email, String password, String dob) throws Exception;
	
	public User getUser(String email);

}
