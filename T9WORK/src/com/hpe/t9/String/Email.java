package com.hpe.t9.String;

import java.util.Scanner;

public class Email {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while(true){
			System.out.println("���������䣺");
			String email = sc.nextLine();
			if(email.length() == 0){
				System.out.println("����Ϊ��");
				continue;
			}else{
				//2ȥ������Ŀո�
				email = email.trim();
				//3���ܳ���16λ
				if(email.length() < 5){
					System.out.println("���볬��5���ַ�");
					continue;
				}else if(email.indexOf('@') == -1){
					System.out.println("�������@����");
					continue;
				}else if(email.indexOf('.') == -1){
					System.out.println("�������.����");
					continue;
				}else if(email.indexOf('@') -email.indexOf('.') ==1 || email.indexOf('.') -email.indexOf('@') ==1){
					System.out.println("���@֮��������ַ�");
					continue;
				}else if(email.startsWith("@") || email.endsWith("@")){
					System.out.println("������@���ſ�ͷ�ͽ�β");
					continue;
				}else if(email.startsWith(".") || email.endsWith(".")){
					System.out.println("������.���ſ�ͷ�ͽ�β");
					continue;
				}
				System.out.println("�û���"+email);	
			}
		}
	}
	
}
