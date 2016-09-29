package com.hpe.t5.testAbstract;

public abstract class Car {
	private String brand;
	private String color;
	private float price;
	
	public Car() {
		super();
	}
	
	public String getBrand() {
		//abstract int i = 10;//不能修饰局部变量
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
	 * 不确定某个方法的具体实现细节，
	 * 将方法设置为abstract类型，
	 * 则类也要设成abstract类型
	 */
    public abstract void run();
	public abstract void stop();
	public void speedDown(){
		
	}
	/*
	 * abstract不能和static连用
	 * 因为：static 是静态的，是属于类方法
	 *     静态变量在类加载的时候就会被执行
	 * The abstract method speekUp in type Car can only 
	 * set a visibility modifier, one of public or protected
	 */
	//public abstract static void speekUp();
	
	/*
	 * abstract不能和private连用
	 * 因为：static 是静态的，是属于类方法
	 *     静态变量在类加载的时候就会被执行
	 * The abstract method speekUp in type Car can only 
	 * set a visibility modifier, one of public or protected
	 */
	//private abstract  void speekUp();

}

