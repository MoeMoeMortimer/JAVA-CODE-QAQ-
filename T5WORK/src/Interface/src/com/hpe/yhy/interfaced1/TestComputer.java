package com.hpe.yhy.interfaced1;

public class TestComputer {
	public static void main(String[] args) {
		Computer c = new Computer();
		UPan myUpan = new UPan();
		myUpan.setBrand("kingsdon");
		c.setUPan(myUpan);
	}

}
