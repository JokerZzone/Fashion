package com.lanou.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lanou.dao.CollectionMapper;
import com.lanou.entity.Collections;
import com.lanou.service.CollectionService;

@Service("CollectionService")
public class CollectionServiceImpl implements CollectionService{

	@Autowired
	private CollectionMapper collectionMapper;
	
	@Override
	public List<Collections> findCollectionByUId(int uId,int startPos,int nowPage) {
		// TODO Auto-generated method stub
		return collectionMapper.findCollectionByUId(uId,startPos,nowPage);
	}
	@Override
	public int getCountOfCollection(int user_id) {
		// TODO Auto-generated method stub
		return collectionMapper.getCountOfCollection(user_id);
	}

	@Override
	public void addCollection(int user_id, int goods_id) {
		// TODO Auto-generated method stub
		collectionMapper.addCollection(user_id, goods_id,new Date());
	}

	@Override
	public void deleteCollectionById(int user_id, int[] goods_ids) {
		// TODO Auto-generated method stub
		collectionMapper.deleteCollectionById(user_id, goods_ids);
	}

	@Override
	public void deleteAllCollection(int user_id) {
		// TODO Auto-generated method stub
		collectionMapper.deleteAllCollection(user_id);
	}

	
}
