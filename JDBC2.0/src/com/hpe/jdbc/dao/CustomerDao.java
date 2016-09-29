package com.hpe.jdbc.dao;
import java.util.List;

import com.hpe.jdbc.po.Customer;
/**
 * ���ݷ��ʽӿ�
 * @author LIUYIYU
 *
 */
public interface CustomerDao {
	//1���ӿͻ�
	public int add(Customer p);
	//ɾ���ͻ�
	public int delete(int cusid);
	//3�޸Ŀͻ�
	public int update(Customer p);
	//4���ݱ�Ų��ҿͻ�
	public Customer findByID(int cusid);
	//5��ѯ����
	public List<Customer> findAll();
	//6ģ����ѯ
	public List<Customer> findByCondition(String condition);
}
