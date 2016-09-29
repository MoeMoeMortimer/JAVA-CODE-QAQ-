package com.hpe.jdbc.test;

import java.math.BigDecimal;
import java.sql.*;

public class Add2 {
	public static void main(String[] args) {
		//׼������
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "insert into t_product(proid,proname,type,"
				+ "storecount,sugpurchase,sugsell) values(?,?,?,?,?,?);";
		int result = 0;
		//�������ݿ�
		try {
			//1.��������
			Class.forName("com.mysql.jdbc.Driver");
			//2.��������
			String url = "jdbc:mysql://localhost:3306/production";
			String user = "root";
			String pwd = "527611";
			conn = DriverManager.getConnection(url, user, pwd);
			//3.����ִ�ж���
			pstmt = conn.prepareStatement(sql);
			//��������ֵ,123ָ�ʺţ���λ��
			pstmt.setInt(1, 12);	//sql-int
			pstmt.setString(2, "������");		//sql-char varchar
			pstmt.setString(3, "Desk_1");
			pstmt.setInt(4, 0);
			pstmt.setBigDecimal(5, new BigDecimal(30));		//sql-decimal
			pstmt.setBigDecimal(6, new BigDecimal(60));
			//4ִ��
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
			System.out.println("����ɹ���");
		}else {
			System.out.println("����ʧ�ܣ�");
		}
	}
}
