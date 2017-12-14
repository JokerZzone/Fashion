package com.lanou.service;

import java.util.List;

import com.lanou.entity.Address;

public interface AddressService {
	
	public List<Address> selectAll(int userId);
	
	public void addAddress(Address address);
	
	public void updateAddress(Address address);
}
