package com.hpe.t9.String;

import java.util.Scanner;

public class TestPwd {
	public static void main(String[] args) {
		 Scanner sc = new Scanner(System.in);
		 StringBuffer pwdbf = new StringBuffer();
	     System.out.println("���������룺");
	     String pwd = sc.nextLine();
	     pwdbf.append(pwd);
	     pwdbf.insert(3, "pwd");//ָ�������������ַ���
	     pwdbf.append("123");
	     //����
	     pwdbf = pwdbf.reverse();
	     //�������
	     System.out.println(pwdbf.toString());
	}
}
