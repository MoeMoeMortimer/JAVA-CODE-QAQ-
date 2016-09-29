package com.hpe.t9.Calendar;

import java.util.Calendar;
import java.util.Scanner;

public class ShowCalendar {
	// 非闰年中每月天数
	public static int[] notleapday = { 0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
	// 闰年每月天数
	public static int[] leapday = { 0, 31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		Calendar now = Calendar.getInstance();
		System.out.println("请输入年份：");
		int year = sc.nextInt();
		System.out.println("请输入月份：");
		int month = sc.nextInt();
		now.set(year, month - 1, 1); // 对日历对象重新赋值，指定年月的第一天
		int week = (now.get(Calendar.DAY_OF_WEEK) - 1);
		System.out.println("星期：" + (now.get(Calendar.DAY_OF_WEEK) - 1));
		int[] mycalendar = new int[42];
		// 存入每月的日期
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

		// 打印日历（每七个换行）
		System.out.println("日\t一\t二\t三\t四\t五\t六");
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
