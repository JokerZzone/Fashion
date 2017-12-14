package com.lanou.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lanou.dao.CityMapper;
import com.lanou.entity.City;
import com.lanou.service.CityService;

@Service("cityService")
public class CityServiceImpl implements CityService {

	@Autowired
	private CityMapper cityMapper;

	@Override
	public List<City> findProvince(int parentId) {
		
		return cityMapper.findProvince(parentId);
	}

	@Override
	public List<City> findCity(int cityId) {
		
		return cityMapper.findCity(cityId);
	}

}
