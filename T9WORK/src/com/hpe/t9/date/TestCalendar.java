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
//		//��
//		int year = now.get(Calendar.YEAR);
//		System.out.println("�꣺"+year);
//		//��(��0��ʼ)
//		int month = now.get(Calendar.MONTH)+1;
//		System.out.println("�£�"+month);
//		//������
//		int day_in_mon = now.get(Calendar.DAY_OF_MONTH);
//		System.out.println("�����գ�"+day_in_mon);
//		//���ڣ���sunday��ʼ��
//		int week = now.get(Calendar.DAY_OF_WEEK)-1;
//		System.out.println("���ڣ�"+week);
		//�������µ�һ�������ڼ�
		//����������ֵ
		Scanner sc = new Scanner(System.in);
		System.out.println("��������ݣ�");
		int year = sc.nextInt();
		System.out.println("�������·ݣ�");
		int month = sc.nextInt();
		int date = 1;
		now.set(year,month-1,1);	//�������������¸�ֵ��ָ�����µĵ�һ��
		int week = (now.get(Calendar.DAY_OF_WEEK)-1);
		System.out.println("���ڣ�"+(now.get(Calendar.DAY_OF_WEEK)-1));
		int[] mycalendar = new int[42];
		//����ÿ�µ�����
		for(int i = 0; i < 42; i++){
			mycalendar[week++] = 1+i;
			if(i == 30){
				break;
			}
		}
		
		//��ӡ������ÿ�߸����У�
		System.out.println("��\tһ\t��\t��\t��\t��\t��");
		for(int i = 0; i < 42; i++){
			if(mycalendar[i] == 0)System.out.print(" \t");
			else
				System.out.print(mycalendar[i]+"\t");
			if((i+1)%7 == 0)
				System.out.println();
		}
		
	}
}
