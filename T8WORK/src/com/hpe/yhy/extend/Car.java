package com.hpe.yhy.extend;

public class Car {
	private String color;
	private String band;
	private float price;
	private int weight;

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public String getBand() {
		return band;
	}

	public void setBand(String band) {
		this.band = band;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public int getWeight() {
		return weight;
	}

	public void setWeight(int weight) {
		this.weight = weight;
	}

	public void run(){
		System.out.println("汽车都会跑！！！");
	}
	
	public void stop(){
		System.out.println("靠边停车！！");
	}

}
