package com.hpe.yhy.extend;

public class TestExtends {
	
	public static void main(String[] args) {
		Animal ani = new Animal();
		Dog myDog = new Dog();
		myDog.setName("����");
		//myDog.setAge(5);
		System.out.println(myDog.toString());//��������̳��˸��������
		myDog.eat();//��������̳и���ķ���������������
		System.out.println(ani instanceof Dog);//����instanceof
		System.out.println(myDog instanceof Dog);
		System.out.println(myDog instanceof Animal);
		myDog.TestSuper();//����super�ؼ���
	}

}
