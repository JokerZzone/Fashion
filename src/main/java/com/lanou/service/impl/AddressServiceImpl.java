package com.lanou.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.lanou.dao.AddressMapper;
import com.lanou.entity.Address;
import com.lanou.service.AddressService;

@Service("addressService")
public class AddressServiceImpl implements AddressService {

	@Autowired
	private AddressMapper addressMapper;
	
	@Transactional
	@Override
	public List<Address> selectAll(int userId) {
		
		return addressMapper.selectAll(userId);
	}

	@Override
	public void addAddress(Address address) {
		
		int result = addressMapper.addAddress(address);
		System.out.println(result);
	}

	@Override
	public void updateAddress(Address address) {
		int result = addressMapper.updateAddress(address);
		System.out.println(result);
	}

	

	
}
