package com.lanou.contorller;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.lanou.entity.Comment;
import com.lanou.entity.User;
import com.lanou.service.CommentService;

@Controller
@RequestMapping("/comment")
public class CommentController {

	@Autowired
	private CommentService commentService;
	
	//增加某件商品的用户评论	
	@RequestMapping("addComment")
	@ResponseBody
	public String addComment(HttpSession session,@RequestParam("content")String content,
			@RequestParam("goodsId")int goodsId) {
		boolean result1 = commentService.addComment(session, content, goodsId);
		String result = "error";
		if(result1) {
			result = "success";
			return result;
		}
		return result;
	}
	
	@RequestMapping("lookComment")
	@ResponseBody
	public List<Comment> lookComment(@RequestParam("goodsId")int goodsId) {
		List<Comment> commentList = commentService.commentList(goodsId);
		return commentList;
	}
	
}
