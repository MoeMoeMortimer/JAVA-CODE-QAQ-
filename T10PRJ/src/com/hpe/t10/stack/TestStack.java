package com.hpe.t10.stack;

import java.util.Stack;

public class TestStack {
	public static void main(String[] args) {
		Stack<String> mystack = new Stack<String>();
		// ��ջ
		mystack.push("aaa");
		mystack.push("bbb");
		mystack.push("ccc");
		// ��ջ
		System.out.println(mystack.pop());
		System.out.println(mystack.pop());
	}
}
