package com.hpe.jdbc.test;

import java.math.BigDecimal;
import java.sql.*;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class Update {
	public static void main(String[] args) {
		//准备工作
		Connection conn = null;
		PreparedStatement pstmt = null;
		Statement stmt = null;
		//修改建议采购价和建议销售价
		String sql = "update t_product set sugpurchase = ?, sugsell = ? where proid = ?;";
		String sql2 = "update t_product set sugpurchase =30, sugsell = 60 where proid = 1;";
		int result = 0;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			String url = "jdbc:mysql://localhost:3306/production";
			String user = "root";
			String pwd = "527611";
			conn = DriverManager.getConnection(url,user,pwd);
			stmt = conn.createStatement();
			result = stmt.executeUpdate(sql2);
			//pstmt = conn.prepareStatement(sql);
			//pstmt.setBigDecimal(1, new BigDecimal(100));		//sql-decimal
			//pstmt.setBigDecimal(2, new BigDecimal(200));
			//pstmt.setInt(3, 11);
			//result = pstmt.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			try {
				
				//pstmt.close();
				conn.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		if(result > 0){
			System.out.println("修改成功！");
		}else {
			System.out.println("修改失败！");
		}
	}
}
