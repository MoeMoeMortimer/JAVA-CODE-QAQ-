package com.hpe.t9.date;

import java.util.Date;
import java.util.Scanner;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class TestDate {
	public static void main(String[] args) {
		// java.util.Date ——util时分秒
		Date now = new Date();
		System.out.println(now);
		// java.sql.Date ——sql年月日
		// now.getTime() 获取1970.1.1到现在的毫秒数
		java.sql.Date now2 = new java.sql.Date(now.getTime());
		System.out.println(now2);
		// java.sql.Timestamp ——年月日时分秒（纳秒）
		Timestamp now3 = new Timestamp(now.getTime());
		System.out.println(now3);
		System.out.println("输入出生日期：");
		Scanner sc = new Scanner(System.in);
		String birth = sc.nextLine();
		java.sql.Date dbirth = java.sql.Date.valueOf(birth);
		System.out.println(dbirth);
		
		System.out.println("请输入日期,yyyy-MM-dd");
		String vdate = sc.nextLine();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		try {
			// 将字符串日期转成Date对象
			Date date = sdf.parse(vdate);
			System.out.println(date);
			// 将日期转成（yyyy年MM月dd日）
			sdf = new SimpleDateFormat("yyyy年MM月dd日");
			String mydate = sdf.format(date);
			System.out.println(mydate);

		} catch (ParseException e) {
			e.printStackTrace();
		}
	}
}
