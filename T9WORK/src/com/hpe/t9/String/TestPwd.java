package com.hpe.t9.String;

import java.util.Scanner;

public class TestPwd {
	public static void main(String[] args) {
		 Scanner sc = new Scanner(System.in);
		 StringBuffer pwdbf = new StringBuffer();
	     System.out.println("请输入密码：");
	     String pwd = sc.nextLine();
	     pwdbf.append(pwd);
	     pwdbf.insert(3, "pwd");//指定索引处插入字符串
	     pwdbf.append("123");
	     //反序
	     pwdbf = pwdbf.reverse();
	     //输出密码
	     System.out.println(pwdbf.toString());
	}
}
