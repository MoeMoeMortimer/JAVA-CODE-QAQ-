package com.hpe.t9.String;
//string���͵Ĳ��ɱ��ԣ�+���Ӳ����Ὺ���µĿռ�
public class StringPerf {
	public static void main(String[] args) {
		String s1 = "hello";
		String temp1 = s1;
		s1 = s1+"";
		String temp2 = s1;
		System.out.println(temp1.equals(temp2));
		System.out.println(temp1 == temp2);
	}
}
