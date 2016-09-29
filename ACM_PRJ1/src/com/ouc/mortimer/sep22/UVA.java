package com.ouc.mortimer.sep22;

import java.math.BigInteger;
import java.util.Scanner;

public class UVA {

	public static void main(String[] args) {
		int[] head = new int[20005];
		int[] kni = new int[20005];
		int m, n;
		int cur = 0;// ��ǰ�������±�
		BigInteger pay = BigInteger.ZERO;
		int ok = 0;
		Scanner sc = new Scanner(System.in);
		while (sc.hasNext()) {
			n = sc.nextInt();
			m = sc.nextInt();
			if (m == 0 && n == 0)
				break;
			else {
				for (int i = 0; i < n; i++)
					head[i] = sc.nextInt();
				for (int j = 0; j < m; j++)
					kni[j] = sc.nextInt();
				if (n > m) {
					System.out.println("Loowater is doomed!");
					continue;
				} else {
					sort(head, 0, n-1);
					sort(kni, 0, m-1);
					for (int i = 0; i < m; i++) {
						if (head[cur] <= kni[i]) {
							pay = pay.add(BigInteger.valueOf(kni[i]));
							cur++;
						}
						if (cur == n) {
							ok = 1;
							break;
						}
					}
					if (ok == 1)
						System.out.println(pay);
					else
						System.out.println("Loowater is doomed!");
					pay = BigInteger.ZERO;// һ��case֮��Ҫ�ǵø�ԭ���Թ�>��<
					cur = 0;
					ok = 0;
				}
			}
		}
		sc.close();
	}

	public static int[] sort(int[] nums, int low, int high) {
		int mid = (low + high) / 2;
		if (low < high) {
			// ���
			sort(nums, low, mid);
			// �ұ�
			sort(nums, mid + 1, high);
			// ���ҹ鲢
			merge(nums, low, mid, high);
		}
		return nums;
	}


	public static void merge(int[] nums, int low, int mid, int high) {
		int[] temp = new int[high - low + 1];
		int i = low;// ��ָ��
		int j = mid + 1;// ��ָ��
		int k = 0;

		// �ѽ�С�������Ƶ���������
		while (i <= mid && j <= high) {
			if (nums[i] < nums[j]) {
				temp[k++] = nums[i++];
			} else {
				temp[k++] = nums[j++];
			}
		}

		// �����ʣ�������������
		while (i <= mid) {
			temp[k++] = nums[i++];
		}

		// ���ұ߱�ʣ�������������
		while (j <= high) {
			temp[k++] = nums[j++];
		}

		// ���������е�������nums����
		for (int k2 = 0; k2 < temp.length; k2++) {
			nums[k2 + low] = temp[k2];
		}
	}
}