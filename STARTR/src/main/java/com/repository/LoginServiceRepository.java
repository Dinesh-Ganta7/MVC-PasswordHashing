package com.repository;

import com.entity.User;

public interface LoginServiceRepository {

	public void signUpUser(User user);
	
	public User getUser(String email);

}
