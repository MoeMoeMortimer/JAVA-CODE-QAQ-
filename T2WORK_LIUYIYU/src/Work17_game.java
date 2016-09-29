import java.util.Scanner;
public class Work17_game {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int a1 = 17, a2 = 29, n = 20,temp;
		String cur ="3,5,10,17,29";
		while(n != 0){
			System.out.println(cur);
			System.out.println("请输入下一个数：");
			temp = sc.nextInt();
			if(temp == a1+a2+2){
				cur += ","+temp;
				System.out.println("输入正确");
				a1 = a2;
				a2 = temp;
			}
			else 
				System.out.println("您输入有误，请重新输入");
		}
		sc.close();
	}
}
