package com.lanou.dao;

import org.springframework.stereotype.Repository;

import com.lanou.entity.User;

@Repository
public interface UserMapper {

	public User confirmUser(String username);
	
	public User selectUserByUId(int user_id);
	
	public User focusEmail(String email);
	
	public void addUser(User user);
	
	public void updatePassword(User user);
	
	public void updateUserByUId(User user);
	
}
