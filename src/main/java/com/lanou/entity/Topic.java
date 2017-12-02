package com.lanou.entity;

public class Topic {

	private int topicId;
	
	private String title;
	
	private String Intro;
	
	private String startTime;
	
	private String endTime;
	
	private String data;
	
	private String template;
	
	private String css;

	@Override
	public String toString() {
		return "Topic [topicId=" + topicId + ", title=" + title + ", Intro=" + Intro + ", startTime=" + startTime
				+ ", endTime=" + endTime + ", data=" + data + ", template=" + template + ", css=" + css + "]";
	}

	public Topic() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getTopicId() {
		return topicId;
	}

	public void setTopicId(int topicId) {
		this.topicId = topicId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getIntro() {
		return Intro;
	}

	public void setIntro(String intro) {
		Intro = intro;
	}

	public String getStartTime() {
		return startTime;
	}

	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}

	public String getEndTime() {
		return endTime;
	}

	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	public String getTemplate() {
		return template;
	}

	public void setTemplate(String template) {
		this.template = template;
	}

	public String getCss() {
		return css;
	}

	public void setCss(String css) {
		this.css = css;
	}
}
