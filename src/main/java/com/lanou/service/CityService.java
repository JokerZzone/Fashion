package com.lanou.service;

import java.util.List;

import com.lanou.entity.City;

public interface CityService {

	public List<City> findProvince(int parentId);
	
	public List<City> findCity(int cityId);
}
