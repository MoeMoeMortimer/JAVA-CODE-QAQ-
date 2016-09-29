package com.hpe.t9.date;

import java.util.Calendar;
import java.util.Scanner;

public class TestCalendar {
	public static int[] notleapday = {0,31,28,31,30,31,30,31,31,30,31,30,31};
	public static int[] leapday = {0,31,29,31,30,31,30,31,31,30,31,30,31};
//	public static boolean isleap(int Y){
//		    return (Y%(Y % 100?4:400)?false:true);
//	}
	public static void main(String[] args) {
		
		Calendar now = Calendar.getInstance();
//		//年
//		int year = now.get(Calendar.YEAR);
//		System.out.println("年："+year);
//		//月(从0开始)
//		int month = now.get(Calendar.MONTH)+1;
//		System.out.println("月："+month);
//		//月中日
//		int day_in_mon = now.get(Calendar.DAY_OF_MONTH);
//		System.out.println("月中日："+day_in_mon);
//		//星期（从sunday开始）
//		int week = now.get(Calendar.DAY_OF_WEEK)-1;
//		System.out.println("星期："+week);
		//任意年月第一天是星期几
		//给日历对象赋值
		Scanner sc = new Scanner(System.in);
		System.out.println("请输入年份：");
		int year = sc.nextInt();
		System.out.println("请输入月份：");
		int month = sc.nextInt();
		int date = 1;
		now.set(year,month-1,1);	//对日历对象重新赋值，指定年月的第一天
		int week = (now.get(Calendar.DAY_OF_WEEK)-1);
		System.out.println("星期："+(now.get(Calendar.DAY_OF_WEEK)-1));
		int[] mycalendar = new int[42];
		//存入每月的日期
		for(int i = 0; i < 42; i++){
			mycalendar[week++] = 1+i;
			if(i == 30){
				break;
			}
		}
		
		//打印日历（每七个换行）
		System.out.println("日\t一\t二\t三\t四\t五\t六");
		for(int i = 0; i < 42; i++){
			if(mycalendar[i] == 0)System.out.print(" \t");
			else
				System.out.print(mycalendar[i]+"\t");
			if((i+1)%7 == 0)
				System.out.println();
		}
		
	}
}
