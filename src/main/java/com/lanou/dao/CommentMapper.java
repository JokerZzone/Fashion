package com.lanou.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.lanou.entity.Comment;

@Repository
public interface CommentMapper {
	
	//增加用户进行评论
	public boolean addComment(@Param("content")String content,@Param("goodsId")int goodsId,
			@Param("userName")String userName,@Param("commentTime")String time);
	
	//查看某件商品下所有用户评论
	public List<Comment> commentList(@Param("goodsId")int goodsId);
	
}
