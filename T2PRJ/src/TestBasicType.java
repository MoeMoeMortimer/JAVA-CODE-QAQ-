import java.util.Scanner;
public class TestBasicType {
	public static void main(String[] args) {
		//boolean i = true;
		//if(i)
		//System.out.println("123");
		
		//���nλ����λ����
		Scanner sc = new Scanner(System.in);
		int num, temp;
		num = sc.nextInt();
		while(num != 0){
			temp = num%10;
			num = num/10;
			System.out.println(temp);
		}
		sc.close();
		
		//��������
		System.out.println(-10%-3);
	}
}
