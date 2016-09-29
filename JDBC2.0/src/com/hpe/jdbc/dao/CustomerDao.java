package com.hpe.jdbc.dao;
import java.util.List;

import com.hpe.jdbc.po.Customer;
/**
 * 数据访问接口
 * @author LIUYIYU
 *
 */
public interface CustomerDao {
	//1增加客户
	public int add(Customer p);
	//删除客户
	public int delete(int cusid);
	//3修改客户
	public int update(Customer p);
	//4根据编号查找客户
	public Customer findByID(int cusid);
	//5查询所有
	public List<Customer> findAll();
	//6模糊查询
	public List<Customer> findByCondition(String condition);
}
