package com.lanou.contorller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.lanou.entity.Collections;
import com.lanou.entity.User;
import com.lanou.service.CollectionService;
import com.lanou.util.Page;

@Controller
@RequestMapping("/collection")
public class CollectionContorller {

	@Autowired
	private CollectionService collectionService;
	
	//查看收藏夹
	@RequestMapping("/findCollectionByUId")
	@ResponseBody
	public Map<String, Object> findCollectionByUId(HttpSession session,int nowPage) {
		User user = (User)session.getAttribute("user");
		int uId = user.getuId();
		Page page = new Page(collectionService.getCountOfCollection(uId), nowPage);
		List<Collections> collections = collectionService.findCollectionByUId(uId,page.getStartPos(),page.getPageSize());
		Map<String, Object> map = new HashMap<>();
		map.put("collections", collections);
		map.put("page", page);
		return map;
	}
	
	//添加收藏夹
	@RequestMapping("/addCollection")
	@ResponseBody
	public void addCollection(int uId,int goods_id) {
		
		collectionService.addCollection(uId, goods_id);
	}
	
	//删除一个或多个收藏
	@RequestMapping("/deleteCollection")
	@ResponseBody
	public void deleteCollection(int uId,int[] goodsIds) {
		collectionService.deleteCollectionById(uId, goodsIds);
	}
	
	//清空收藏夹
	@RequestMapping("/deleteAllCollection")
	@ResponseBody
	public void deleteAllCollection(int uId) {
		collectionService.deleteAllCollection(uId);
	}
	
	
}
