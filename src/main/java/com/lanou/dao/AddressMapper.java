package com.lanou.dao;

import java.util.List;

import com.lanou.entity.Address;

public interface AddressMapper {

	public List<Address> selectAllAddressesByUId(int uId);
	
}
