package com.lanou.dao;

import com.lanou.entity.User;

public interface UserMapper {

	public User confirmUser(String username);
	
	public void addUser(User user);
	
}
