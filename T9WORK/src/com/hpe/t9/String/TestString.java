package com.hpe.t9.String;

public class TestString {
	public static void main(String[] args) {
		String str1 = new String("apple");
		String str2 = new String("apple");
		System.out.println(str1 == str2);
		System.out.println(str1.equals(str2));
	}
}
