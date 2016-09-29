package com.hpe.t9.lottery;

import java.util.Random;
import java.util.Scanner;
import java.lang.String;

public class Lottery {
	static int[] buy = new int[7];
	static int[] open = new int[7];
	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		// ��Ʊϵͳ35ѡ7������1-35֮����߸����֣��Զ��ż��
		// �ҽ�ʱ����˳��ȶԣ����磬����110������120����������������ͬ

		while (true) {
			// 1�����Ʊ
			buyLottery();

			// 2����
			openLottery();

			// 3�ҽ�
			winLottery();
		}

	}

	private static void buyLottery() {
		System.out.println("--------- �����Ʊ ---------");
		while (true) {
			System.out.println("���������֤�ţ�");
			String id = sc.nextLine();
			if (id.length() == 0) {
				System.out.println("���֤�Ų���Ϊ�գ�");
				continue;
			}
			String regex2 = "^[0-9]{17}[0-9]|x$";
			if (id.matches(regex2)) {
				break;
			} else {
				System.out.println("���֤�Ÿ�ʽ����");
				continue;
			}
		}

		System.out.println("������1-35��7�����֣��Զ��ż��");
		String lot = sc.nextLine();
		System.out.println(lot);
		String[] s = lot.split(",");
		for (int i = 0; i < 7; i++)
			buy[i] = Integer.parseInt(s[i]);
	}

	private static void openLottery() {
		System.out.println("---------- ��Ʊ���� ---------");
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

	// �����ظ�
	private static boolean has(int r) {
		for (int i = 0; i < open.length; i++) {
			if (open[i] == r)
				return true;
		}
		return false;
	}

	private static void winLottery() {
		System.out.println("---------- �ҽ� ---------");
		int count = 0;
		for (int i = 0; i < 3; i++) {
			if (buy[i] == open[i]) {
				count++;
			}
		}
		System.out.println("�н����ָ�����" + count);
		switch (count) {
		case 0:
			System.out.println("��ӭ�´�������");
			break;
		case 1:
		case 2:
		case 3:
			System.out.println("���Ƚ�,�н���2");
			break;
		case 4:
		case 5:
			System.out.println("���Ƚ����н���20");
			break;
		case 6:
		case 7:
			System.out.println("һ�Ƚ����н���200000");
			break;
		}
	}
}
