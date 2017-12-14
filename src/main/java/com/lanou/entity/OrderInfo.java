package com.lanou.entity;

public class OrderInfo {

	private int orderId;
	
	private String orderSn;
	
	private int userId;
	
	private int orderStatus;
	
	private int shippingStatus;
	
	private int payStatus;
	
	private Address address;
	
	private Order order;

	public OrderInfo() {
		// TODO Auto-generated constructor stub
	}

	public int getOrderId() {
		return orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	public String getOrderSn() {
		return orderSn;
	}

	public void setOrderSn(String orderSn) {
		this.orderSn = orderSn;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public int getOrderStatus() {
		return orderStatus;
	}

	public void setOrderStatus(int orderStatus) {
		this.orderStatus = orderStatus;
	}

	public int getShippingStatus() {
		return shippingStatus;
	}

	public void setShippingStatus(int shippingStatus) {
		this.shippingStatus = shippingStatus;
	}

	public int getPayStatus() {
		return payStatus;
	}

	public void setPayStatus(int payStatus) {
		this.payStatus = payStatus;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}
}
