package com.hpe.t12.file;

public class Student {
	private int sid;
	private String name;
	private String sex;
	private int age;
	public Student(int sid, String name, String sex, int age) {
		super();
		this.sid = sid;
		this.name = name;
		this.sex = sex;
		this.age = age;
	}
	public int getSid() {
		return sid;
	}
	public void setSid(int sid) {
		this.sid = sid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	@Override
	public String toString() {
		return "Student [sid=" + sid + ", name=" + name + ", sex=" + sex + ", age=" + age + "]";
	}
	
}
