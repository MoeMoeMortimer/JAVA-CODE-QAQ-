package com.hpe.t5.testAbstract;

public abstract class Car {
	private String brand;
	private String color;
	private float price;
	
	public Car() {
		super();
	}
	
	public String getBrand() {
		//abstract int i = 10;//�������ξֲ�����
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	
	/*
	 * ��ȷ��ĳ�������ľ���ʵ��ϸ�ڣ�
	 * ����������Ϊabstract���ͣ�
	 * ����ҲҪ���abstract����
	 */
    public abstract void run();
	public abstract void stop();
	public void speedDown(){
		
	}
	/*
	 * abstract���ܺ�static����
	 * ��Ϊ��static �Ǿ�̬�ģ��������෽��
	 *     ��̬����������ص�ʱ��ͻᱻִ��
	 * The abstract method speekUp in type Car can only 
	 * set a visibility modifier, one of public or protected
	 */
	//public abstract static void speekUp();
	
	/*
	 * abstract���ܺ�private����
	 * ��Ϊ��static �Ǿ�̬�ģ��������෽��
	 *     ��̬����������ص�ʱ��ͻᱻִ��
	 * The abstract method speekUp in type Car can only 
	 * set a visibility modifier, one of public or protected
	 */
	//private abstract  void speekUp();

}

