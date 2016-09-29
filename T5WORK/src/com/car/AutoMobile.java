package com.car;

public class AutoMobile extends vehicle{
	public AutoMobile(String brand, String color, double price, double speed) {
		super(brand, color, price, speed);
		// TODO Auto-generated constructor stub
	}

	public void drive(){
		System.out.println("我可以无银驾驶！");
	}
	
}
