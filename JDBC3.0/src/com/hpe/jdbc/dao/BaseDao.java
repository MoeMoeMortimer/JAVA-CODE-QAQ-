package com.hpe.jdbc.dao;

import java.sql.*;
import java.util.List;

import org.apache.commons.dbutils.DbUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

/**
 * �Է������ݿ�ͳһ����
 */
public class BaseDao {
	/**
	 * �������
	 * @return
	 */
	public Connection getConnection(){
		  Connection conn = null;
	        String jdbcURL = "jdbc:mysql://localhost:3306/production? useUnicode=true&characterEncoding=UTF8";
	        String jdbcDriver = "com.mysql.jdbc.Driver";
	        String user = "root";
	        String password = "527611";
	        try {
	        	//DbUtils�м��������ķ���
	            DbUtils.loadDriver(jdbcDriver);
	            conn = DriverManager.getConnection(jdbcURL, user, password);
	        } catch (SQLException e) {
	            e.printStackTrace();
	        } 
	        return conn;
	}
	
	 /**
     * ִ�и��µ�sql���,����,�޸�,ɾ��
     * @param sql
     * @return
     */
    public boolean update(String sql,Object[] params) {
        Connection conn = null;
        boolean flag = false;
        try {
            conn = getConnection();
            QueryRunner qRunner = new QueryRunner();
            int i = qRunner.update(conn,sql,params);
            if (i > 0) {
                flag = true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DbUtils.closeQuietly(conn);
        }
        return flag;
    }
    /**
     * ���Ҷ������
     * @param sql
     * @param clazz
     * @return
     */
	public List query(String sql, Class clazz) {
        List beans = null;
        Connection conn = null;
        try {
            conn = getConnection();
            QueryRunner qRunner = new QueryRunner();
            beans =
                (List) qRunner.query(
                    conn,
                    sql,
                    new BeanListHandler(clazz));
            //BeanListHandler�����˴�ResultSet�л�ȡ���ݣ���װ���󲢴���List����
            //Դ��ͬ����Ҫ�õ�ResultSet
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DbUtils.closeQuietly(conn);
        }
        return beans;
    }
    /**
     * ���ز�ѯ������󷽷�
     * @param sql
     * @param clazz
     * @return
     */
    public List query(String sql, Class clazz,Object[] params) {
        List beans = null;
        Connection conn = null;
        try {
            conn = getConnection();
            QueryRunner qRunner = new QueryRunner();
            beans = (List)qRunner.query(conn,sql, new BeanListHandler(clazz) ,params);
            
            //BeanListHandler�����˴�ResultSet�л�ȡ���ݣ���װ���󲢴���List����
            //Դ��ͬ����Ҫ�õ�ResultSet
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DbUtils.closeQuietly(conn);
        }
        return beans;
    }
    /**
     * ���Ҷ���
     * @param sql
     * @param clazz
     * @return
     */
    public Object get(String sql, Class clazz) {
        Object obj = null;
        Connection conn = null;
        try {
            conn = getConnection();
            QueryRunner qRunner = new QueryRunner();
            obj = qRunner.query(conn, sql,new BeanHandler(clazz));
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DbUtils.closeQuietly(conn);
        }
        return obj;
    }
    /**
     * ���ز�ѯ�����󷽷�
     * @param sql
     * @param clazz
     * @return
     */
    public Object get(String sql, Class clazz,Object[] params) {
        Object obj = null;
        Connection conn = null;
        try {
            conn = getConnection();
            QueryRunner qRunner = new QueryRunner();
            obj = qRunner.query(conn, sql, new BeanHandler(clazz),params);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DbUtils.closeQuietly(conn);
        }
        return obj;
    }
}
