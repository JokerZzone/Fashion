package com.lanou.service;

import java.util.List;

import com.lanou.entity.Collections;

public interface CollectionService {

	public List<Collections> findCollectionByUId(int uId,int startPos,int nowPage);
	public int getCountOfCollection(int user_id);
	
	public void addCollection(int user_id,int goods_id);
	
	public void deleteCollectionById(int user_id,int[] goods_ids);
	
	public void deleteAllCollection(int user_id);
	
}
