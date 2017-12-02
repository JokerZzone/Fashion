package com.lanou.service;

import com.lanou.entity.User;

public interface UserService {

	public User confirmUser(String username);
	
	public User focusEmail(String email);
	
	public void addUser(User user);
	
}
