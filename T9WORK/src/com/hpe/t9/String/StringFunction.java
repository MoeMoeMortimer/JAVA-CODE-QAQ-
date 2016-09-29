package com.hpe.t9.String;

import java.util.Scanner;

public class StringFunction {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("name:");
		String name = sc.nextLine();
		// 1����Ϊ��
		if (name.length() == 0) {
			System.out.println("�û�������Ϊ��");
			return;
		} else {
			// 2ȥ������Ŀո�
			name = name.trim();
			// 3���ܳ���16λ
			if (name.length() > 16) {
				System.out.println(">16");
				return;
			}
			System.out.println("�û���:" + name);
		}
		System.out.println("email:");
		String email = sc.nextLine();
		if (email.length() == 0) {
			System.out.println("����Ϊ��");
			return;
		} else {
			// 2ȥ������Ŀո�
			email = email.trim();
			// 3���ܳ���16λ
			if (email.length() < 5) {
				System.out.println("���볬��5���ַ�");
				return;
			} else if (email.indexOf('@') == -1) {
				System.out.println("�������@����");
				return;
			} else if (email.indexOf('.') == -1) {
				System.out.println("�������.����");
				return;
			} else if (email.indexOf('@') - email.indexOf('.') == 1 || email.indexOf('.') - email.indexOf('@') == 1) {
				System.out.println("���@֮��������ַ�");
				return;
			} else if (email.startsWith("@") || email.endsWith("@")) {
				System.out.println("������@���ſ�ͷ�ͽ�β");
				return;
			} else if (email.startsWith(".") || email.endsWith(".")) {
				System.out.println("������.���ſ�ͷ�ͽ�β");
				return;
			}
			System.out.println("����:" + email);
		}
		sc.close();
	}
}
