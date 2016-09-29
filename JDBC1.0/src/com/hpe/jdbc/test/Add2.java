package com.hpe.jdbc.test;

import java.math.BigDecimal;
import java.sql.*;

public class Add2 {
	public static void main(String[] args) {
		//准备工作
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "insert into t_product(proid,proname,type,"
				+ "storecount,sugpurchase,sugsell) values(?,?,?,?,?,?);";
		int result = 0;
		//访问数据库
		try {
			//1.加载驱动
			Class.forName("com.mysql.jdbc.Driver");
			//2.创建连接
			String url = "jdbc:mysql://localhost:3306/production";
			String user = "root";
			String pwd = "527611";
			conn = DriverManager.getConnection(url, user, pwd);
			//3.创建执行对象
			pstmt = conn.prepareStatement(sql);
			//给参数赋值,123指问号？的位置
			pstmt.setInt(1, 12);	//sql-int
			pstmt.setString(2, "电脑桌");		//sql-char varchar
			pstmt.setString(3, "Desk_1");
			pstmt.setInt(4, 0);
			pstmt.setBigDecimal(5, new BigDecimal(30));		//sql-decimal
			pstmt.setBigDecimal(6, new BigDecimal(60));
			//4执行
			result = pstmt.executeUpdate();
			
		} catch (Exception e) {
			// TODO: handle exception
		}finally{
			try {
				pstmt.close();
				conn.close();
			} catch (Exception e2) {
				// TODO: handle exception
			}
		}
		if(result > 0){
			System.out.println("插入成功！");
		}else {
			System.out.println("插入失败！");
		}
	}
}
