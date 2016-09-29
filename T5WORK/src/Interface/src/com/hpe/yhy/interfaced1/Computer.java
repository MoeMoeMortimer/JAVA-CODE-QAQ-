package com.hpe.yhy.interfaced1;

public class Computer {
	UPan  up;
	public void setUPan(UPan  up){
		System.out.println(up.getBrand()+"插入电脑！！！");
		this.up = up;
	}
	public void input(){
		System.out.println("电脑写入内容！！！");
	}
	public void output(){
		System.out.println("电脑读取内容！！");
	}
	

}
