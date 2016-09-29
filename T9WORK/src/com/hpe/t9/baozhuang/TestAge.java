package com.hpe.t9.baozhuang;

import java.util.Scanner;

public class TestAge {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while(true){
			System.out.println("请输入出生年份：");
			String birth = sc.nextLine();
			String regex = "[1-9][0-9]{3}";
			if(!birth.matches(regex)){
				System.out.println("不合法，请重新输入");
				continue;
			}else{
				int age = 2016 - Integer.parseInt(birth);
				System.out.println(age);
			}
		}
	}
}
