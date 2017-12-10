package com.lanou.dao;

import org.springframework.stereotype.Repository;

import com.lanou.entity.Ad;

@Repository
public interface AdMapper {

	public Ad findAdById(int adId);
}
