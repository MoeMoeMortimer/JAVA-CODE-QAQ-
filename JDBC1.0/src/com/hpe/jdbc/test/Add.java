package com.hpe.jdbc.test;

import java.math.BigDecimal;
import java.sql.*;

/**
 * JDBC���Ӳ���
 * @author LIUYIYU
 *
 */

public class Add {
	public static void main(String[] args) {
		//1����������mysql������������
		//ע�⣺1��������Ҫ���뵽��ǰ��Ŀ��
		//2���������뵱ǰ��ĿĿ¼�£�������������Ŀ�ƶ�
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//��������
		//"jdbc:mysql://IP��ַ:3306/���ݿ���"(localhostָ����)
		String url = "jdbc:mysql://localhost:3306/production";
		String user = "root";
		String pwd = "527611";
		Connection conn = null;
		try {
			//�������Ӷ���
			conn = DriverManager.getConnection(url,user,pwd);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		System.out.println(conn);
		//sql���
		String sql = "insert into t_product(proid,proname,type,"
				+ "storecount,sugpurchase,sugsell) values(?,?,?,?,?,?);";
		//����ִ�ж��������Ӷ��󴴽�ִ�ж���.PreparedStatement����sql��䵽���ݿ��������
		PreparedStatement pstmt = null;
		try {
			pstmt = conn.prepareStatement(sql);
			//4��������ֵ,123ָ�ʺţ���λ��
			pstmt.setInt(1, 11);	//sql-int
			pstmt.setString(2, "������");		//sql-char varchar
			pstmt.setString(3, "Desk_1");
			pstmt.setInt(4, 0);
			pstmt.setBigDecimal(5, new BigDecimal(30));		//sql-decimal
			pstmt.setBigDecimal(6, new BigDecimal(60));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//5ִ�в��� ����
		try {
			//������Ӱ�������
			int result = pstmt.executeUpdate();
			//�ж�
			if(result>0){
				System.out.println("����ɹ���");
			}else {
				System.out.println("����ʧ�ܣ�");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//�ͷ���Դ
		try {
			pstmt.close();
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
}
