package com.ss.util;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
 

public class DBUtil {
private static String jndiName = "java:/comp/env/jdbc/myocracle";
	public static Connection getConnection(){
		Connection conn = null;
		 
			/*Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection("jdbc:oracle:thin:@172.16.18.121:1521:ORCL","loveloliii","loveloliii");
			*/
			InitialContext ctx;
			try {
				ctx = new InitialContext();
				DataSource ds = (DataSource) ctx.lookup(jndiName);
				if(ds == null){
					System.out.println("ds is no exits");
				}else{
					conn = ds.getConnection();
				}
			 
			} catch (NamingException e) {
				e.printStackTrace();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
		return conn;
	}
	
	public static void destory(Connection conn,PreparedStatement pstm,ResultSet rs){
		if(rs != null){
			try {
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		if(pstm != null){
			try {
				pstm.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		
		if(conn!=null){
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
		}
		
	}

	public static DataSource getDs() {
		InitialContext ctx;
		try {
			ctx = new InitialContext();
			DataSource ds = (DataSource) ctx.lookup(jndiName);
			if(ds == null){
				System.out.println("ds is no exits");
			}else{
				return ds;
			}
		 
		} catch (NamingException e) {
			e.printStackTrace();
		}  
		
	return null;
	}
}
