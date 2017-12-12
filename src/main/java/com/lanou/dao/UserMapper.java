package com.lanou.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.lanou.entity.User;

@Repository
public interface UserMapper {

	public User confirmUser(String username);
	
	public User focusEmail(String email);
	
	public void addUser(User user);
	
	public void updatePassword(User user);
	
	//卖家版
	
	public void updateUserByUId(User user);
	
	//查找所有user并实现分页
	public List<User> selectAllUserByNowPage(int startPos,int pageSize);
	
	public int selectCountOfAllUser();

	public User selectUserByUId(int user_id);
	
}
