package com.hpe.t9.math;

import java.util.Random;
import java.util.Scanner;

public class TestRandom {
	static int[] buy = new int[3];
	static int[] open = new int[3];
	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		// ����3��0-9֮������ѡһ������ѡ���Σ�ÿ�ο����ظ� ���磺323
		// �ҽ�ʱ����˳��ȶԣ����磬����110������120����������������ͬ
		// 1�����Ʊ
		while (true) {
			buyLottery();

			// 2����
			openLottery();

			// 3�ҽ�
			winLottery();
		}

	}

	private static void buyLottery() {
		System.out.println("----------����---------");
		System.out.println("������0-9��3������");
		for (int i = 0; i < 3; i++)
			buy[i] = sc.nextInt();
	}

	private static void openLottery() {
		System.out.println("----------����---------");
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
		System.out.println("----------�ҽ�---------");
		System.out.println("������0-9��3������");
		int count = 0;
		for (int i = 0; i < 3; i++) {
			if (buy[i] == open[i]) {
				count++;
			}
		}
		switch (count) {
		case 0:
			System.out.println("��ӭ�´�������");
			break;
		case 1:
			System.out.println("���Ƚ�,����2�顣");
			break;
		case 2:
			System.out.println("���Ƚ�������20�顣");
			break;
		case 3:
			System.out.println("һ�Ƚ�������2000��");
			break;
		}
	}
}

