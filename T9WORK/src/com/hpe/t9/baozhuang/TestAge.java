package com.hpe.t9.baozhuang;

import java.util.Scanner;

public class TestAge {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while(true){
			System.out.println("�����������ݣ�");
			String birth = sc.nextLine();
			String regex = "[1-9][0-9]{3}";
			if(!birth.matches(regex)){
				System.out.println("���Ϸ�������������");
				continue;
			}else{
				int age = 2016 - Integer.parseInt(birth);
				System.out.println(age);
			}
		}
	}
}
