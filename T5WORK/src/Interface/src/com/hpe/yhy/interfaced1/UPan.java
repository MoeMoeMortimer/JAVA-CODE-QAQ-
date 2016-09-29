package com.hpe.yhy.interfaced1;

public class UPan implements Usb {
	private String brand;
	private int size;

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}

	@Override
	public void input() {
		// TODO Auto-generated method stub

	}

	@Override
	public void output() {
		// TODO Auto-generated method stub

	}

}
