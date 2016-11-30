package com.ss.serviceImplement;

import java.util.List;

import com.ss.dao.GoodsDAO;
import com.ss.pojo.Goods;
import com.ss.service.GoodsService;

public class GoodsImplement implements GoodsService {

	@Override
	public List<Goods> queryAll() {
		GoodsDAO gd = new GoodsDAO();
		return gd.queryAll();
		
	}

	@Override
	public boolean deleteById(int id) {
		GoodsDAO gd = new GoodsDAO();
		
		return gd.delete(id,"id");
	}

	@Override
	public Goods query(int value, String column) {
		 
		GoodsDAO gd = new GoodsDAO();
		
		return gd.query(value, column);
	}

	@Override
	public boolean update(Goods g) {
		GoodsDAO gd = new GoodsDAO();
		return gd.upadte(g);
	}

}
