package com.hpe.jdbc.biz;
/**
 * 商品业务接口
 */

import java.util.List;

import com.hpe.jdbc.po.Product;

public interface ProductBiz {
	// 1增加商品
	public boolean add(Product p);

	// 删除商品
	public boolean delete(int proid);

	// 3修改商品
	public boolean update(Product p);

	// 4根据编号查找商品
	public Product findByID(int proid);

	// 5查询所有
	public List<Product> findAll();

	// 6模糊查询
	public List<Product> findByCondition(String condition);
}
