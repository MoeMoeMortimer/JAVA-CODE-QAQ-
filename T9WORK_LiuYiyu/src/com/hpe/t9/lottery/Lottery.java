package com.hpe.t9.lottery;

import java.util.Random;
import java.util.Scanner;
import java.lang.String;

public class Lottery {
	static int[] buy = new int[7];
	static int[] open = new int[7];
	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		// 彩票系统35选7：输入1-35之间的七个数字，以逗号间隔
		// 兑奖时，按顺序比对，例如，购买110，开奖120，则有两个数字相同

		while (true) {
			// 1购买彩票
			buyLottery();

			// 2开奖
			openLottery();

			// 3兑奖
			winLottery();
		}

	}

	private static void buyLottery() {
		System.out.println("--------- 购买彩票 ---------");
		while (true) {
			System.out.println("请输入身份证号：");
			String id = sc.nextLine();
			if (id.length() == 0) {
				System.out.println("身份证号不能为空！");
				continue;
			}
			String regex2 = "^[0-9]{17}[0-9]|x$";
			if (id.matches(regex2)) {
				break;
			} else {
				System.out.println("身份证号格式有误！");
				continue;
			}
		}

		System.out.println("请输入1-35的7个数字，以逗号间隔");
		String lot = sc.nextLine();
		System.out.println(lot);
		String[] s = lot.split(",");
		for (int i = 0; i < 7; i++)
			buy[i] = Integer.parseInt(s[i]);
	}

	private static void openLottery() {
		System.out.println("---------- 彩票开奖 ---------");
		int tot = 0;
		while (tot != 7) {
			Random rd = new Random();
			int r = rd.nextInt(35);
			if (has(r) || r == 0)
				continue;
			else {
				open[tot] = r;
				tot++;
			}
		}
		System.out.print("[");
		for (int i = 0; i < 6; i++) {
			System.out.print(open[i] + ",");
		}
		System.out.println(open[6] + "]");
	}

	// 避免重复
	private static boolean has(int r) {
		for (int i = 0; i < open.length; i++) {
			if (open[i] == r)
				return true;
		}
		return false;
	}

	private static void winLottery() {
		System.out.println("---------- 兑奖 ---------");
		int count = 0;
		for (int i = 0; i < 3; i++) {
			if (buy[i] == open[i]) {
				count++;
			}
		}
		System.out.println("中奖数字个数：" + count);
		switch (count) {
		case 0:
			System.out.println("欢迎下次再来！");
			break;
		case 1:
		case 2:
		case 3:
			System.out.println("三等奖,中奖金额：2");
			break;
		case 4:
		case 5:
			System.out.println("二等奖，中奖金额：20");
			break;
		case 6:
		case 7:
			System.out.println("一等奖，中奖金额：200000");
			break;
		}
	}
}
