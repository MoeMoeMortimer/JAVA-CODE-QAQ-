package com.hpe.jdbc.test;

import java.math.BigDecimal;
import java.sql.*;

/**
 * JDBC增加测试
 * @author LIUYIYU
 *
 */

public class Add {
	public static void main(String[] args) {
		//1加载驱动（mysql的驱动类名）
		//注意：1驱动必须要引入到当前项目中
		//2将驱动存入当前项目目录下，让驱动跟随项目移动
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//创建连接
		//"jdbc:mysql://IP地址:3306/数据库名"(localhost指本机)
		String url = "jdbc:mysql://localhost:3306/production";
		String user = "root";
		String pwd = "527611";
		Connection conn = null;
		try {
			//创建连接对象
			conn = DriverManager.getConnection(url,user,pwd);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		System.out.println(conn);
		//sql语句
		String sql = "insert into t_product(proid,proname,type,"
				+ "storecount,sugpurchase,sugsell) values(?,?,?,?,?,?);";
		//创建执行对象，由连接对象创建执行对象.PreparedStatement带着sql语句到数据库服务器上
		PreparedStatement pstmt = null;
		try {
			pstmt = conn.prepareStatement(sql);
			//4给参数赋值,123指问号？的位置
			pstmt.setInt(1, 11);	//sql-int
			pstmt.setString(2, "电脑桌");		//sql-char varchar
			pstmt.setString(3, "Desk_1");
			pstmt.setInt(4, 0);
			pstmt.setBigDecimal(5, new BigDecimal(30));		//sql-decimal
			pstmt.setBigDecimal(6, new BigDecimal(60));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//5执行操作 增加
		try {
			//返回受影响的行数
			int result = pstmt.executeUpdate();
			//判断
			if(result>0){
				System.out.println("插入成功！");
			}else {
				System.out.println("插入失败！");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//释放资源
		try {
			pstmt.close();
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
}
