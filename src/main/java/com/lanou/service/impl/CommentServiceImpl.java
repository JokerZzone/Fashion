package com.lanou.service.impl;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lanou.dao.CommentMapper;
import com.lanou.entity.Comment;
import com.lanou.entity.User;
import com.lanou.service.CommentService;

@Service("commentService")
public class CommentServiceImpl implements CommentService {

	@Autowired
	private CommentMapper commentDao;

	@Override
	public boolean addComment(HttpSession session, String content, int goodsId) {
		// TODO Auto-generated method stub
		User user = (User)session.getAttribute("user");
		boolean result = false;
		if(user!=null) {
			String userName = user.getUsername();
			Date date=new Date();
			DateFormat format=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			String time=format.format(date); 
			if(commentDao.addComment(content, goodsId, userName, time)) {
				result = true;
				return result;
			}
		}
		return result;
	}

	@Override
	public List<Comment> commentList(int goodsId) {
		// TODO Auto-generated method stub
		return commentDao.commentList(goodsId);
	}

}
