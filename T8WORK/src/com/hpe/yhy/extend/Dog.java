package com.hpe.yhy.extend;

public class Dog extends Animal{
	private float age = 30;
	
	public Dog(){
		super();
	}
	
	/**
	 * @param myColor
	 * @param mySex
	 * @param myAge
	 * @param myWeight
	 * @param age
	 */
	public Dog(String myColor, String mySex, int myAge, float myWeight, int age) {
		super(myColor, mySex, myAge, myWeight);
		this.age = age;
	}

	/**
	 * 方法的重写：返回值类型、方法名、参数列表
	 * 子类重写父类的方法
	 * 1、符合方法重写规则
	 * 2、子类方法会覆盖父类方法
	 */
	public void eat(){
		System.out.println("狗爱啃骨头！！！");
	}
	
	/**
	 * super关键字，代表父类对象
	 * super.属性
	 * super.方法
	 */
	public void TestSuper(){
		System.out.println(super.getAge());
		super.eat();
		eat();
	}

}
