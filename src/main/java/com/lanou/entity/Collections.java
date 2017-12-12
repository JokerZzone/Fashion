package com.lanou.entity;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

public class Collections {

	private int rec_id;
	private int user_id;
	private Goods goods;
	private Date add_time;
	
	public int getRec_id() {
		return rec_id;
	}
	public void setRec_id(int rec_id) {
		this.rec_id = rec_id;
	}
	public int getUser_id() {
		return user_id;
	}
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
	public Goods getGoods() {
		return goods;
	}
	public void setGoods(Goods goods) {
		this.goods = goods;
	}
	@JsonFormat(pattern="yyyy/MM/dd HH:mm:ss")
	public Date getAdd_time() {
		return add_time;
	}
	public void setAdd_time(Date add_time) {
		this.add_time = add_time;
	}
	public Collections() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Collections(int user_id, Goods goods, Date add_time) {
		super();
		this.user_id = user_id;
		this.goods = goods;
		this.add_time = add_time;
	}
	
	
	
}
