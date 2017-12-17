package com.lanou.dao;

import java.util.List;

import com.lanou.entity.Address;

public interface AddressMapper {

	public List<Address> selectAll(int userId);
	
	public int addAddress(Address address);
	
	public int updateAddress(Address address);
	
	public void deleteAddress(int address_id);
}
