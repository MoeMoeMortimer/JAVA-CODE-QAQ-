package com.hpe.jdbc.view;

import java.math.BigDecimal;
import java.util.List;
import java.util.Scanner;

import com.hpe.jdbc.dao.ProductDao;
import com.hpe.jdbc.dao.ProductDaoImpl;
import com.hpe.jdbc.po.Product;

public class ProductManager {
	//引入数据访问对象
	static ProductDao pdao = new ProductDaoImpl();
	static Scanner sc = new Scanner(System.in);
	public static void main(String[] args) {
		while(true){
			System.out.println("1增加  2删除  3修改  4根据编号查找  5查找所有  6模糊查询  0退出");
			int select = sc.nextInt();
			switch(select){
			case 1:add();break;
			case 2:delete();break;
			case 3:update();break;
			case 4:findByID();break;
			case 5:findAll();break;
			case 6:findByCondition();break;
			case 0:System.exit(0);
			default:System.out.println("您的选择有误！");
			}
		}
	}
	private static void add() {
		System.out.println("------------ 增加商品 ------------");
		System.out.println("商品编号：");
		Integer proid = sc.nextInt();
		System.out.println("商品名称：");
		String proname = sc.next();
		System.out.println("商品型号：");
		String type = sc.next();
		Integer storecount = 0;
		System.out.println("建议购买价:");
		BigDecimal sugpurchase = sc.nextBigDecimal();
		System.out.println("建议销售价：");
		BigDecimal sugsell = sc.nextBigDecimal();
		//组合对象
		Product p = new Product(proid,proname,type,storecount,sugpurchase,sugsell);
		//调用数据访问类
		int result = pdao.add(p);
		if(result > 0){
			System.out.println("添加成功！");
		}else{
			System.out.println("添加失败！");
		}
		
	}
	private static void delete() {
		System.out.println("------------ 删除商品 ------------");
		System.out.println("商品编号：");
		int proid = sc.nextInt();
		//查询
		Product p = pdao.findByID(proid);
		if(p == null){
			System.out.println("没有该商品信息");
			return ;
		}
		//打印商品信息
		System.out.println(p);
		System.out.println("您确定要删除吗？ 1是   0否");
		int answer = sc.nextInt();
		if(answer == 1){
			//调用数据访问类
			int result = pdao.delete(proid);
			if(result > 0){
				System.out.println("删除成功！");
			}else{
				System.out.println("删除失败！");
			}
		}
	}
	private static void update() {
		System.out.println("------------ 修改商品 ------------");
		System.out.println("请输入要修改的商品编号：");
		int proid = sc.nextInt();
		//查询
		Product p = pdao.findByID(proid);
		if(p == null){
			System.out.println("没有该商品信息");
			return ;
		}
		//打印商品信息
		System.out.println(p);
		//执行修改
		System.out.println("商品名称：");
		String proname = sc.next();
		System.out.println("商品型号：");
		String type = sc.next();
		Integer storecount = 0;
		System.out.println("建议购买价:");
		BigDecimal sugpurchase = sc.nextBigDecimal();
		System.out.println("建议销售价：");
		BigDecimal sugsell = sc.nextBigDecimal();
		p.setProname(proname);
		p.setType(type);
		p.setStorecount(storecount);
		p.setSugpurchase(sugpurchase);
		p.setSugsell(sugsell);
		//调用数据访问类
		int result = pdao.update(p);
		if(result > 0){
			System.out.println("修改成功！");
		}else{
			System.out.println("修改失败！");
		}
	}
	private static void findByID() {
		System.out.println("------------ 根据编号查找商品 ------------");
		System.out.println("请输入要查找的商品编号：");
		int proid = sc.nextInt();
		//查询
		Product p = pdao.findByID(proid);
		if(p == null){
			System.out.println("没有该商品信息");
			return ;
		}
		//打印商品信息
		System.out.println(p);
		
	}
	private static void findAll() {
		System.out.println("------------ 查询所有 -----------");
		List<Product> list = pdao.findAll();
		for(Product p : list){
			System.out.println(p);
		}
	}
	private static void findByCondition() {
		System.out.println("----------- 模糊查询 -----------");
		System.out.println("请输入商品名称或型号关键字：");
		String condition = sc.next();
		List<Product> list = pdao.findByCondition(condition);
		if(list.size() == 0){
			System.out.println("没有查询到信息");
		}else{
			for(Product p : list){
				System.out.println(p);
			}
		}
	}
}
