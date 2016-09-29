package com.hpe.yhy.interfaced1;

/*
 * 电脑上设置USB接口
 * 可以做到随时更换
 */
public class TestComputer1 {
	public static void main(String[] args) {
		Computer1 c1 = new Computer1();
		UPan upan = new UPan();
		upan.setBrand("kingsdon");
		MobilePhone m = new MobilePhone();
		c1.setUsb(upan);
		c1.setUsb(m);
	}

}
