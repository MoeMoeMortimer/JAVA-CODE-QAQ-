package com.hpe.jdbc.dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import com.hpe.jdbc.po.Product;
import com.hpe.jdbc.util.DBConnection;

public class ProductDaoImpl implements ProductDao {

	@Override
	public int add(Product p) {
		// 准备
		Connection conn = null;
		PreparedStatement pstmt = null;
		int result = 0;
		String sql = "insert into t_product(proid,proname,type,storecount,sugpurchase,sugsell) values(?,?,?,?,?,?);";
		// 访问数据库
		try {
			// 1连接对象
			conn = DBConnection.getConn();
			// 2创建执行对象
			pstmt = conn.prepareStatement(sql);
			// 给参数赋值
			pstmt.setInt(1, p.getProid());
			pstmt.setString(2, p.getProname());
			pstmt.setString(3, p.getType());
			pstmt.setInt(4, p.getStorecount());
			pstmt.setBigDecimal(5, p.getSugpurchase());
			pstmt.setBigDecimal(6, p.getSugsell());
			// 3执行
			result = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBConnection.closeStmt(pstmt);
			DBConnection.closeConn(conn);
		}
		return result;
	}

	@Override
	public int delete(int proid) {
		// 准备
		Connection conn = null;
		PreparedStatement pstmt = null;
		int result = 0;
		String sql = "delete from t_product where proid = ?;";
		// 访问数据库
		try {
			// 1连接对象
			conn = DBConnection.getConn();
			// 2创建执行对象
			pstmt = conn.prepareStatement(sql);
			// 给参数赋值
			pstmt.setInt(1, proid);
			// 3执行
			result = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		} finally {

			DBConnection.closeStmt(pstmt);
			DBConnection.closeConn(conn);
		}
		return result;
	}

	@Override
	public int update(Product p) {
		// 准备
		Connection conn = null;
		PreparedStatement pstmt = null;
		int result = 0;
		String sql = "update t_product set proname=? ,type=? ,storecount=? ,sugpurchase=?, sugsell=? where proid = ?;";
		// 访问数据库
		try {
			// 1连接对象
			conn = DBConnection.getConn();
			// 2创建执行对象
			pstmt = conn.prepareStatement(sql);
			// 给参数赋值
			pstmt.setString(1, p.getProname());
			pstmt.setString(2, p.getType());
			pstmt.setInt(3, p.getStorecount());
			pstmt.setBigDecimal(4, p.getSugpurchase());
			pstmt.setBigDecimal(5, p.getSugsell());
			pstmt.setInt(6, p.getProid());
			// 3执行
			result = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		} finally {

			DBConnection.closeStmt(pstmt);
			DBConnection.closeConn(conn);
		}
		return result;
	}

	@Override
	public Product findByID(int proid) {
		// 准备
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Product p = null;
		String sql = "select * from t_product where proid = ?;";
		// 访问数据库
		try {
			// 1连接对象
			conn = DBConnection.getConn();
			// 2创建执行对象
			pstmt = conn.prepareStatement(sql);
			// 给参数赋值
			pstmt.setInt(1, proid);
			// 3执行
			rs = pstmt.executeQuery();
			// 4 将rs中的值转到Product对象
			if (rs.next()) {
				p = new Product();
				p.setProid(rs.getInt(1));
				p.setProname(rs.getString(2));
				p.setType(rs.getString(3));
				p.setStorecount(rs.getInt(4));
				p.setSugpurchase(rs.getBigDecimal(5));
				p.setSugsell(rs.getBigDecimal(6));
			}
		} catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		} finally {
			DBConnection.closeRs(rs);
			DBConnection.closeStmt(pstmt);
			DBConnection.closeConn(conn);
		}
		return p;
	}

	@Override
	public List<Product> findAll() {
		// 准备
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<Product> list = new ArrayList<Product>();
		String sql = "select * from t_product;";
		// 访问数据库
		try {
			// 1连接对象
			conn = DBConnection.getConn();
			// 2创建执行对象
			pstmt = conn.prepareStatement(sql);
			// 3执行
			rs = pstmt.executeQuery();
			// 4 将rs中的值转到list集合中
			while (rs.next()) {
				Product p = new Product();
				p.setProid(rs.getInt(1));
				p.setProname(rs.getString(2));
				p.setType(rs.getString(3));
				p.setStorecount(rs.getInt(4));
				p.setSugpurchase(rs.getBigDecimal(5));
				p.setSugsell(rs.getBigDecimal(6));
				list.add(p);
			}
		} catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		} finally {
			DBConnection.closeRs(rs);
			DBConnection.closeStmt(pstmt);
			DBConnection.closeConn(conn);
		}
		return list;
	}

	@Override
	public List<Product> findByCondition(String condition) {
		// 准备
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<Product> list = new ArrayList<Product>();
		String sql = "select * from t_product where concat(proname,type) like ?;";
		// 访问数据库
		try {
			// 1连接对象
			conn = DBConnection.getConn();
			// 2创建执行对象
			pstmt = conn.prepareStatement(sql);
			//给参数赋值
			pstmt.setString(1, "%"+condition+"%");	
			// 3执行
			rs = pstmt.executeQuery();
			// 4 将rs中的值转到list集合中
			while (rs.next()) {
				Product p = new Product();
				p.setProid(rs.getInt(1));
				p.setProname(rs.getString(2));
				p.setType(rs.getString(3));
				p.setStorecount(rs.getInt(4));
				p.setSugpurchase(rs.getBigDecimal(5));
				p.setSugsell(rs.getBigDecimal(6));
				list.add(p);
			}
		} catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		} finally {
			DBConnection.closeRs(rs);
			DBConnection.closeStmt(pstmt);
			DBConnection.closeConn(conn);
		}
		return list;
	}
}
