package com.lanou.service.impl;

import java.util.List;

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


	@Override
	public void updatePassword(User user) {
		// TODO Auto-generated method stub
		userMapper.updatePassword(user);
	}


	@Override
	public void updateUserByUId(User user) {
		// TODO Auto-generated method stub
		userMapper.updateUserByUId(user);
	}

	@Override
	public List<User> selectAllUserByNowPage(int startPos, int pageSize) {
		// TODO Auto-generated method stub
		return userMapper.selectAllUserByNowPage(startPos, pageSize);
	}
	@Override
	public int selectCountOfAllUser() {
		// TODO Auto-generated method stub
		return userMapper.selectCountOfAllUser();
	}

	@Override
	public User selectUserByUId(int user_id) {
		// TODO Auto-generated method stub
		return userMapper.selectUserByUId(user_id);
	}
}
