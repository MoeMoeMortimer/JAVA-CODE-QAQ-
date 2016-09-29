package com.hpe.jdbc.biz;
/**
 * ��Ʒҵ��ӿ�
 */

import java.util.List;

import com.hpe.jdbc.po.Product;

public interface ProductBiz {
	// 1������Ʒ
	public boolean add(Product p);

	// ɾ����Ʒ
	public boolean delete(int proid);

	// 3�޸���Ʒ
	public boolean update(Product p);

	// 4���ݱ�Ų�����Ʒ
	public Product findByID(int proid);

	// 5��ѯ����
	public List<Product> findAll();

	// 6ģ����ѯ
	public List<Product> findByCondition(String condition);
}
