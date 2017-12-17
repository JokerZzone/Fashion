package com.lanou.entity;

import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonFormat;

public class Orders {
	
	private int orderId;
	private int user_id;
	private int status;
	private List<Cart> carts;
	private Address address;
	private Date beginTime;
	private Date endTime;
	private Double money;
	
	
	public Double getMoney() {
		return money;
	}

	public void setMoney(Double money) {
		this.money = money;
	}

	public int getOrderId() {
		return orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	public int getUser_id() {
		return user_id;
	}

	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public List<Cart> getCarts() {
		return carts;
	}

	public void setCarts(List<Cart> carts) {
		this.carts = carts;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}
	
	@JsonFormat(pattern="yyyy/MM/dd HH:mm:ss")
	public Date getBeginTime() {
		return beginTime;
	}

	public void setBeginTime(Date beginTime) {
		this.beginTime = beginTime;
	}
	
	@JsonFormat(pattern="yyyy/MM/dd HH:mm:ss")
	public Date getEndTime() {
		return endTime;
	}

	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}

	public Orders() {
		// TODO Auto-generated constructor stub
	}

	public Orders(int user_id, List<Cart> carts, Address address, Date beginTime) {
		super();
		this.user_id = user_id;
		this.carts = carts;
		this.address = address;
		this.beginTime = beginTime;
	}
	
	
}
