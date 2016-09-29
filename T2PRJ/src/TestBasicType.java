import java.util.Scanner;
public class TestBasicType {
	public static void main(String[] args) {
		//boolean i = true;
		//if(i)
		//System.out.println("123");
		
		//输出n位数各位数字
		Scanner sc = new Scanner(System.in);
		int num, temp;
		num = sc.nextInt();
		while(num != 0){
			temp = num%10;
			num = num/10;
			System.out.println(temp);
		}
		sc.close();
		
		//数据运算
		System.out.println(-10%-3);
	}
}
