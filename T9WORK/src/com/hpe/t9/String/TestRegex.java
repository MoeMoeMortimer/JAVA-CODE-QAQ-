package com.hpe.t9.String;

import java.util.Scanner;

public class TestRegex {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while (true) {
			System.out.println("���������룺");
			String password = sc.nextLine();
			if (password.length() == 0) {
				System.out.println("���벻��Ϊ�գ�");
				continue;
			}
			String regex1 = "^[0-9]{6}$";
			if (password.matches(regex1)) {
				System.out.println("�����ʽ��ȷ");
				System.out.println(password);
				break;
			} else {
				System.out.println("������Ϊ6λ����");
				continue;
			}
		}
		while (true) {
			System.out.println("���������֤�ţ�");
			String id = sc.nextLine();
			if (id.length() == 0) {
				System.out.println("���֤�Ų���Ϊ�գ�");
				continue;
			}
			String regex2 = "^[0-9]{17}[0-9]|x$";
			if (id.matches(regex2)) {
				System.out.println("���֤�Ÿ�ʽ��ȷ");
				System.out.println(id);
				break;
			} else {
				System.out.println("wrong");
				continue;
			}
		}
		sc.close();
	}
}
