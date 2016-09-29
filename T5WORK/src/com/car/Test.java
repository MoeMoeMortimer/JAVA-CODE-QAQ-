package com.car;

public class Test {
	public static void main(String[] args) {
		AutoMobile am = new AutoMobile(null, null, 0, 0);
		am.setBrand("lalala");
		am.setColor("blublu");
		am.setPrice(888888);
		am.setSpeed(300);
		System.out.println(am);
		am.drive();
		System.out.println(am instanceof AutoMobile);
		System.out.println(am instanceof vehicle);
	}
	
}
