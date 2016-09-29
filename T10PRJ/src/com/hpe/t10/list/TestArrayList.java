package com.hpe.t10.list;

import java.util.ArrayList;

import java.util.Iterator;

import com.hoe.t10.po.Student;

public class TestArrayList {	
	public static void main(String[] args) {
		//创造集合
		ArrayList list1 = new ArrayList();
		list1.add(1);
		list1.add("good");
		list1.add(3.14);
		
		int i = (int)list1.get(0);
		String s1 = (String)list1.get(1);
		//说明：通过原始构造方法创建的集合，允许存储任意类型的对象
		//当把对象添加到集合后，对象自动转成Object类型
		//那么，从集合中取数据时需要进行强制类型转化
		//jdk5后对集合增加了泛型处理，也就是指定集合的存储类型
		
		/************************************************/
		
		ArrayList<String> list2 = new ArrayList<String>();
		
		list2.add("qwer");
		String s2 = list2.get(0);
		
		/************************************************/
		
		ArrayList<Student> list3 = new ArrayList<Student>();
		//添加
		list3.add(new Student("素素",1));
		list3.add(new Student("梁素素",2));
		list3.add(new Student("素素蓝票",3));
		list3.add(new Student("素素儿纸",4));
		list3.add(new Student("hentai语",5));
		//获取其中一个元素
		Student stu1 = list3.get(2);
		System.out.println(stu1);
		//删除
		list3.remove(1);
		Student stu2 = list3.get(1);
		System.out.println(stu2);
		//遍历
		System.out.println(list3);
		//方法一：通过索引
		for(int k =  0; k < list3.size();k++){
			System.out.println(list3.get(k));
		}
		//方法二：使用迭代器（银行验钞机）
		Iterator<Student> it = list3.iterator();
		while(it.hasNext()){
			System.out.println(it.next());
		}
		//JDK5之后增加了遍历方法：增强版for循环，forEach循环 
		for(Student stu : list3){
			System.out.println(stu);
		}
	}
}
