package com.hpe.t9.String;

import java.util.Scanner;

public class Email {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while(true){
			System.out.println("请输入邮箱：");
			String email = sc.nextLine();
			if(email.length() == 0){
				System.out.println("不能为空");
				continue;
			}else{
				//2去掉多余的空格
				email = email.trim();
				//3不能超过16位
				if(email.length() < 5){
					System.out.println("必须超过5个字符");
					continue;
				}else if(email.indexOf('@') == -1){
					System.out.println("必须包含@符号");
					continue;
				}else if(email.indexOf('.') == -1){
					System.out.println("必须包含.符号");
					continue;
				}else if(email.indexOf('@') -email.indexOf('.') ==1 || email.indexOf('.') -email.indexOf('@') ==1){
					System.out.println("点和@之间必须有字符");
					continue;
				}else if(email.startsWith("@") || email.endsWith("@")){
					System.out.println("不能以@符号开头和结尾");
					continue;
				}else if(email.startsWith(".") || email.endsWith(".")){
					System.out.println("不能以.符号开头和结尾");
					continue;
				}
				System.out.println("用户名"+email);	
			}
		}
	}
	
}

