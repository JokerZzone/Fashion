package com.lanou.entity;

public class Comment {

	private int commentId;
	
	private int commentType;
	
	private int idValue;
	
	private String username;
	
	private String content;
	
	private int commentRank;
	
	private String addTime;
	
	private String ipAddress;
	
	private int parentId;
	
	private int userId;

	public Comment() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getCommentId() {
		return commentId;
	}

	public void setCommentId(int commentId) {
		this.commentId = commentId;
	}

	public int getCommentType() {
		return commentType;
	}

	public void setCommentType(int commentType) {
		this.commentType = commentType;
	}

	public int getIdValue() {
		return idValue;
	}

	public void setIdValue(int idValue) {
		this.idValue = idValue;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public int getCommentRank() {
		return commentRank;
	}

	public void setCommentRank(int commentRank) {
		this.commentRank = commentRank;
	}

	public String getAddTime() {
		return addTime;
	}

	public void setAddTime(String addTime) {
		this.addTime = addTime;
	}

	public String getIpAddress() {
		return ipAddress;
	}

	public void setIpAddress(String ipAddress) {
		this.ipAddress = ipAddress;
	}

	public int getParentId() {
		return parentId;
	}

	public void setParentId(int parentId) {
		this.parentId = parentId;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}
}
