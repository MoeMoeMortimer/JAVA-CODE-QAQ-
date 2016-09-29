package com.hpe.jdbc.biz;

import java.util.List;

import com.hpe.jdbc.dao.ProductDao;
import com.hpe.jdbc.po.Product;

/**
 * 商品信息业务实现
 * @author LIUYIYU
 *
 */
public class ProductBizImpl implements ProductBiz{
	//引入Dao
	ProductDao pdao = new ProductDao();

	@Override
	public boolean add(Product p) {
		String sql = "insert into t_product values(?,?,?,?,?,?)";
		//params中的参数是按顺序逐个给？赋值，因此需要注意数据表顺序
		Object[] params = {p.getProid(),p.getProname(),p.getType(),p.getStorecount(),
						   p.getSugpurchase(),p.getSugsell()};
		return pdao.update(sql, params);
	}

	@Override
	public boolean delete(int proid) {
		// 软删除操作
		String sql = "update t_product set state = 0 where proid = ?";
		Object[] params = {proid};
		return pdao.update(sql, params);
	}

	@Override
	public boolean update(Product p) {
		String sql = "update t_product set proname = ?,type = ?,sugpurchase = ?, sugsell = ? where proid = ?";
		Object[] params = {p.getProname(), p.getType(), p.getSugpurchase(), p.getSugsell(), p.getProid()};
		return pdao.update(sql, params);
	}

	@Override
	public Product findByID(int proid) {
		String sql = "select * from t_product where proid = ?";
		Object[] params = {proid};
		return (Product) pdao.get(sql, Product.class, params);
	}

	@Override
	public List<Product> findAll() {
		String sql = "select * from t_product where state = 1";
		return pdao.query(sql, Product.class);
	}

	@Override
	public List<Product> findByCondition(String condition) {
		String sql = "select * from t_product where state = 1 and concat(proname, type) like ?";
		Object[] params = {"%"+condition+"%"};
		return pdao.query(sql, Product.class, params);
	}

}
