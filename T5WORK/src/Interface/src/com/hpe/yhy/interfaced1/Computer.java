package com.hpe.yhy.interfaced1;

public class Computer {
	UPan  up;
	public void setUPan(UPan  up){
		System.out.println(up.getBrand()+"������ԣ�����");
		this.up = up;
	}
	public void input(){
		System.out.println("����д�����ݣ�����");
	}
	public void output(){
		System.out.println("���Զ�ȡ���ݣ���");
	}
	

}
