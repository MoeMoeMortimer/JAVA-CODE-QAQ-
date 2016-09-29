package com.hpe.jdbc.view;
import java.util.List;
import java.util.Scanner;

import com.hpe.jdbc.dao.CustomerDao;
import com.hpe.jdbc.dao.CustomerDaoImpl;
import com.hpe.jdbc.po.Customer;

public class CustomerManager {
	//引入数据访问对象
	static CustomerDao pdao = new CustomerDaoImpl();
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
		System.out.println("------------ 增加客户 ------------");
		System.out.println("客户编号：");
		Integer cusid = sc.nextInt();
		System.out.println("客户名称：");
		String cusname = sc.next();
		System.out.println("客户电话：");
		String custel = sc.next();
		System.out.println("客户地址：");
		String cusaddr = sc.next();
		//组合对象
		Customer p = new Customer(cusid,cusname,custel,cusaddr);
		//调用数据访问类
		int result = pdao.add(p);
		if(result > 0){
			System.out.println("添加成功！");
		}else{
			System.out.println("添加失败！");
		}
		
	}
	private static void delete() {
		System.out.println("------------ 删除客户 ------------");
		System.out.println("客户编号：");
		int cusid = sc.nextInt();
		//查询
		Customer p = pdao.findByID(cusid);
		if(p == null){
			System.out.println("没有该客户信息");
			return ;
		}
		//打印客户信息
		System.out.println(p);
		System.out.println("您确定要删除吗？ 1是   0否");
		int answer = sc.nextInt();
		if(answer == 1){
			//调用数据访问类
			int result = pdao.delete(cusid);
			if(result > 0){
				System.out.println("删除成功！");
			}else{
				System.out.println("删除失败！");
			}
		}
	}
	private static void update() {
		System.out.println("------------ 修改客户信息 ------------");
		System.out.println("请输入要修改的客户编号：");
		int cusid = sc.nextInt();
		//查询
		Customer p = pdao.findByID(cusid);
		if(p == null){
			System.out.println("没有该商品信息");
			return ;
		}
		//打印商品信息
		System.out.println(p);
		//执行修改
		System.out.println("客户名称：");
		String cusname = sc.next();
		System.out.println("客户电话：");
		String custel = sc.next();
		System.out.println("客户地址：");
		String cusaddr = sc.next();
		p.setCusname(cusname);
		p.setCustel(custel);
		p.setCusaddr(cusaddr);
		//调用数据访问类
		int result = pdao.update(p);
		if(result > 0){
			System.out.println("修改成功！");
		}else{
			System.out.println("修改失败！");
		}
	}
	private static void findByID() {
		System.out.println("------------ 根据编号查找客户 ------------");
		System.out.println("请输入要查找的客户编号：");
		int cusid = sc.nextInt();
		//查询
		Customer p = pdao.findByID(cusid);
		if(p == null){
			System.out.println("没有该客户信息");
			return ;
		}
		//打印客户信息
		System.out.println(p);
		
	}
	private static void findAll() {
		System.out.println("------------ 查询所有 -----------");
		List<Customer> list = pdao.findAll();
		for(Customer p : list){
			System.out.println(p);
		}
	}
	private static void findByCondition() {
		System.out.println("----------- 模糊查询 -----------");
		System.out.println("请输入客户名称或电话、地址关键字：");
		String condition = sc.next();
		List<Customer> list = pdao.findByCondition(condition);
		if(list.size() == 0){
			System.out.println("没有查询到信息");
		}else{
			for(Customer p : list){
				System.out.println(p);
			}
		}
	}
}
