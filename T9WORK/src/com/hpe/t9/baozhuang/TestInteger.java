package com.hpe.t9.baozhuang;

import java.util.Scanner;

public class TestInteger {
	public static void main(String[] args) {
		while(true){
			Scanner sc = new Scanner(System.in);
			System.out.println("���������䣺");
			String sage = sc.nextLine();
			String regex = "[0-9]{1,3}";
			if(!sage.matches(regex)){
				System.out.println("���Ϸ�������������");
				continue;
			}else{
				int age = Integer.parseInt(sage);
				System.out.println(age);
			}
		}
	}
}
