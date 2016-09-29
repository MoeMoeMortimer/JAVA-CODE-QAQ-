import java.util.Scanner;

public class Array {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		// 方式一
		int[] score = new int[10];
		// 如下定义出错
		// int[] a;
		// a[0] = 1;
		// score[10] = 20;
		// 数组下标越界：Exception in thread "main"
		// java.lang.ArrayIndexOutOfBoundsException: 10
		// System.out.println(score[10]);
		// System.out.println(score[0]);
		// String[] names = new String[10];
		// System.out.println(names[0]);
		// boolean[] has = new boolean[10];
		// System.out.println(has[0]);
		// //////////////////////////////////
		// //方式二
		// int[] score2 = {10,60,30};
		// score2[2] = 89;
		// System.out.println("请输入10个成绩：");
		// for(int i = 0; i < score.length; i++){
		// System.out.print("第" + (i+1) + "个");
		// score[i] = sc.nextInt();
		// }
		// for(int i = 0; i < score.length; i++)
		// System.out.print(score[i]+" ");
		// sc.close();
		// 分数排序
		// int[] a = new int[10];
		// int t, sum = 0;
		// double aver;
		// System.out.println("请输入10个成绩：");
		// for(int i = 0; i < a.length; i++){
		// System.out.print("第" + (i+1) + "个");
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
		// System.out.println("最大：" + a[9]);
		// System.out.println("最小：" + a[0]);
		// System.out.println("平均：" + aver);
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
		welcome("粑粑");
	}

	public static int getmax(int x, int y) {
		if (x > y) {
			return x;
		} else {
			return y;
		}
	}

	public static String welcome(String name) {
		return "欢迎" + name + "回家!!";
	}

}
