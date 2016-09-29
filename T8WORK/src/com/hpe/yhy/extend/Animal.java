package com.hpe.yhy.extend;

public class Animal {
	private String name;
	private String sex;
	private float age = 10;
	private float weight;

	/**
	 * 构造方法的作用：初始化对象 对象的初始化顺序：既是构造方法的执行顺序 属性初始化---->构造方法初始化
	 */
	public Animal() {
		// 子类创建时会隐式的调用父类的构造方法，
		// 如果显式声明需要写在构造方法内的第一行
		super();
		age = 20;
	}

	public Animal(String myColor, String mySex, int myAge, float myWeight) {
		this.name = myColor;
		this.sex = mySex;
		this.age = myAge;
		this.weight = myWeight;
	}

	/**
	 * get和set方法
	 */
	public String getName() {
		return name;
	}

	public void setName(String myName) {
		name = myName;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String mySex) {
		sex = mySex;
	}

	public float getAge() {
		return age;
	}

	public void setAge(float myAge) {
		if (myAge > 50) {
			System.out.println("您输出的信息有误，请重新输入！！！");
		} else {
			age = myAge;
		}

	}

	public float getWeight() {
		return weight;
	}

	public void setWeight(float myWeight) {
		weight = myWeight;
	}

	/**
	 * 类方法
	 */
	public void eat() {
		System.out.println("动物都会吃！！！");
	}

	public void run() {
		System.out.println("动物都会跑！！！");
	}

	@Override
	public String toString() {
		return "Animal [name=" + name + ", sex=" + sex + ", age=" + age + ", weight=" + weight + "]";
	}
}
