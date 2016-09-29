package com.hpe.yhy.extend;

public class TestCar {
	public static void main(String[] args) {
		Car myCar = new Car();
		KaChe kc = new KaChe();
		myCar.run();
		kc.run();
		kc.laHuo();
		kc.setColor("»Æ");
		System.out.println(kc.getColor());
		System.out.println(myCar instanceof Car);
		System.out.println(kc instanceof Car);
		//System.out.println(Car instanceof myCar);
	}

}
