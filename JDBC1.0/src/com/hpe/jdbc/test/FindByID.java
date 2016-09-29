package com.hpe.jdbc.test;

import java.math.BigDecimal;
import java.sql.*;

public class FindByID {
	public static void main(String[] args) {
		//准备工作
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;//查询得出结果集
		//修改建议采购价和建议销售价
		String sql = "select * from t_product where proid = ?";
		//访问数据库
		try {
			//加载驱动
			Class.forName("com.mysql.jdbc.Driver");
			//创建连接
			String url = "jdbc:mysql://localhost:3306/production";
			String user = "root";
			String pwd = "527611";
			conn = DriverManager.getConnection(url,user,pwd);
			//创建执行对象
			pstmt = conn.prepareStatement(sql);
			//执行,rs中存储着查询后的结果
			pstmt.setInt(1, 5);
			rs = pstmt.executeQuery();
			//打印结果集
			if(rs.next()){
				//rs包含字段名，next()表示向下走一行
			/*	System.out.println(rs.getInt(1)+","
								  +rs.getString(2)+","
								  +rs.getString(3)+","
								  +rs.getInt(4)+","
								  +rs.getBigDecimal(5)+","
								  +rs.getBigDecimal(6));*/
				//也可以这样写
				System.out.println(rs.getInt("proid")+","
						  +rs.getString("proname")+","
						  +rs.getString("type")+","
						  +rs.getInt("storecount")+","
						  +rs.getBigDecimal("sugpurchase")+","
						  +rs.getBigDecimal("sugsell"));     
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			try {
				//关闭是有顺序的，结果集，执行对象，连接对象
				rs.close();
				pstmt.close();
				conn.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
	
	}
}