package com.hpe.t9.math;

import java.util.Random;
import java.util.Scanner;

public class TestRandom {
	static int[] buy = new int[3];
	static int[] open = new int[3];
	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		// 排列3：0-9之间任意选一个数，选三次，每次可以重复 例如：323
		// 兑奖时，按顺序比对，例如，购买110，开奖120，则有两个数字相同
		// 1购买彩票
		while (true) {
			buyLottery();

			// 2开奖
			openLottery();

			// 3兑奖
			winLottery();
		}

	}

	private static void buyLottery() {
		System.out.println("----------购买---------");
		System.out.println("请输入0-9的3个数字");
		for (int i = 0; i < 3; i++)
			buy[i] = sc.nextInt();
	}

	private static void openLottery() {
		System.out.println("----------开奖---------");
		for (int i = 0; i < 3; i++) {
			Random rd = new Random();
			open[i] = rd.nextInt(10);
		}
		for (int i = 0; i < 3; i++) {
			System.out.print(open[i] + " ");
		}
		System.out.println();
	}

	private static void winLottery() {
		System.out.println("----------兑奖---------");
		System.out.println("请输入0-9的3个数字");
		int count = 0;
		for (int i = 0; i < 3; i++) {
			if (buy[i] == open[i]) {
				count++;
			}
		}
		switch (count) {
		case 0:
			System.out.println("欢迎下次再来！");
			break;
		case 1:
			System.out.println("三等奖,奖励2块。");
			break;
		case 2:
			System.out.println("二等奖，奖励20块。");
			break;
		case 3:
			System.out.println("一等奖，奖励2000块");
			break;
		}
	}
}

