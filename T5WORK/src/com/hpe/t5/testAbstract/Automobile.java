package com.hpe.t5.testAbstract;

public class Automobile extends Car {

	@Override
	public void run() {
		System.out.println("������������");
	}

	@Override
	public void stop() {
		System.out.println("����ֹͣ����");
	}

	public static void main(String[] args) {
		Automobile am = new Automobile();
		am.run();
		am.stop();
	}
}

