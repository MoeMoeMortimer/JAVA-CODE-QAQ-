import java.util.Scanner;
public class Work17_game {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int a1 = 17, a2 = 29, n = 20,temp;
		String cur ="3,5,10,17,29";
		while(n != 0){
			System.out.println(cur);
			System.out.println("��������һ������");
			temp = sc.nextInt();
			if(temp == a1+a2+2){
				cur += ","+temp;
				System.out.println("������ȷ");
				a1 = a2;
				a2 = temp;
			}
			else 
				System.out.println("��������������������");
		}
		sc.close();
	}
}
