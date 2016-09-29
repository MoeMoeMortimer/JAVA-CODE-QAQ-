package com.hpe.jdbc.dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import com.hpe.jdbc.po.Customer;
import com.hpe.jdbc.util.DBConnection;

public class CustomerDaoImpl implements CustomerDao {

	@Override
	public int add(Customer p) {
		// 准备
		Connection conn = null;
		PreparedStatement pstmt = null;
		int result = 0;
		String sql = "insert into t_customer(cusid,cusname,custel,cusaddr) values(?,?,?,?)";
		// 访问数据库
		try {
			// 1连接对象
			conn = DBConnection.getConn();
			// 2创建执行对象
			pstmt = conn.prepareStatement(sql);
			// 给参数赋值
			pstmt.setInt(1, p.getCusid());
			pstmt.setString(2, p.getCusname());
			pstmt.setString(3, p.getCustel());
			pstmt.setString(4, p.getCusaddr());
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
	public int delete(int cusid) {
		// 准备
		Connection conn = null;
		PreparedStatement pstmt = null;
		int result = 0;
		String sql = "delete from t_customer where cusid = ?;";
		// 访问数据库
		try {
			// 1连接对象
			conn = DBConnection.getConn();
			// 2创建执行对象
			pstmt = conn.prepareStatement(sql);
			// 给参数赋值
			pstmt.setInt(1, cusid);
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
	public int update(Customer p) {
		// 准备
		Connection conn = null;
		PreparedStatement pstmt = null;
		int result = 0;
		String sql = "update t_customer set cusname=? ,custel=? ,cusaddr=? where cusid = ?";
		// 访问数据库
		try {
			// 1连接对象
			conn = DBConnection.getConn();
			// 2创建执行对象
			pstmt = conn.prepareStatement(sql);
			// 给参数赋值
			pstmt.setString(1, p.getCusname());
			pstmt.setString(2, p.getCustel());
			pstmt.setString(3, p.getCusaddr());
			pstmt.setInt(4, p.getCusid());
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
	public Customer findByID(int cusid) {
		// 准备
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Customer p = null;
		String sql = "select * from t_customer where cusid = ?";
		// 访问数据库
		try {
			// 1连接对象
			conn = DBConnection.getConn();
			// 2创建执行对象
			pstmt = conn.prepareStatement(sql);
			// 给参数赋值
			pstmt.setInt(1, cusid);
			// 3执行
			rs = pstmt.executeQuery();
			// 4 将rs中的值转到Customer对象
			if (rs.next()) {
				p = new Customer();
				p.setCusid(rs.getInt(1));
				p.setCusname(rs.getString(2));
				p.setCustel(rs.getString(3));
				p.setCusaddr(rs.getString(4));
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
	public List<Customer> findAll() {
		// 准备
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<Customer> list = new ArrayList<Customer>();
		String sql = "select * from t_customer";
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
				Customer p = new Customer();
				p.setCusid(rs.getInt(1));
				p.setCusname(rs.getString(2));
				p.setCustel(rs.getString(3));
				p.setCusaddr(rs.getString(4));
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
	public List<Customer> findByCondition(String condition) {
		// 准备
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<Customer> list = new ArrayList<Customer>();
		String sql = "select * from t_customer where concat(cusname,custel,cusaddr) like ?";
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
				Customer p = new Customer();
				p.setCusid(rs.getInt(1));
				p.setCusname(rs.getString(2));
				p.setCustel(rs.getString(3));
				p.setCusaddr(rs.getString(4));
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
