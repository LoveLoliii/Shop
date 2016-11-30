package com.ss.dao;

import java.sql.SQLException;

import javax.sql.DataSource;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.ResultSetHandler;
import org.apache.commons.dbutils.handlers.BeanHandler;

import com.ss.pojo.User;
import com.ss.util.DBUtil;

public class UserDAO {

	//泛型？ TODO 通用？
	public User query(User u) {
		/*Connection conn = DBUtil.getConnection();
		PreparedStatement pstm = null;
		ResultSet rs = null;
		try {
			String sql = "select * from usert where username=? and password =?";
			pstm =conn.prepareStatement(sql);
			pstm.setString(1, u.getUsername());
			pstm.setString(2,u.getPassword());
			rs = pstm.executeQuery();
			if(rs.next()){
				u.setUsername(rs.getString("username"));
				u.setPassword(rs.getString("password"));
			}
			DBUtil.destory(conn, pstm, rs);
			return u;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		DBUtil.destory(conn, pstm, rs);
		u = new User();
		return u;*/
		DataSource ds = DBUtil.getDs();
		ResultSetHandler<User> h = new BeanHandler<User>(User.class);
		QueryRunner run = new QueryRunner(ds);
		User user = null;
		try {
			user = run.query("select * from usert where username=? and password =?", h,u.getUsername(),u.getPassword());
		} catch (SQLException e) {
			e.printStackTrace();
		}
		if(user == null){
			user = new User() ;//解决空指针
		}
		return user;
	}

}
