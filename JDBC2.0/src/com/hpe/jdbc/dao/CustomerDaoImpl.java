package com.hpe.jdbc.dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import com.hpe.jdbc.po.Customer;
import com.hpe.jdbc.util.DBConnection;

public class CustomerDaoImpl implements CustomerDao {

	@Override
	public int add(Customer p) {
		// ׼��
		Connection conn = null;
		PreparedStatement pstmt = null;
		int result = 0;
		String sql = "insert into t_customer(cusid,cusname,custel,cusaddr) values(?,?,?,?)";
		// �������ݿ�
		try {
			// 1���Ӷ���
			conn = DBConnection.getConn();
			// 2����ִ�ж���
			pstmt = conn.prepareStatement(sql);
			// ��������ֵ
			pstmt.setInt(1, p.getCusid());
			pstmt.setString(2, p.getCusname());
			pstmt.setString(3, p.getCustel());
			pstmt.setString(4, p.getCusaddr());
			// 3ִ��
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
		// ׼��
		Connection conn = null;
		PreparedStatement pstmt = null;
		int result = 0;
		String sql = "delete from t_customer where cusid = ?;";
		// �������ݿ�
		try {
			// 1���Ӷ���
			conn = DBConnection.getConn();
			// 2����ִ�ж���
			pstmt = conn.prepareStatement(sql);
			// ��������ֵ
			pstmt.setInt(1, cusid);
			// 3ִ��
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
		// ׼��
		Connection conn = null;
		PreparedStatement pstmt = null;
		int result = 0;
		String sql = "update t_customer set cusname=? ,custel=? ,cusaddr=? where cusid = ?";
		// �������ݿ�
		try {
			// 1���Ӷ���
			conn = DBConnection.getConn();
			// 2����ִ�ж���
			pstmt = conn.prepareStatement(sql);
			// ��������ֵ
			pstmt.setString(1, p.getCusname());
			pstmt.setString(2, p.getCustel());
			pstmt.setString(3, p.getCusaddr());
			pstmt.setInt(4, p.getCusid());
			// 3ִ��
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
		// ׼��
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Customer p = null;
		String sql = "select * from t_customer where cusid = ?";
		// �������ݿ�
		try {
			// 1���Ӷ���
			conn = DBConnection.getConn();
			// 2����ִ�ж���
			pstmt = conn.prepareStatement(sql);
			// ��������ֵ
			pstmt.setInt(1, cusid);
			// 3ִ��
			rs = pstmt.executeQuery();
			// 4 ��rs�е�ֵת��Customer����
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
		// ׼��
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<Customer> list = new ArrayList<Customer>();
		String sql = "select * from t_customer";
		// �������ݿ�
		try {
			// 1���Ӷ���
			conn = DBConnection.getConn();
			// 2����ִ�ж���
			pstmt = conn.prepareStatement(sql);
			// 3ִ��
			rs = pstmt.executeQuery();
			// 4 ��rs�е�ֵת��list������
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
		// ׼��
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<Customer> list = new ArrayList<Customer>();
		String sql = "select * from t_customer where concat(cusname,custel,cusaddr) like ?";
		// �������ݿ�
		try {
			// 1���Ӷ���
			conn = DBConnection.getConn();
			// 2����ִ�ж���
			pstmt = conn.prepareStatement(sql);
			//��������ֵ
			pstmt.setString(1, "%"+condition+"%");	
			// 3ִ��
			rs = pstmt.executeQuery();
			// 4 ��rs�е�ֵת��list������
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
