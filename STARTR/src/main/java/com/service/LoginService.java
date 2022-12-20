package com.service;

import com.entity.User;

public interface LoginService {

	public void signupUser(User user);

	public User getUser(String email);

	public boolean validateLogin(String username, String password);

}
