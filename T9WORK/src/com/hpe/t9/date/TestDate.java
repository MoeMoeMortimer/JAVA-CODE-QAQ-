package com.hpe.t9.date;

import java.util.Date;
import java.util.Scanner;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class TestDate {
	public static void main(String[] args) {
		// java.util.Date ����utilʱ����
		Date now = new Date();
		System.out.println(now);
		// java.sql.Date ����sql������
		// now.getTime() ��ȡ1970.1.1�����ڵĺ�����
		java.sql.Date now2 = new java.sql.Date(now.getTime());
		System.out.println(now2);
		// java.sql.Timestamp ����������ʱ���루���룩
		Timestamp now3 = new Timestamp(now.getTime());
		System.out.println(now3);
		System.out.println("����������ڣ�");
		Scanner sc = new Scanner(System.in);
		String birth = sc.nextLine();
		java.sql.Date dbirth = java.sql.Date.valueOf(birth);
		System.out.println(dbirth);
		
		System.out.println("����������,yyyy-MM-dd");
		String vdate = sc.nextLine();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		try {
			// ���ַ�������ת��Date����
			Date date = sdf.parse(vdate);
			System.out.println(date);
			// ������ת�ɣ�yyyy��MM��dd�գ�
			sdf = new SimpleDateFormat("yyyy��MM��dd��");
			String mydate = sdf.format(date);
			System.out.println(mydate);

		} catch (ParseException e) {
			e.printStackTrace();
		}
	}
}
