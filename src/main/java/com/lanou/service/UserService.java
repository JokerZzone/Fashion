package com.lanou.service;

import com.lanou.entity.User;

public interface UserService {

	public User confirmUser(String username);
	
	public void addUser(User user);
	
}
