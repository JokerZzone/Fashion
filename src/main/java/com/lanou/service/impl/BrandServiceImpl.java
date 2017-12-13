package com.lanou.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lanou.dao.BrandMapper;
import com.lanou.entity.Brand;
import com.lanou.entity.Goods;
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

	@Override
	public Map<String, Object> findAllBrands(int pageId, int pageNumber) {
		// TODO Auto-generated method stub
		int pageId2 = (pageId - 1) * pageNumber;
		List<Brand> brand = brandMapper.allBrands(pageId2, pageNumber);
		int total = brandMapper.brandCount();
		int totalPage = (int) Math.ceil((double) (total) / (pageNumber));
		Map<String, Object> maps = new HashMap<String, Object>();
		maps.put("nowPage", pageId);
		maps.put("total", total);
		maps.put("totalPage", totalPage);
		maps.put("brand",brand);
		return maps;
	}

	@Override
	public Map<String, Object> findLikeBrands(String name, int pageId, int pageNumber) {
		// TODO Auto-generated method stub
		int pageId2 = (pageId - 1) * pageNumber;
		List<Brand> brand = brandMapper.likeBrands(name, pageId2, pageNumber);
		int total = brandMapper.likeBrandsCount();
		int totalPage = (int) Math.ceil((double) (total) / (pageNumber));
		Map<String, Object> maps = new HashMap<String, Object>();
		maps.put("nowPage", pageId);
		maps.put("total", total);
		maps.put("totalPage", totalPage);
		maps.put("brand",brand);
		return maps;
	}

	@Override
	public boolean addBrand(Brand brand) {
		// TODO Auto-generated method stub
		return brandMapper.addBrand(brand);
	}

	@Override
	public boolean updateBrand(Brand brand) {
		// TODO Auto-generated method stub
		return brandMapper.updateBrand(brand);
	}

	@Override
	public boolean deleteBrand(int brandId) {
		// TODO Auto-generated method stub
		return brandMapper.deleteBrand(brandId);
	}


	
}
