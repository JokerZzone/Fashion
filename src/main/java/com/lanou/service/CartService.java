package com.lanou.service;

import javax.servlet.http.HttpServletRequest;

public interface CartService {

	public void saveCart(int[] goods, int[] num, HttpServletRequest request);
}
