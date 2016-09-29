package com.hpe.t9.String;

import java.util.Scanner;

public class StringFunction {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("name:");
		String name = sc.nextLine();
		// 1不能为空
		if (name.length() == 0) {
			System.out.println("用户名不能为空");
			return;
		} else {
			// 2去掉多余的空格
			name = name.trim();
			// 3不能超过16位
			if (name.length() > 16) {
				System.out.println(">16");
				return;
			}
			System.out.println("用户名:" + name);
		}
		System.out.println("email:");
		String email = sc.nextLine();
		if (email.length() == 0) {
			System.out.println("不能为空");
			return;
		} else {
			// 2去掉多余的空格
			email = email.trim();
			// 3不能超过16位
			if (email.length() < 5) {
				System.out.println("必须超过5个字符");
				return;
			} else if (email.indexOf('@') == -1) {
				System.out.println("必须包含@符号");
				return;
			} else if (email.indexOf('.') == -1) {
				System.out.println("必须包含.符号");
				return;
			} else if (email.indexOf('@') - email.indexOf('.') == 1 || email.indexOf('.') - email.indexOf('@') == 1) {
				System.out.println("点和@之间必须有字符");
				return;
			} else if (email.startsWith("@") || email.endsWith("@")) {
				System.out.println("不能以@符号开头和结尾");
				return;
			} else if (email.startsWith(".") || email.endsWith(".")) {
				System.out.println("不能以.符号开头和结尾");
				return;
			}
			System.out.println("邮箱:" + email);
		}
		sc.close();
	}
}
