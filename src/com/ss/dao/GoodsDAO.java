package com.ss.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.ResultSetHandler;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import com.ss.pojo.Goods;
import com.ss.util.DBUtil;

public class GoodsDAO {
		//这样体现不出分层  是项目太简单 还是写的有问题 TODO 再看
	public List<Goods> queryAll(){
		/*Connection conn = DBUtil.getConnection();
		PreparedStatement pstm = null;
		ResultSet rs = null;
		Goods g = null;
		List<Goods> goodsList = new ArrayList<Goods>();
		try {
			pstm = conn.prepareStatement("select * from goods");
			rs = pstm.executeQuery();
			while(rs.next()){
			g = new Goods();
			g.setId(rs.getInt("id"));
			g.setGoodsName(rs.getString("goodsname"));
			g.setType(rs.getString("type"));
			g.setStock(rs.getInt("stock"));
			g.setPrice(rs.getFloat("price"));
			goodsList.add(g);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		DBUtil.destory(conn, pstm, rs);
		return goodsList;*/
		DataSource ds = DBUtil.getDs();
		QueryRunner run = new QueryRunner(ds);
		ResultSetHandler<List<Goods>> h = new BeanListHandler<Goods>(Goods.class);
		List<Goods> goodsList = new ArrayList<Goods>();
		try {
			goodsList = run.query("select * from goods", h);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return goodsList;
	}

	public boolean delete(int id, String column) {
		/*Connection conn = DBUtil.getConnection();
		PreparedStatement pstm = null;
		int rs = 0;
		if(column == "id"){
			try {
				pstm = conn.prepareStatement("delete from goods where id = ?");
				pstm.setInt(1, id);
				rs = pstm.executeUpdate();
				while(rs > 0){
					DBUtil.destory(conn, pstm, null);
				 return true;
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
		}
		return false;*/
		int rs = 0;
		DataSource ds = DBUtil.getDs();
	    QueryRunner run = new QueryRunner(ds);
	    try {
			rs =  run.update("delete from goods where id =?", id);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	    if(rs >0){
	    	return true;
	    }
		return false;
	}
//使用column 辨别一个查询条件 返回一个对象   对于返回集合应该怎么写 还是把一个也放在集合之中？ TODO <-
	public Goods query(int value, String column) {
		/*Connection conn = DBUtil.getConnection();
		PreparedStatement pstm = null;
		ResultSet rs = null;
		Goods g =new Goods();
		if(column == "id"){
			 
			try {
				String sql = "select * from goods where id = ?";
				pstm =conn.prepareStatement(sql);
				pstm.setInt(1,value);
				rs = pstm.executeQuery();
				if(rs.next()){
					g.setId(rs.getInt("id"));
					g.setGoodsName(rs.getString("name"));
					g.setType(rs.getString("type"));
					g.setStock(rs.getInt("stock"));
					g.setPrice(rs.getFloat("price"));
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			DBUtil.destory(conn, pstm, rs);
			return g;
			
		}
		DBUtil.destory(conn, pstm, rs);*/
		DataSource ds = DBUtil.getDs();
		QueryRunner run = new QueryRunner(ds);
		ResultSetHandler<Goods> h = new BeanHandler<Goods>(Goods.class);
		Goods g =new Goods();
		try {
			g = run.query("select * from goods where id =? ", h, value); //pojo的属性需要与列名一致 以便通过反射生成对象
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return g;
		
	}

	public boolean upadte(Goods g) {
/*		Connection conn = DBUtil.getConnection();
		PreparedStatement pstm = null;
		int rs = 0;
		try {
			String sql = "update  goods set goodsname = ?,type =? ,stock =? ,price = ? where id = ?";
			pstm =conn.prepareStatement(sql);
			pstm.setString(1, g.getGoodsName());
			pstm.setString(2, g.getType());
			pstm.setInt(3,g.getStock());
			pstm.setFloat(4, g.getPrice());
			pstm.setInt(5, g.getId());
			rs = pstm.executeUpdate();
			if(rs > 0){
				DBUtil.destory(conn, pstm, null);
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		DBUtil.destory(conn, pstm, null);
		return false;*/
		DataSource ds = DBUtil.getDs();
		int rs = 0 ; 
		QueryRunner run = new QueryRunner(ds);
		try {
			rs = run.update("update goods set goodsname = ?,type = ?,stock = ? ,price = ? where id =?",g.getGoodsName(),g.getType(),g.getStock(),g.getPrice(),g.getId());//有点复杂？？？？
		} catch (SQLException e) {
			e.printStackTrace();
		}
		if(rs > 0){
			return true;
		}
		return false;
	}
	
}
