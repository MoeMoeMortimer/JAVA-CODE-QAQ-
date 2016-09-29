package com.hpe.t9.baozhuang;

import java.util.Scanner;

public class TestInteger {
	public static void main(String[] args) {
		while(true){
			Scanner sc = new Scanner(System.in);
			System.out.println("请输入年龄：");
			String sage = sc.nextLine();
			String regex = "[0-9]{1,3}";
			if(!sage.matches(regex)){
				System.out.println("不合法，请重新输入");
				continue;
			}else{
				int age = Integer.parseInt(sage);
				System.out.println(age);
			}
		}
	}
}
