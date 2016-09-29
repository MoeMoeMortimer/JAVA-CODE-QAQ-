package com.hpe.jdbc.test;

import java.sql.DriverManager;
import java.sql.*;


public class Delete {
	public static void main(String[] args) {
		//准备工作
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "delete from t_product where proid = ?;";
		int result = 0;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			String url = "jdbc:mysql://localhost:3306/production";
			String user = "root";
			String pwd = "527611";
			conn = DriverManager.getConnection(url,user,pwd);
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, 12);
			result = pstmt.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally{
			try {
				pstmt.close();
				conn.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		if(result > 0){
			System.out.println("删除成功！");
		}else {
			System.out.println("删除失败！");
		}
	}
}
