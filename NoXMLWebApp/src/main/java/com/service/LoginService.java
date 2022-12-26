package com.service;

import com.entity.User;

public interface LoginService {

	public void signupUser(String email, String password, String dob) throws Exception;

	public User getUser(String email);

	public boolean validateLogin(String username, String password) throws Exception;

	

}
