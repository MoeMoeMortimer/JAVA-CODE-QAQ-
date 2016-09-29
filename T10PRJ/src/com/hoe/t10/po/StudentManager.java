package com.hoe.t10.po;

import java.util.ArrayList;
import java.util.Scanner;

public class StudentManager {
	static ArrayList<Student> slist = new ArrayList<Student>();
	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		while(true){
			System.out.println("1.增加   2.删除  3.修改   4.查找    5.查找所有   6.退出");
			System.out.println("请选择业务：");
			String select = sc.next();
			String regex = "[1-6]";
			if(!select.matches(regex)){
				System.out.println("请在1-6间选择一个数字。");
				continue;
			}
			switch(select){
			case "1":add();break;
			case "2":delete();break;
			case "3":update();break;
			case "4":find();break;
			case "5":findAll();break;
			case "6":System.exit(0);
			}
		}
	}

	private static void findAll() {
		System.out.println("----------所有学生信息----------");
		for(Student stu : slist){
			System.out.println(stu);
		}
		
	}

	private static void find() {
		// TODO Auto-generated method stub
		
	}

	private static void update() {
		// TODO Auto-generated method stub
		System.out.println("--------------删除-------------");
		while(true){
			System.out.println("请输入要删除的学号：");
			String ssid = sc.next();
			String regex = "^[0-9]{8}$";
			if(!ssid.matches(regex)){
				System.out.println("学号必须为数字！");
				continue;
			}
			int sid = Integer.parseInt(ssid);
			//找该sid在集合中的位置
			int index = findIndexBySid(sid);
			if(index == -1){
				System.out.println("没有该学生信息");
				break;
			}else{
				//如果有，打印信息
				System.out.println(slist.get(index));
				System.out.println("确定要删除么？ 1是  0否");
				int answer = sc.nextInt();
				slist.remove(index);
				System.out.println("删除成功！");
				break;
			}
		}
	}

	private static int findIndexBySid(int sid) {
		int index = -1;
		for(int i = 0;  i < slist.size(); i++){
			if(sid == slist.get(i).getSid()){
				index = i;
				break;
			}
		}
		return index;
	}

	private static void delete() {
		// 删除指定索引
		
	}
	
	private static void add() {
		System.out.println("------------增加------------");
		//学号处理： 1.输入，需要判断有没有重复值；   2.自动生成
		int sid = createSid();
		System.out.println("姓名：");
		String name = sc.next();
		//组合对象
		Student stu = new Student(name, sid);
		//添加到集合
		slist.add(stu);
		System.out.println("添加成功！");
	}

	private static int createSid() {
		// TODO Auto-generated method stub
		return 0;
	}
}
