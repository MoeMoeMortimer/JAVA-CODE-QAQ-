package com.hpe.t9.String;

public class Student {
	int sid;
	String name;
	public Student(int sid, String name) {
		super();
		this.sid = sid;
		this.name = name;
	}
	@Override
	public boolean equals(Object obj) {
		//1先判断是不是this
		if(this == obj){
			return true;
		}
		//2判断是不是null
		if(obj == null){
			return false;
		}
		//3判断是不是同一类型
		if(obj instanceof Student){
			//4强制类型转换
			Student stu2 = (Student)obj;
			//5逐个数据进行比较
			if(this.getSid() == stu2.getSid() && this.getName().equals(stu2.getName()))
				return true;
			else
				return false;
		}else{
			return false;
		}
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
	@Override
	public String toString() {
		return "student [sid=" + sid + ", name=" + name + "]";
	}
	
}
