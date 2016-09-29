package com.hpe.t12.work2;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class PhoneBookManager {
	// 电话本集合
	static ArrayList<PhoneBook> books = new ArrayList<PhoneBook>();
	static Scanner sc = new Scanner(System.in);
	static File f = new File("d:\\phonebook.txt");	//电话本文件
	static File f1 = new File("d:\\history.txt");	//操作日志文件
	public static void main(String[] args) {
		if (f.exists() == false || f1.exists() == false) {
			// 创建一个新电话簿
			try {
				f.createNewFile();
				f1.createNewFile();
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		int choice;
		while (true) {
			Menu();
			choice = sc.nextInt();
			switch (choice) {
			case 1:
				add();
				break;
			case 2:
				delete();
				break;
			case 3:
				update();
				break;
			case 4:
				find();
				break;
			case 5:
				findAll();
				break;
			case 6:
				readAllfromHistory(f1);
				break;
			case 7:
				System.exit(0);
			default:
				System.out.println("无效的请求，请重新输入。");
			}
		}
	}

	public static void Menu() {
		System.out.println("--------------- 电话本管理系统 ----------------");
		System.out.println("1增加  2删除  3修改  4查找  5查找所有   6查看操作记录   7退出");
		System.out.println("请选择业务：");
	}

	private static void findAll() {
		readAlltoList(f);
		System.out.println("----------------- 所有联系人 -----------------");
		for (PhoneBook b : books) {
			System.out.println(b);
		}
	}
	
	private static void find() {
		readAlltoList(f);
		System.out.println("------------------ 查找电话本 -----------------");
		System.out.println("请选择： 1.精确查找（按姓名查找）   2.模糊查找");
		int choice = sc.nextInt();
		if (choice == 2) {
			vagueSearch();
		}
		System.out.println("请输入要查找的姓名：");
		String name = sc.next();
		int index = findByName(name);
		if (index == -1)
			System.out.println("没有找到相关信息。");
		else
			System.out.println(books.get(index));
	}

	//为修改操作添加了模糊查找
	private static void update() {
		readAlltoList(f);
		System.out.println("----------------- 修改电话本 -----------------");
		System.out.println("请选择： 1.精确查找（按姓名查找）   2.模糊查找");
		int choice = sc.nextInt();
		if (choice == 2) {
			vagueSearch();
		}
		System.out.println("请输入要修改的姓名：");
		String name = sc.next();
		int index = findByName(name);
		if (index == -1)
			System.out.println("没有找到相关信息。");
		else {
			System.out.println(books.get(index));
			System.out.println("请重新输入信息：");
			System.out.println("姓名：");
			String newname = sc.next();
			System.out.println("性别：");
			String sex = sc.next();
			System.out.println("年龄：");
			int age = sc.nextInt();
			System.out.println("电话：");
			String tel = sc.next();
			System.out.println("QQ：");
			String QQ = sc.next();
			System.out.println("地址：");
			String addr = sc.next();
			// 更改指定位置的元素
			PhoneBook newitem = new PhoneBook(newname, sex, addr, tel, QQ, age);
			String s = transformHistory("修改", books.get(index), newitem);
			appendNewtoFile(f1, s);
			books.set(index, newitem);	
		}
		System.out.println("修改成功，" + books.get(index));
		writeAlltoList(f);
	}

	//为删除操作添加了模糊查找
	private static void delete() {
		readAlltoList(f);
		System.out.println("----------------- 删除电话本 ----------------");
		System.out.println("请选择： 1.精确查找（按姓名查找）   2.模糊查找");
		int choice = sc.nextInt();
		if (choice == 2) {
			vagueSearch();
		}
		System.out.println("请输入要删除的姓名：");
		String name = sc.next();
		int index = findByName(name);
		if (index == -1) {
			System.out.println("没有找到相关信息。");
			return;
		} else {
			System.out.println(books.get(index));
			System.out.println("您确认要删除吗？ 1是0否");
			int result = sc.nextInt();
			if (result == 1) {
				books.remove(index);
				String s = transformHistory("删除", books.get(index), null);
				appendNewtoFile(f1, s);
			}
		}
		readAlltoList(f);
	}
	
	//添加
	private static void add() {
		System.out.println("------------ 增加电话本 -----------");
		System.out.println("姓名：");
		String name = sc.next();
		System.out.println("性别：");
		String sex = sc.next();
		System.out.println("年龄：");
		int age = sc.nextInt();
		System.out.println("电话：");
		String tel = sc.next();
		System.out.println("QQ：");
		String QQ = sc.next();
		System.out.println("地址：");
		String addr = sc.next();
		// 组合对象
		PhoneBook book = new PhoneBook(name, sex, tel, QQ, addr, age);
		System.out.println("添加成功！" + book);
		String s = name + " " + sex + " " + tel + " " + QQ + " " + addr + " " + age;
		String s1 = transformHistory("增加", book, null);
		appendNewtoFile(f,s);
		appendNewtoFile(f1, s1);
	}

	// 业务辅助方法，按姓名找下标
	public static int findByName(String name) {
		int index = -1;
		for (int i = 0; i <= books.size(); i++) {
			if (name.equals(books.get(i).getName())) {
				index = i;
				break;
			}
		}
		return index;
	}
	
	//将修改信息转化为一条操作记录，便于向文件写入
	private static String transformHistory(String operation, PhoneBook from, PhoneBook to){
		String message;
		Date lastModifiedTime = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日,HH:mm:ss");
		if(operation.equals("修改")){
			message = "操作类型:" + operation + "\t" + "修改时间:" +sdf.format(lastModifiedTime)+ "\n" 
			+ "原联系人信息：" + from + "\n" + "新联系人信息：" + to + "\n";
		}else{
				message = "操作类型:" + operation + "\t" + "修改时间:" +sdf.format(lastModifiedTime)+ "\n" + "联系人信息：" + from + "\n";
		}
		return message;
	}
		
	//将从文件中读出的信息转为PhoneBook对象存入集合
	private static void putinList(String s) {
		// 1拆字符串
		String[] bkStr = s.split(" ");
		// 2取出输入数据组合对象name, sex, addr, tel, QQ, age
		String name = bkStr[0];
		String sex = bkStr[1];
		String addr = bkStr[2];
		String tel = bkStr[3];
		String QQ = bkStr[4];
		int age = Integer.parseInt(bkStr[5]);
		PhoneBook b = new PhoneBook(name, sex, tel, QQ, addr, age);
		// 3存入集合
		books.add(b);
	}
	
	
	// 使用正则表达式实现模糊查询
	// regex = ".*?关键字.*?"
	private static void vagueSearch() {
		System.out.println("请输入部分关键字(关于该联系人的所有信息均可)：");
		String piece = sc.next();
		String regex = "^.*?" + piece + ".*?$";
		for (PhoneBook b : books) {
			String s = ""+b.getAge();
			//六项信息中有一项匹配即可
			if (s.matches(regex) || b.getName().matches(regex) || b.getAddr().matches(regex)
				|| b.getTel().matches(regex) || b.getSex().matches(regex) || b.getQQ().matches(regex))
				System.out.println(b);
		}
	}
	
	
	/**
	 * 向末尾增加（append）
	 * 创建一个可以往文件中写入字符数据的字符流输出流对象 
	 * 如果文件不存在，会自动创建。
	 * 当路径错误时会抛异常
	 * 当在创建时加入true参数，实现对文件的续写。
	 */
	private static void appendNewtoFile(File f,String s){
		FileWriter fw = null;
		try {
			fw = new FileWriter(f, true);
			PrintWriter pw = new PrintWriter(fw);
			// 写入文件信息
			pw.println(s);
			// 关闭流
			pw.close();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (fw != null) {
				try {
					fw.close();
				} catch (IOException e) {
					throw new RuntimeException("电话本关闭失败！");
				}
			}
		}
	}
	
	//获取所有的操作记录
	private static void readAllfromHistory(File f) {
	try {
		// 1创建字符输入流-与文件建立关联
		FileReader fr = new FileReader(f);
		// 2根据字符输入流创建字符过滤流
		BufferedReader br = new BufferedReader(fr);
		// 3读文件
		while (true) {
			String s = br.readLine();
			if (s == null) {
				break;
			} else {
				System.out.println(s);
			}
		}
		// 4关闭流
		br.close();
	} catch (Exception e) {
		e.printStackTrace();
	}
}
	//从文件中读取所有信息并添加到ArrayList中
	private static void readAlltoList(File f) {
		books.clear();
		try {
			// 1创建字符输入流-与文件建立关联
			FileReader fr = new FileReader(f);
			// 2根据字符输入流创建字符过滤流
			BufferedReader br = new BufferedReader(fr);
			// 3读文件
			while (true) {
				String s = br.readLine();
				if (s == null) {
					break;
				} else {
					putinList(s);
				}
			}
			// 4关闭流
			br.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	//将books中所有信息写入文件中
	private static void writeAlltoList(File f){
		FileWriter fw = null;
		try {
			fw = new FileWriter(f);
			PrintWriter pw = new PrintWriter(fw);
			// 写入文件信息
			for(PhoneBook b: books){
				String s = b.getName() + " " + b.getSex() + " " + b.getAddr() + " " + b.getTel() + " " + b.getQQ() + " " + b.getAge();
				pw.println(s);
			}
			// 关闭流
			pw.close();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (fw != null) {
				try {
					fw.close();
				} catch (IOException e) {
					throw new RuntimeException("文件关闭失败！");
				}
			}
		}
	}
}
