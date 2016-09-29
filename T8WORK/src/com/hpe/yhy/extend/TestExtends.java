package com.hpe.yhy.extend;

public class TestExtends {
	
	public static void main(String[] args) {
		Animal ani = new Animal();
		Dog myDog = new Dog();
		myDog.setName("阿黄");
		//myDog.setAge(5);
		System.out.println(myDog.toString());//测试子类继承了父类的属性
		myDog.eat();//测试子类继承父类的方法、方法的重载
		System.out.println(ani instanceof Dog);//测试instanceof
		System.out.println(myDog instanceof Dog);
		System.out.println(myDog instanceof Animal);
		myDog.TestSuper();//测试super关键字
	}

}
