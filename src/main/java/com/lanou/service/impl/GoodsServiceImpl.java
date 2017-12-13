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

	public List<Goods> recommendGoods() {
		// TODO Auto-generated method stub
		return goodsMapper.recommendGoods();
	}

	public List<Goods> saleOutGoods() {
		// TODO Auto-generated method stub
		return goodsMapper.saleOut();
	}

	public Map<String, Object> weeklyGoods(int chooseId,int orders, int pageId) {
		// TODO Auto-generated method stub
		int pageId2 = (pageId - 1) * PAGE;
		List<Goods> goods = goodsMapper.weeklyGoods(chooseId,orders,pageId2, 36);
		total = goodsMapper.weeklyGoodsTotal();
		totalPage = (int) Math.ceil((double) (total) / (PAGE));
		Map<String, Object> maps = new HashMap<String, Object>();
		maps.put("nowPage", pageId);
		maps.put("total", total);
		maps.put("totalPage", totalPage);
		maps.put("goodList", goods);
		return maps;
	}

	public Map<String, Object> titleGoods(int titleId, int chooseId, int pageId, int sortId, int brandId,
			String[] attr_idAndType) {
		// TODO Auto-generated method stub
		int[] attrIds = getAttrIds(attr_idAndType);
		int typeId1 = attrIds[0];
		int typeId2 = attrIds[1];
		int typeId3 = attrIds[2];
		int typeId4 = attrIds[3];
		int typeId5 = attrIds[4];
		int typeId6 = attrIds[5];
		int typeId7 = attrIds[6];
		int typeId8 = attrIds[7];

		int pageId2 = (pageId - 1) * PAGE;
		List<Goods> goods = goodsMapper.findAllGoods(titleId, chooseId, pageId2, sortId, 36, brandId, typeId1, typeId2,
				typeId3, typeId4, typeId5, typeId6, typeId7, typeId8);
		total = goodsMapper.goodsTotal(titleId, brandId, typeId1, typeId2, typeId3, typeId4, typeId5, typeId6, typeId7,
				typeId8);
		totalPage = (int) Math.ceil((double) (total) / (PAGE));
		Map<String, Object> maps = new HashMap<String, Object>();
		maps.put("total", total);
		maps.put("totalPage", totalPage);
		maps.put("goodList", goods);

		// sp 得到商品属性集合
		maps.put("goodsAttrMap", getGoodAttributeByTitle(titleId, brandId, typeId1, typeId2, typeId3, typeId4, typeId5,
				typeId6, typeId7, typeId8));

		return maps;
	}

	public Map<String, Object> SecondGoods(int catId, int chooseId, int pageId, int sortId, int brandId,
			String[] attr_idAndType) {
		// TODO Auto-generated method stub
		int[] attrIds = getAttrIds(attr_idAndType);
		int typeId1 = attrIds[0];
		int typeId2 = attrIds[1];
		int typeId3 = attrIds[2];
		int typeId4 = attrIds[3];
		int typeId5 = attrIds[4];
		int typeId6 = attrIds[5];
		int typeId7 = attrIds[6];
		int typeId8 = attrIds[7];

		int pageId2 = (pageId - 1) * PAGE;
		List<Goods> goods = goodsMapper.findSecondGoods(catId, chooseId, pageId2, sortId, 36, brandId, typeId1, typeId2,
				typeId3, typeId4, typeId5, typeId6, typeId7, typeId8);
		total = goodsMapper.SecondGoodsTotal(catId, brandId, typeId1, typeId2, typeId3, typeId4, typeId5, typeId6,
				typeId7, typeId8);
		totalPage = (int) Math.ceil((double) (total) / (PAGE));
		Map<String, Object> maps = new HashMap<String, Object>();
		maps.put("total", total);
		maps.put("totalPage", totalPage);
		maps.put("goodList", goods);

		// sp 得到商品属性集合
		maps.put("goodsAttrMap", getGoodAttributeByCate(catId, brandId, typeId1, typeId2, typeId3, typeId4, typeId5,
				typeId6, typeId7, typeId8));

		return maps;
	}

	/**
	 * sp
	 */

	// 得到所有商品的属性集合ByTitle
	public Map<String, Object> getGoodAttributeByTitle(int titleId, int brandId, int typeId1, int typeId2, int typeId3,
			int typeId4, int typeId5, int typeId6, int typeId7, int typeId8) {

		List<Goods> goods = goodsMapper.selectGoodsAttr_idByTitle(titleId, brandId, typeId1, typeId2, typeId3, typeId4,
				typeId5, typeId6, typeId7, typeId8);
		Set<Integer> attr_idSet = new HashSet<Integer>();
		Set<Integer> brand_idSet = new HashSet<Integer>();
		for (Goods good : goods) {
			if (good != null && good.getGoodsAttr_id() != null) {
				String[] strs = good.getGoodsAttr_id().split("#");
				for (int i = 0; i < strs.length; i++) {
					attr_idSet.add(Integer.parseInt(strs[i]));
				}
			}
			brand_idSet.add(good.getBrandId());
		}
		Map<String, Object> goodsAttrMap = new HashMap<String, Object>();
		// 品牌
		List<Brand> goodsBrands = new ArrayList<Brand>();
		if (brandId == 0) {
			for (Integer brand_id : brand_idSet) {
				if (brand_id != null) {
					Brand brand = brandMapper.findBrandById(brand_id);
					brand.setBrandDesc(brand.getBrandDesc().substring(0, 1));
					goodsBrands.add(brand);
				}
			}
		} else {
			Brand brand = brandMapper.findBrandById(brandId);
			brand.setBrandDesc(brand.getBrandDesc().substring(0, 1));
			goodsBrands.add(brand);
		}
		if (goodsBrands != null) {
			goodsAttrMap.put("goodsBrands", getGoodsBrandsLetterMap(goodsBrands));
		}
		// other属性
		List<GoodsAttribute> goodsAttributes = new ArrayList<GoodsAttribute>();
		for (Integer attr_id : attr_idSet) {
			goodsAttributes.add(goodsAttributeMapper.selectGoodAttributeById(attr_id));
		}
		if (goodsAttributes != null) {
			goodsAttrMap.put("goodsAttributes", getOtherAttributeMap(goodsAttributes));
		}

		return goodsAttrMap;
	}

	// 得到所有商品的属性集合ByCategory
	public Map<String, Object> getGoodAttributeByCate(int cat_id, int brandId, int typeId1, int typeId2, int typeId3,
			int typeId4, int typeId5, int typeId6, int typeId7, int typeId8) {

		List<Goods> goods = goodsMapper.selectGoodsAttr_idByCate(cat_id, brandId, typeId1, typeId2, typeId3, typeId4,
				typeId5, typeId6, typeId7, typeId8);
		Set<Integer> attr_idSet = new HashSet<Integer>();
		Set<Integer> brand_idSet = new HashSet<Integer>();
		for (Goods good : goods) {
			if (good != null && good.getGoodsAttr_id() != null) {
				String[] strs = good.getGoodsAttr_id().split("#");
				for (int i = 0; i < strs.length; i++) {
					attr_idSet.add(Integer.parseInt(strs[i]));
				}
			}
			brand_idSet.add(good.getBrandId());
		}
		Map<String, Object> goodsAttrMap = new HashMap<String, Object>();

		// 品牌
		List<Brand> goodsBrands = new ArrayList<Brand>();
		for (Integer brand_id : brand_idSet) {
			if (brand_id != null) {
				Brand brand = brandMapper.findBrandById(brand_id);
				brand.setBrandDesc(brand.getBrandDesc().substring(0, 1));
				goodsBrands.add(brand);
			}
		}
		if (goodsBrands != null) {
			goodsAttrMap.put("goodsBrands", getGoodsBrandsLetterMap(goodsBrands));
		}
		// 二级分类显示类别
		if (confirmCategoryType(cat_id) == 2) {
			goodsAttrMap.put("childrenCategorys", categoryMapper.selectCategoryChildrenByParentId(cat_id));
		}
		if (confirmCategoryType(cat_id) == 3) {
			goodsAttrMap.put("childrenCategorys", categoryMapper.findByCatId(cat_id));
		}
		// other属性
		List<GoodsAttribute> goodsAttributes = new ArrayList<GoodsAttribute>();
		for (Integer attr_id : attr_idSet) {
			goodsAttributes.add(goodsAttributeMapper.selectGoodAttributeById(attr_id));
		}
		if (goodsAttributes != null) {
			goodsAttrMap.put("goodsAttributes", getOtherAttributeMap(goodsAttributes));
		}

		return goodsAttrMap;
	}

	// 确认分类级别，一级返回1，二级返回2 ...
	public int confirmCategoryType(int cat_id) {

		int type = 1;
		int parent_id = categoryMapper.confirmCategoryType(cat_id);
		while (true) {
			if (parent_id == 0) {
				return type;
			} else {
				parent_id = categoryMapper.confirmCategoryType(parent_id);
			}
			type++;
		}
	}

	// 一维数组[id,type,id,type...]
	// 数组处理
	public int[] getAttrIds(String[] attr_idAndType) {
		int[] attrIds = new int[8];
		for (int i = 0; i < attr_idAndType.length; i += 2) {
			for (int j = 1; j <= 8; j++) {
				if (Integer.parseInt(attr_idAndType[i + 1]) == j) {
					attrIds[j - 1] = Integer.parseInt(attr_idAndType[i]);
				}
			}
		}
		return attrIds;
	}

	// other属性处理，得到Map类型
	public Object getOtherAttributeMap(List<GoodsAttribute> goodsAttributes) {

		List<Object> goodsAttributes1 = new ArrayList<Object>();
		List<Object> goodsAttributes2 = new ArrayList<Object>();
		List<Object> goodsAttributes3 = new ArrayList<Object>();
		List<Object> goodsAttributes4 = new ArrayList<Object>();
		List<Object> goodsAttributes5 = new ArrayList<Object>();
		List<Object> goodsAttributes6 = new ArrayList<Object>();
		List<Object> goodsAttributes7 = new ArrayList<Object>();
		List<Object> goodsAttributes8 = new ArrayList<Object>();

		for (GoodsAttribute goodsAttribute : goodsAttributes) {

			switch (goodsAttribute.getGoodsAttrType()) {
			case 1:
				goodsAttributes1.add(goodsAttribute);
				break;
			case 2:
				goodsAttributes2.add(goodsAttribute);
				break;
			case 3:
				goodsAttributes3.add(goodsAttribute);
				break;
			case 4:
				goodsAttributes4.add(goodsAttribute);
				break;
			case 5:
				goodsAttributes5.add(goodsAttribute);
				break;
			case 6:
				goodsAttributes6.add(goodsAttribute);
				break;
			case 7:
				goodsAttributes7.add(goodsAttribute);
				break;
			case 8:
				goodsAttributes8.add(goodsAttribute);
				break;

			default:
				break;
			}
		}
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("产地", goodsAttributes1);
		map.put("包装", goodsAttributes2);
		map.put("规格", goodsAttributes3);
		map.put("功效", goodsAttributes4);
		map.put("肤质", goodsAttributes5);
		map.put("肌龄", goodsAttributes6);
		map.put("价格", goodsAttributes7);
		map.put("香调", goodsAttributes8);

		return map;
	}

	// 品牌首字母归类，得到Map
	public Object getGoodsBrandsLetterMap(List<Brand> brands) {

		List<Brand> brands1 = new ArrayList<Brand>();
		List<Brand> brands2 = new ArrayList<Brand>();
		List<Brand> brands3 = new ArrayList<Brand>();
		List<Brand> brands4 = new ArrayList<Brand>();
		List<Brand> brands5 = new ArrayList<Brand>();
		List<Brand> brands6 = new ArrayList<Brand>();
		List<Brand> brands7 = new ArrayList<Brand>();
		List<Brand> brands8 = new ArrayList<Brand>();
		for (Brand brand : brands) {
			switch (brand.getBrandDesc()) {
			case "A":
			case "B":
			case "C":
			case "D":
				brands1.add(brand);
				break;
			case "E":
			case "F":
			case "G":
				brands2.add(brand);
				break;
			case "H":
			case "I":
			case "J":
			case "K":
				brands3.add(brand);
				break;
			case "L":
			case "M":
			case "N":
				brands4.add(brand);
				break;
			case "O":
			case "P":
			case "Q":
				brands5.add(brand);
				break;
			case "R":
			case "S":
			case "T":
				brands6.add(brand);
				break;
			case "U":
			case "V":
			case "W":
				brands7.add(brand);
				break;
			case "X":
			case "Y":
			case "Z":
				brands8.add(brand);
				break;

			default:
				break;
			}

		}
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("ABCD", brands1);
		map.put("EFG", brands2);
		map.put("HIJK", brands3);
		map.put("LMN", brands4);
		map.put("OPQ", brands5);
		map.put("RST", brands6);
		map.put("UVW", brands7);
		map.put("XYZ", brands8);
		return map;
	}

	@Override
	public Goods findGoods(int goodsId) {
		return goodsMapper.findGoods(goodsId);
	}

	
	/**
	 * 卖家内容
	 */
	@Override
	public Map<String, Object> allGoodsNews(int pageId, int pageNumber) {
		// TODO Auto-generated method stub
		int pageFirst = (pageId-1)*pageNumber;
		List<Goods> goods = goodsMapper.allGoodsNews(pageFirst, pageNumber);
		int counts = goodsMapper.goodsCount();
		int page = (int)Math.ceil((double)counts/pageNumber);
		Map<String, Object> maps = new HashMap<>();
		maps.put("counts", counts);
		maps.put("pageId	", pageId);
		maps.put("page", page);
		maps.put("goods", goods);
		maps.put("pageNumber", pageNumber);
		return maps;
	}

	@Override
	public Goods goodNews(int goodsId) {
		// TODO Auto-generated method stub
		return goodsMapper.goodNews(goodsId);
	}

	@Override
	public boolean updateGood(Goods good) {
		// TODO Auto-generated method stub
		boolean result = goodsMapper.updateGoods(good);
		return result;
	}

	@Override
	public boolean deleteGood(int goodsId) {
		// TODO Auto-generated method stub
		return goodsMapper.deleteGood(goodsId);
	}
	
	@Override
	public boolean addGood(Goods good) {
		// TODO Auto-generated method stub
		return goodsMapper.addGood(good);
	}

	@Override
	public Map<String, Object> firstGoods(int catId, int pageId, int pageNumber) {
		// TODO Auto-generated method stub
		int pageFirst = (pageId-1)*pageNumber;
		List<Goods> goods = goodsMapper.firstGoods(catId,pageFirst,pageNumber);
		int counts = goodsMapper.firstGoodsCount(catId);
		int page = (int)Math.ceil((double)counts/pageNumber);
		Map<String, Object> maps = new HashMap<>();
		maps.put("counts", counts);
		maps.put("pageId", pageId);
		maps.put("page", page);
		maps.put("goods", goods);
		maps.put("pageNumber", pageNumber);
		return maps;
	}

	@Override
	public Map<String, Object> likesGoods(String name, int pageId, int pageNumber) {
		// TODO Auto-generated method stub
		int pageFirst = (pageId-1)*pageNumber;
		List<Goods> goods = goodsMapper.likes(name, pageFirst, pageNumber);
		int counts = goodsMapper.likesCount(name);
		int page = (int)Math.ceil((double)counts/pageNumber);
		Map<String, Object> maps = new HashMap<>();
		maps.put("counts", counts);
		maps.put("pageId", pageId);
		maps.put("page", page);
		maps.put("goods", goods);
		maps.put("pageNumber", pageNumber);
		return maps;
	}

	@Override
	public Map<String, Object> findDeletedGoods(int pageId, int pageNumber) {
		// TODO Auto-generated method stub
		int pageFirst = (pageId-1)*pageNumber;
		List<Goods> goods = goodsMapper.deletedGoods(pageFirst, pageNumber);
		int counts = goodsMapper.deletedGoodsCount();
		int page = (int)Math.ceil((double)counts/pageNumber);
		Map<String, Object> maps = new HashMap<>();
		maps.put("counts", counts);
		maps.put("pageId", pageId);
		maps.put("page", page);
		maps.put("goods", goods);
		maps.put("pageNumber", pageNumber);
		return maps;
	}

	@Override
	public Map<String, Object> likeDeleteGoods(String name, int pageId, int pageNumber) {
		// TODO Auto-generated method stub
		int pageFirst = (pageId-1)*pageNumber;
		List<Goods> goods = goodsMapper.likeDeleteGoods(name, pageFirst, pageNumber);
		int counts = goodsMapper.likeDeleteGoodsCount(name);
		int page = (int)Math.ceil((double)counts/pageNumber);
		Map<String, Object> maps = new HashMap<>();
		maps.put("counts", counts);
		maps.put("pageId", pageId);
		maps.put("page", page);
		maps.put("goods", goods);
		maps.put("pageNumber", pageNumber);
		return maps;
	}

	@Override
	public boolean restoreGood(int goodId) {
		// TODO Auto-generated method stub
		return goodsMapper.restoreGood(goodId);
	}

	@Override
	public boolean physicalDelete(int goodId) {
		// TODO Auto-generated method stub
		return goodsMapper.physicalDelete(goodId);
	}
}
