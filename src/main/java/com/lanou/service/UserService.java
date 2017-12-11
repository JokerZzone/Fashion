package com.lanou.service;

import com.lanou.entity.User;

public interface UserService {

	public User confirmUser(String username);
	
	public User selectUserByUId(int user_id);
	
	public User focusEmail(String email);
	
	public void addUser(User user);
	
	public void updatePassword(User user);
	
	public void updateUserByUId(User user);
}
