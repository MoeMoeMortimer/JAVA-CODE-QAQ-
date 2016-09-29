package com.hpe.t10.Student;

import java.util.ArrayList;
import java.util.Scanner;

public class StudentManager {
	static ArrayList<Student> slist = new ArrayList<Student>();
	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		while (true) {
			Menu();
			String select = sc.next();
			String regex = "[1-6]";
			if (!select.matches(regex)) {
				System.out.println("请在1-6间选择一个数字。");
				continue;
			}
			switch (select) {
			case "1":
				add();
				break;
			case "2":
				delete();
				break;
			case "3":
				update();
				break;
			case "4":
				find();
				break;
			case "5":
				findAll();
				break;
			case "6":
				System.exit(0);
			}
		}
	}

	private static void Menu() {
		System.out.println("----------- 学生管理系统 -----------");
		System.out.println("1增加  2删除  3修改  4查找  5查找所有  6退出");
		System.out.println("请选择业务：");
	}

	private static void findAll() {
		System.out.println("---------- 所有学生信息 ----------");
		for (Student stu : slist) {
			System.out.println(stu);
		}
	}

	private static void find() {
		System.out.println("---------------- 查找学生信息 --------------");
		System.out.println("请选择：1.精确查找(按学号查找)     2.模糊查找");
		int choice = sc.nextInt();
		if (choice == 2) {
			vagueSearch();
		} else {
			System.out.println("请输入要查找的学号：");
			int sid = sc.nextInt();
			int index = findIndexBySid(sid);
			if (index == -1)
				System.out.println("没有找到相关信息。");
			else
				System.out.println(slist.get(index));
		}
	}

	private static void delete() {
		// 删除指定索引
		System.out.println("---------------- 删除学生信息 ---------------");
		while (true) {
			System.out.println("请选择：1.精确查找(按学号查找)     2.模糊查找");
			int choice = sc.nextInt();
			if (choice == 2) {
				vagueSearch();
			}
			System.out.println("请输入要删除的学号：");
			String ssid = sc.next();
			String regex = "^[0-9]{8}$";
			if (!ssid.matches(regex)) {
				System.out.println("学号必须为数字！");
				continue;
			}
			int sid = Integer.parseInt(ssid);
			// 找该sid在集合中的位置
			int index = findIndexBySid(sid);
			if (index == -1) {
				System.out.println("没有该学生信息");
				break;
			} else {
				// 如果有，打印信息
				System.out.println(slist.get(index));
				System.out.println("确定要删除么？ 1是  0否");
				int answer = sc.nextInt();
				if (answer == 1) {
					slist.remove(index);
					System.out.println("删除成功！");
				}
				break;
			}
		}
	}

	private static void update() {
		// 修改指定索引处信息
		System.out.println("------------- 修改学生信息 ------------");
		System.out.println("请选择：1.精确查找(按学号查找)   2.模糊查找");
		int choice = sc.nextInt();
		if (choice == 2) {
			vagueSearch();
		}
		System.out.println("请输入要修改的学号：");
		int sid = sc.nextInt();
		int index = findIndexBySid(sid);
		if (index == -1)
			System.out.println("没有找到相关信息。");
		else {
			System.out.println(slist.get(index));
			System.out.println("请输入新信息：");
			System.out.println("姓名：");
			String newname = sc.next();
			System.out.println("学号：");
			int id = sc.nextInt();
			// 更改指定位置的元素
			Student newitem = new Student(newname, id);
			slist.set(index, newitem);
		}
		System.out.println("修改成功，" + slist.get(index));

	}

	private static void add() {
		System.out.println("------------增加------------");
		// 学号处理： 1.输入，需要判断有没有重复值； 2.自动生成
		int sid = createSid();
		// 吃回车
		String lf = sc.nextLine();
		while (true) {
			System.out.println("请输入学生姓名(需为中文)：");
			String name = sc.nextLine();
			if (name.length() == 0) {
				System.out.println("姓名不能为空！");
				continue;
			}
			String regex2 = "^[\u4e00-\u9fa5]+$";
			if (!name.matches(regex2)) {
				System.out.println("中文名字不能包含英文字母或数字，请您重新输入。");
				continue;
			} else {
				// 组合对象
				Student stu = new Student(name, sid);
				// 添加到集合
				slist.add(stu);
				System.out.println("添加成功！");
				System.out.println(stu);
				break;
			}
		}
	}

	// 自动生成学号
	private static int createSid() {
		int ptr = slist.size();
		if (ptr == 0) {
			return 15002000;
		} else {
			int lastsid = slist.get(ptr - 1).getSid();
			return ++lastsid;
		}
	}

	// 根据学号查找索引
	private static int findIndexBySid(int sid) {
		int index = -1;
		for (int i = 0; i < slist.size(); i++) {
			if (sid == slist.get(i).getSid()) {
				index = i;
				break;
			}
		}
		return index;
	}

	// 使用正则表达式实现模糊查询
	// regex = ".*?关键字.*?"
	private static void vagueSearch() {
		System.out.println("请输入部分关键字：");
		String piece = sc.next();
		String regex = "^.*?" + piece + ".*?$";
		for (Student stu : slist) {
			String s = "" + stu.getSid();
			if (s.matches(regex) || stu.getName().matches(regex))
				System.out.println(stu);
		}
	}
}
