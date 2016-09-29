package com.hpe.t9.Calendar;

import java.util.Calendar;
import java.util.Scanner;

public class ShowCalendar {
	// ��������ÿ������
	public static int[] notleapday = { 0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
	// ����ÿ������
	public static int[] leapday = { 0, 31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		Calendar now = Calendar.getInstance();
		System.out.println("��������ݣ�");
		int year = sc.nextInt();
		System.out.println("�������·ݣ�");
		int month = sc.nextInt();
		now.set(year, month - 1, 1); // �������������¸�ֵ��ָ�����µĵ�һ��
		int week = (now.get(Calendar.DAY_OF_WEEK) - 1);
		System.out.println("���ڣ�" + (now.get(Calendar.DAY_OF_WEEK) - 1));
		int[] mycalendar = new int[42];
		// ����ÿ�µ�����
		java.util.GregorianCalendar c = new java.util.GregorianCalendar();
		if (c.isLeapYear(year)) {
			for (int i = 0; i < 42; i++) {
				mycalendar[week++] = 1 + i;
				if (i == leapday[month] - 1) {
					break;
				}
			}
		} else {
			for (int i = 0; i < 42; i++) {
				mycalendar[week++] = 1 + i;
				if (i == notleapday[month] - 1) {
					break;
				}
			}
		}

		// ��ӡ������ÿ�߸����У�
		System.out.println("��\tһ\t��\t��\t��\t��\t��");
		for (int i = 0; i < 42; i++) {
			if (mycalendar[i] == 0)
				System.out.print(" \t");
			else
				System.out.print(mycalendar[i] + "\t");
			if ((i + 1) % 7 == 0)
				System.out.println();
		}
	}
}
