package com.hpe.jdbc.dao;
import java.util.List;

import com.hpe.jdbc.po.Product;
/**
 * 数据访问接口
 * @author LIUYIYU
 *
 */
public interface ProductDao {
	//1增加商品
	public int add(Product p);
	//删除商品
	public int delete(int proid);
	//3修改商品
	public int update(Product p);
	//4根据编号查找商品
	public Product findByID(int proid);
	//5查询所有
	public List<Product> findAll();
	//6模糊查询
	public List<Product> findByCondition(String condition);
}
