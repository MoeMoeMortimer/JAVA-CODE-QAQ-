import java.util.Scanner;

public class Array {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		// ��ʽһ
		int[] score = new int[10];
		// ���¶������
		// int[] a;
		// a[0] = 1;
		// score[10] = 20;
		// �����±�Խ�磺Exception in thread "main"
		// java.lang.ArrayIndexOutOfBoundsException: 10
		// System.out.println(score[10]);
		// System.out.println(score[0]);
		// String[] names = new String[10];
		// System.out.println(names[0]);
		// boolean[] has = new boolean[10];
		// System.out.println(has[0]);
		// //////////////////////////////////
		// //��ʽ��
		// int[] score2 = {10,60,30};
		// score2[2] = 89;
		// System.out.println("������10���ɼ���");
		// for(int i = 0; i < score.length; i++){
		// System.out.print("��" + (i+1) + "��");
		// score[i] = sc.nextInt();
		// }
		// for(int i = 0; i < score.length; i++)
		// System.out.print(score[i]+" ");
		// sc.close();
		// ��������
		// int[] a = new int[10];
		// int t, sum = 0;
		// double aver;
		// System.out.println("������10���ɼ���");
		// for(int i = 0; i < a.length; i++){
		// System.out.print("��" + (i+1) + "��");
		// a[i] = sc.nextInt();
		// }
		//
		// for(int i = 1; i < 10; i++){
		// for(int j = 0; j < 10-i; j++){
		// if(a[j] > a[j+1]){
		// t = a[j+1];
		// a[j+1] = a[j];
		// a[j] = t;;
		// }
		// }
		// }
		// for(int i = 1; i < a.length-1; i++)
		// sum += a[i];
		// aver = sum/8;
		// System.out.println("���" + a[9]);
		// System.out.println("��С��" + a[0]);
		// System.out.println("ƽ����" + aver);
		// int index = -1;
		// int find;
		// find = sc.nextInt();
		// for(int i = 0; i < a.length; i++){
		// if(a[i] == find){
		// index = i+1;
		// break;
		// }
		// }
		// if(index == -1)System.out.println("not found!");
		// else System.out.println(index);
		int[] score2 = { 10, 60, 30 };
		int c = getmax(score2[0], score2[1]);
		System.out.println(c);
		System.out.println(welcome("susu"));
		welcome("����");
	}

	public static int getmax(int x, int y) {
		if (x > y) {
			return x;
		} else {
			return y;
		}
	}

	public static String welcome(String name) {
		return "��ӭ" + name + "�ؼ�!!";
	}

}
