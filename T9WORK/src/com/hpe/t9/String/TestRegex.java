package com.hpe.t9.String;

import java.util.Scanner;

public class TestRegex {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while (true) {
			System.out.println("请输入密码：");
			String password = sc.nextLine();
			if (password.length() == 0) {
				System.out.println("密码不能为空！");
				continue;
			}
			String regex1 = "^[0-9]{6}$";
			if (password.matches(regex1)) {
				System.out.println("密码格式正确");
				System.out.println(password);
				break;
			} else {
				System.out.println("密码须为6位数字");
				continue;
			}
		}
		while (true) {
			System.out.println("请输入身份证号：");
			String id = sc.nextLine();
			if (id.length() == 0) {
				System.out.println("身份证号不能为空！");
				continue;
			}
			String regex2 = "^[0-9]{17}[0-9]|x$";
			if (id.matches(regex2)) {
				System.out.println("身份证号格式正确");
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
