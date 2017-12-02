package com.lanou.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lanou.dao.UserMapper;
import com.lanou.entity.User;
import com.lanou.service.UserService;

@Service("userService")
public class UserServiceImpl implements UserService{

	@Autowired
	private UserMapper userMapper;


	public void addUser(User user) {
		// TODO Auto-generated method stub
		userMapper.addUser(user);
	}


	public User confirmUser(String username) {
		// TODO Auto-generated method stub
		return userMapper.confirmUser(username);
	}


	public User focusEmail(String email) {
		// TODO Auto-generated method stub
		return userMapper.focusEmail(email);
	}


	
	
	
}
