package com.hpe.t9.String;
//string类型的不可变性，+连接操作会开辟新的空间
public class StringPerf {
	public static void main(String[] args) {
		String s1 = "hello";
		String temp1 = s1;
		s1 = s1+"";
		String temp2 = s1;
		System.out.println(temp1.equals(temp2));
		System.out.println(temp1 == temp2);
	}
}
