package com.hpe.jdbc.test;

import java.math.BigDecimal;
import java.sql.*;

public class FindAll {
	public static void main(String[] args) {
		//׼������
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;//��ѯ�ó������
		//�޸Ľ���ɹ��ۺͽ������ۼ�
		String sql = "select * from t_product;";
		//�������ݿ�
		try {
			//��������
			Class.forName("com.mysql.jdbc.Driver");
			//��������
			String url = "jdbc:mysql://localhost:3306/production";
			String user = "root";
			String pwd = "527611";
			conn = DriverManager.getConnection(url,user,pwd);
			//����ִ�ж���
			pstmt = conn.prepareStatement(sql);
			//ִ��,rs�д洢�Ų�ѯ��Ľ��
			rs = pstmt.executeQuery();
			//��ӡ�����
			while(rs.next()){
				//rs�����ֶ�����next()��ʾ������һ��
				System.out.println(rs.getInt(1)+","
								  +rs.getString(2)+","
								  +rs.getString(3)+","
								  +rs.getInt(4)+","
								  +rs.getBigDecimal(5)+","
								  +rs.getBigDecimal(6));
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			try {
				//�ر�����˳��ģ��������ִ�ж������Ӷ���
				rs.close();
				pstmt.close();
				conn.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
	
	}
}