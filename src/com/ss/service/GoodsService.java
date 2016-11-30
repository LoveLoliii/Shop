package com.ss.service;

import java.util.List;

import com.ss.pojo.Goods;

public interface GoodsService {
	public List<Goods> queryAll();
	public boolean deleteById(int id);
	//public boolean modifyById(int id);
	public Goods query(int value, String column);
	public boolean update(Goods g);
}
