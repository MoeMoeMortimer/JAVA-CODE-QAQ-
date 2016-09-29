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
	 * ��������д������ֵ���͡��������������б�
	 * ������д����ķ���
	 * 1�����Ϸ�����д����
	 * 2�����෽���Ḳ�Ǹ��෽��
	 */
	public void eat(){
		System.out.println("�����й�ͷ������");
	}
	
	/**
	 * super�ؼ��֣����������
	 * super.����
	 * super.����
	 */
	public void TestSuper(){
		System.out.println(super.getAge());
		super.eat();
		eat();
	}

}
