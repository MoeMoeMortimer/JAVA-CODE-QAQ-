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
				System.out.println("��Ч����������������");continue;
			}
		}
	}
	
	public static void input(){
		//int ii= sc.nextInt();
		System.out.println("������10������:");
		for(int i = 0; i < 10; i++){
			System.out.println("��" +(i+1) +"������:");
			a[i] = sc.nextInt();
		}		
	}
	
	public static void Select(){
		System.out.println("����ѡ��Ҫ���еĲ�����");
		System.out.println("1.ɾ��  2.�޸�  3.��ѯ  4.��Сֵ  5.���ֵ  6.����  7.�˳�");
		choice = sc.nextInt();
	}
	
	public static void delete(){
		System.out.println("��������Ҫɾ���������������е��±꣺");
		int index = sc.nextInt();
		System.out.println("a["+index+"] = "+a[index]+"��ɾ����");
		a[index] = -1;
	}
	
	public static void update(){
		System.out.println("��������Ҫ�޸ĵ������������е��±꣺");
		int index = sc.nextInt();
		System.out.println("���������µ���ֵ��");
		int neew = sc.nextInt();
		a[index] = neew;
		System.out.println("a["+index+"] ���޸�Ϊ " + neew);
	}
	
	@SuppressWarnings("unused")
	public static void query(){
		System.out.println("��������Ҫ��ѯ�������������е��±꣺");
		int num = sc.nextInt();
		int index = -1;
		for(int i = 0; i < a.length; i++){
			if(num == a[i])
				index = i;
			break;
		}
		if(index == -1)
			System.out.println("Ҫ��ѯ�����ֲ��������С�");
		else
			System.out.println("a["+index+"] = " + num);
	}
	
	public static void FindMin(){
		int min = a[0];
		for(int i = 0; i < 10 && a[i] >= 0; i++)
			if(a[i] < min)
				min = a[i];
		System.out.println("��СֵΪ��"+min);
	}
	
	public static void FindMax(){
		int max = a[0];
		for(int i = 0; i < 10 && a[i] >= 0 ; i++)
			if(a[i] > max)
				max = a[i];
		System.out.println("���ֵΪ��"+max);
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
