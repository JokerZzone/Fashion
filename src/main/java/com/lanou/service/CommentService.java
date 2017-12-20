package com.lanou.service;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import com.lanou.entity.Comment;

public interface CommentService {
	
//	public Map<String, Object> addComment(HttpSession session,String content,int goodsId,String userName);  
	
	//用户添加评论
	public boolean addComment(HttpSession session,String content,int goodsId);
	
	//查看商品下的评论
	public List<Comment> commentList(int goodsId);
}
