package com.hpe.t10.PhoneBook;

public class PhoneBook {
	//1.私有属性
	private String name, sex, tel, QQ, addr;
	private int age;
	//2.构造方法
	public PhoneBook(String name, String sex, String tel, String QQ, String addr, int age) {
		super();
		this.name = name;
		this.sex = sex;
		this.tel = tel;
		this.QQ = QQ;
		this.addr = addr;
		this.age = age;
	}
	//3.getset方法
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
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public String getQQ() {
		return QQ;
	}
	public void setQQ(String qQ) {
		QQ = qQ;
	}
	public String getAddr() {
		return addr;
	}
	public void setAddr(String addr) {
		this.addr = addr;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	@Override
	public String toString() {
		return "PhoneBook [name=" + name + ", sex=" + sex + ", tel=" + tel + ", QQ=" + QQ + ", addr=" + addr + ", age="
				+ age + "]";
	}
		
}
