package com.sse.ch08.p2;

import com.sse.ch08.p1.User;

public class Admin extends User{
public Admin(){
	System.out.println("����Admin���췽��");
}
public static void main(String[] args) {
  Admin a = new Admin();
  //��ͬ���µ�������Է���public,protected
  a.id = 102;//public
  a.authority = 1;//protected
  System.out.println(a);
}
}
