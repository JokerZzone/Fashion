package com.lanou.dao;

import java.util.List;

import com.lanou.entity.City;

public interface CityMapper {

	public List<City> findProvince(int parentId);
	
	public List<City> findCity(int cityId);
}
