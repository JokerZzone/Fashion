package com.lanou.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lanou.dao.BrandMapper;
import com.lanou.dao.CategoryMapper;
import com.lanou.dao.GoodsAttributeMapper;
import com.lanou.dao.GoodsMapper;
import com.lanou.entity.Brand;
import com.lanou.entity.Goods;
import com.lanou.entity.GoodsAttribute;
import com.lanou.service.GoodsService;

@Service("goodsService")
public class GoodsServiceImpl implements GoodsService {

	@Autowired
	private GoodsMapper goodsMapper;
	
	@Autowired
	private GoodsAttributeMapper goodsAttributeMapper;
	
	@Autowired
	private BrandMapper brandMapper;
	
	@Autowired
	private CategoryMapper categoryMapper;

	private static final Integer PAGE = 36;

	int total = 0;

	int totalPage = 0;

	public Map<String, Object> titleGoods(int titleId, int chooseId, int pageId, int sortId) {
		// TODO Auto-generated method stub
		int pageId2 = (pageId - 1) * PAGE;
		List<Goods> goods = goodsMapper.findAllGoods(titleId, chooseId, pageId2, sortId, 36);
		total = goodsMapper.goodsTotal(titleId);
		totalPage = (int) Math.ceil((double) (total) / (PAGE));
		Map<String, Object> maps = new HashMap<String, Object>();
		maps.put("total", total);
		maps.put("totalPage", totalPage);
		maps.put("goodList", goods);
		
		//sp   得到商品属性集合
		maps.put("goodsAttrMap", getGoodAttributeByTitle(titleId));
		
		return maps;
	}

	public Map<String, Object> SecondGoods(int catId, int chooseId, int pageId, int sortId) {
		// TODO Auto-generated method stub
		int pageId2 = (pageId - 1) * PAGE;
		List<Goods> goods = goodsMapper.findSecondGoods(catId, chooseId, pageId2, sortId, 36);
		total = goodsMapper.SecondGoodsTotal(catId);
		totalPage = (int) Math.ceil((double) (total) / (PAGE));
		Map<String, Object> maps = new HashMap<String, Object>();
		maps.put("total", total);
		maps.put("totalPage", totalPage);
		maps.put("goodList", goods);
		
		//sp   得到商品属性集合
		maps.put("goodsAttrMap", getGoodAttributeByCate(catId));
		
		return maps;
	}
	
	//sp
	
	//得到所有商品的属性集合ByTitle
	public Map<String, Object> getGoodAttributeByTitle(int titleId) {
		
		List<Goods> goods = goodsMapper.selectGoodsAttr_idByTitle(titleId);
		Set<Integer> attr_idSet = new HashSet<Integer>();
		Set<Integer> brand_idSet = new HashSet<Integer>();
		for (Goods good : goods) {
			if ( good != null && good.getGoodsAttr_id() != null) {
				String[] strs = good.getGoodsAttr_id().split("#");
				for (int i = 0; i < strs.length; i++) {
					attr_idSet.add(Integer.parseInt(strs[i]));
				}				
			}
			brand_idSet.add(good.getBrandId());
		}
		//品牌
		List<Brand> goodsBrands = new ArrayList<Brand>();
		for (Integer brand_id : brand_idSet) {
			if (brand_id != null) {
				Brand brand = brandMapper.findBrandById(brand_id);
				brand.setBrandDesc(brand.getBrandDesc().substring(0, 1));
				goodsBrands.add(brand);				
			}
		}
		//other属性
		List<GoodsAttribute> goodsAttributes = new ArrayList<GoodsAttribute>();
		for (Integer attr_id : attr_idSet) {
			goodsAttributes.add(goodsAttributeMapper.selectGoodAttributeById(attr_id));
		}
		Map<String, Object> goodsAttrMap = new HashMap<String, Object>();
		goodsAttrMap.put("goodsBrands", goodsBrands);
		goodsAttrMap.put("goodsAttributes", goodsAttributes);
		
		return goodsAttrMap;
	}
	//得到所有商品的属性集合ByCategory
	public Map<String, Object> getGoodAttributeByCate(int cat_id) {
		
		List<Goods> goods = goodsMapper.selectGoodsAttr_idByCate(cat_id);
		Set<Integer> attr_idSet = new HashSet<Integer>();
		Set<Integer> brand_idSet = new HashSet<Integer>();
		for (Goods good : goods) {
			if ( good != null && good.getGoodsAttr_id() != null) {
				String[] strs = good.getGoodsAttr_id().split("#");
				for (int i = 0; i < strs.length; i++) {
					attr_idSet.add(Integer.parseInt(strs[i]));
				}				
			}
			brand_idSet.add(good.getBrandId());
		}
		Map<String, Object> goodsAttrMap = new HashMap<String, Object>();
		//品牌
		List<Brand> goodsBrands = new ArrayList<Brand>();
		for (Integer brand_id : brand_idSet) {
			if (brand_id != null) {
				Brand brand = brandMapper.findBrandById(brand_id);
				brand.setBrandDesc(brand.getBrandDesc().substring(0, 1));
				goodsBrands.add(brand);				
			}
		}
		goodsAttrMap.put("goodsBrands", goodsBrands);
		//二级分类显示类别
		if (confirmCategoryType(cat_id) == 2) {
			goodsAttrMap.put("childrenCategorys", categoryMapper.selectCategoryChildrenByParentId(cat_id));
		}
		if (confirmCategoryType(cat_id) == 3) {
			goodsAttrMap.put("childrenCategorys", categoryMapper.findByCatId(cat_id));
		}
		//other属性
		List<GoodsAttribute> goodsAttributes = new ArrayList<GoodsAttribute>();
		for (Integer attr_id : attr_idSet) {
			goodsAttributes.add(goodsAttributeMapper.selectGoodAttributeById(attr_id));
		}
		goodsAttrMap.put("goodsAttributes", goodsAttributes);
		
		return goodsAttrMap;
	}

	
	//确认分类级别，一级返回1，二级返回2 ...
	public int confirmCategoryType(int cat_id) {
		
		int type = 1;
		int parent_id = categoryMapper.confirmCategoryType(cat_id);
		while (true) {
			if (parent_id == 0) {
				return type;    
			}else {
				parent_id = categoryMapper.confirmCategoryType(parent_id);
			}
			type++;
		}
	}
	
	
}
