package com.lanou.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
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
	
	
	public List<User> selectUserByNowPage(
			@Param("username") String username,
			@Param("startPos") int startPos,
			@Param("pageSize") int pageSize
		);
	public int selectUserCount(@Param("username") String username);
}
