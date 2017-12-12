package com.lanou.service;

import java.util.List;

import com.lanou.entity.User;

public interface UserService {

	public User confirmUser(String username);
	
	public User selectUserByUId(int user_id);
	
	public User focusEmail(String email);
	
	public void addUser(User user);
	
	public void updatePassword(User user);
	
	public void updateUserByUId(User user);
	
	//查找所有user并实现分页
	//会员搜索 模糊查询
	public List<User> selectUserByNowPage(String username,int startPos,int pageSize);
	public int selectUserCount(String username);
}
