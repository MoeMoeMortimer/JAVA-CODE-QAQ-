package com.hpe.t9.String;

public class TestStudent {
	public static void main(String[] args) {
		Student stu1 = new Student(1,"abc");
		Student stu2 = new Student(1,"abc");
		System.out.println(stu1 == stu2);
		System.out.println(stu1.equals(stu2));	//只能比较地址，如果要比较自定义的类，要重写equals方法
	}
}
