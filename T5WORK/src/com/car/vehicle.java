package com.car;

public abstract class vehicle {
	private String brand;
	private String color;
	private double price;
	private double speed;
	public abstract void drive();
	@Override
	
	public String toString(){
		return "´óÆû³µ"+"[brand = "+brand+",color="+color+",price="+price+",speed="+speed+"]";
	}
	public String getBrand() {
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
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public double getSpeed() {
		return speed;
	}
	public void setSpeed(double speed) {
		this.speed = speed;
	}
	public vehicle(String brand, String color, double price, double speed) {
		super();
		this.brand = brand;
		this.color = color;
		this.price = price;
		this.speed = speed;
	}
	
	
}
