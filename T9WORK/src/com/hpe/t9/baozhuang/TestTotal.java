package com.hpe.t9.baozhuang;

import java.util.Scanner;

public class TestTotal {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		double p;
		while (true) {
			System.out.println("���뵥�ۣ�");
			String price = sc.nextLine();
			String regex1 = "[0-9]*[\\.]?[0-9]*";
			if (!price.matches(regex1)) {
				System.out.println("�����������������뵥�ۣ�");
				continue;
			} else {
				p = Double.parseDouble(price);
				System.out.println(p);
				break;
			}
		}
		while (true) {
			System.out.println("����������");
			String num = sc.nextLine();
			String regex2 = "[0-9]+";
			if (!num.matches(regex2)) {
				System.out.println("������������������������");
				continue;
			} else {
				int n = Integer.parseInt(num);
				System.out.println(n * p);
				break;
			}
		}
		sc.close();
	}
}
