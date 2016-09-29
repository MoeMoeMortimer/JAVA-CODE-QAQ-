package com.hoe.t10.po;

public class Student {
	private String name; // 姓名
	private int sid; // 学号

	public String getName() {
		return name;
	}

	public Student() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Student(String name, int sid) {
		super();
		this.name = name;
		this.sid = sid;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getSid() {
		return sid;
	}

	public void setSid(int sid) {
		this.sid = sid;
	}

	@Override
	public String toString() {
		return "Student [name=" + name + ", sid=" + sid + "]";
	}

	// 重写hashcode
	@Override
	public int hashCode() {
		// TODO Auto-generated method stub
		return sid + name.hashCode();
	}

	// 重写equals
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (obj instanceof Student) {
			Student stu2 = (Student) obj;
			if (this.getName() == stu2.getName() && this.getSid() == stu2.getSid()) {
				return true;
			} else {
				return false;
			}
		} else {
			return false;
		}
	}

}
