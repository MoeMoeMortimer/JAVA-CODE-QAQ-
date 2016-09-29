package com.hpe.t5.testAbstract;

public class TestCar {
	public static void main(String[] args) {		
		/*
		 * 抽象类不能被实例化
		 */
		//Car myCar = new Car();
		/*
		 * 可以通过抽象类的派生类创建对象
		 */
		Automobile am = new Automobile();
		am.run();
		am.speedDown();
	}
}
