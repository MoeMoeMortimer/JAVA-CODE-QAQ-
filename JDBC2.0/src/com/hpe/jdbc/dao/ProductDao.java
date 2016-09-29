package com.hpe.jdbc.dao;
import java.util.List;

import com.hpe.jdbc.po.Product;
/**
 * ���ݷ��ʽӿ�
 * @author LIUYIYU
 *
 */
public interface ProductDao {
	//1������Ʒ
	public int add(Product p);
	//ɾ����Ʒ
	public int delete(int proid);
	//3�޸���Ʒ
	public int update(Product p);
	//4���ݱ�Ų�����Ʒ
	public Product findByID(int proid);
	//5��ѯ����
	public List<Product> findAll();
	//6ģ����ѯ
	public List<Product> findByCondition(String condition);
}
