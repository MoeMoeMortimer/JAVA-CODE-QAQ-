package com.hpe.jdbc.util;

import java.sql.*;
import java.sql.DriverManager;
import java.sql.ResultSet;

public class DBConnection {
	private static final String DRIVER = "com.mysql.jdbc.Driver";
	
	private static final String URL = "jdbc:mysql://localhost:3306/production? useUnicode=true&characterEncoding=UTF8";
	
	private static final String USER = "root";
	
	private static final String PASSWORD = "527611";
	//加载驱动
	static {
		try {
			Class.forName(DRIVER);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	//创建连接
	public static Connection getConn(){
		Connection conn = null;
		try {
			conn = DriverManager.getConnection(URL, USER, PASSWORD);
		} catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}
		return conn;
	}
	
	public static void closeConn(Connection conn){
		if(conn != null){
			try {
				conn.close();
			} catch (Exception e) {
				e.printStackTrace();
				// TODO: handle exception
			}
		}
	}
	
	public static void closeStmt(Statement stmt){
		if(stmt != null){
			try {
				stmt.close();
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
		}
	}
	
	public static void closeRs(ResultSet rs){
		if(rs != null){
			try {
				rs.close();
			} catch (Exception e) {
				e.printStackTrace();
				// TODO: handle exception
			}
		}
	}
}
