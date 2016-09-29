package com.hpe.t5.testAbstract;

public class Automobile extends Car {

	@Override
	public void run() {
		System.out.println("Æû³µÆô¶¯£¡£¡");
	}

	@Override
	public void stop() {
		System.out.println("Æû³µÍ£Ö¹£¡£¡");
	}

	public static void main(String[] args) {
		Automobile am = new Automobile();
		am.run();
		am.stop();
	}
}

