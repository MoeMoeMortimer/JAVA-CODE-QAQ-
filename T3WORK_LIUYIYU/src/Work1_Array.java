import java.util.Scanner;
public class Work1_Array {
	static int[] a = new int[10];
	static int choice;
	static Scanner sc = new Scanner(System.in);
	public static void main(String[] args) {
		input();
		while(true){
			Select();
			switch(choice){
			case 1:delete();break;
			case 2:update();break;
			case 3:query();break;
			case 4:FindMin();break;
			case 5:FindMax();break;
			case 6:sort();break;
			case 7:System.exit(0);
			default:
				System.out.println("无效的请求，请重新输入");continue;
			}
		}
	}
	
	public static void input(){
		//int ii= sc.nextInt();
		System.out.println("请输入10个整数:");
		for(int i = 0; i < 10; i++){
			System.out.println("第" +(i+1) +"个整数:");
			a[i] = sc.nextInt();
		}		
	}
	
	public static void Select(){
		System.out.println("请您选择要进行的操作：");
		System.out.println("1.删除  2.修改  3.查询  4.最小值  5.最大值  6.排序  7.退出");
		choice = sc.nextInt();
	}
	
	public static void delete(){
		System.out.println("请您输入要删除的数字在数组中的下标：");
		int index = sc.nextInt();
		System.out.println("a["+index+"] = "+a[index]+"已删除。");
		a[index] = -1;
	}
	
	public static void update(){
		System.out.println("请您输入要修改的数字在数组中的下标：");
		int index = sc.nextInt();
		System.out.println("请您输入新的数值：");
		int neew = sc.nextInt();
		a[index] = neew;
		System.out.println("a["+index+"] 已修改为 " + neew);
	}
	
	@SuppressWarnings("unused")
	public static void query(){
		System.out.println("请您输入要查询的数字在数组中的下标：");
		int num = sc.nextInt();
		int index = -1;
		for(int i = 0; i < a.length; i++){
			if(num == a[i])
				index = i;
			break;
		}
		if(index == -1)
			System.out.println("要查询的数字不在数组中。");
		else
			System.out.println("a["+index+"] = " + num);
	}
	
	public static void FindMin(){
		int min = a[0];
		for(int i = 0; i < 10 && a[i] >= 0; i++)
			if(a[i] < min)
				min = a[i];
		System.out.println("最小值为："+min);
	}
	
	public static void FindMax(){
		int max = a[0];
		for(int i = 0; i < 10 && a[i] >= 0 ; i++)
			if(a[i] > max)
				max = a[i];
		System.out.println("最大值为："+max);
	}
	
	public static void sort(){
		for (int i = 1; i < 10; i++) {
			for (int j = 0; j < 10 - i; j++) {
				if (a[j] > a[j + 1]) {
					int t = a[j + 1];
					a[j + 1] = a[j];
					a[j] = t;
				}
			}
		}
		for(int i = 0; i < a.length && a[i] >= 0; i++)
			System.out.print(a[i]+" ");
	}
}
