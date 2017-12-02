package com.lanou.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lanou.dao.BrandMapper;
import com.lanou.entity.Brand;
import com.lanou.service.BrandService;

@Service("brandService")
public class BrandServiceImpl implements BrandService {

	@Autowired
	private BrandMapper brandMapper;
	
	public List<Brand> selectLikeDesc_Letter(String braDesc) {
		// TODO Auto-generated method stub
		return brandMapper.selectLikeDesc_Letter(braDesc);
	}


	public List<Brand> selectLikeDesc_Country(String braDesc) {
		// TODO Auto-generated method stub
		return brandMapper.selectLikeDesc_Country(braDesc);
	}


	
}
