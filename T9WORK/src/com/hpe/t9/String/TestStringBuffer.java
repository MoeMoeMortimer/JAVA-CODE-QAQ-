package com.hpe.t9.String;

public class TestStringBuffer {
	   public static void main(String[] args) {
		   StringBuffer bf = new StringBuffer();
		   StringBuffer bf1 = bf;//bf1��bfͬһ����ַ	     
		   bf.append("hello");
		   System.out.println(bf1==bf);
		   bf.append(" everyone");
		   System.out.println(bf1==bf);
		   System.out.println(bf.toString());
	}
}
