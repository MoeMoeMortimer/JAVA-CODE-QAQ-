import java.util.Scanner;
public class Work3_password {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int admin = 10001, pass = 123456;
		int account, password;
		System.out.println("�������˺ţ�");
		account = sc.nextInt();
		System.out.println("���������룺");
		password = sc.nextInt();
		sc.close();
		if(admin == account)
			System.out.println("�˺���ȷ");
		else System.out.println("�˺Ŵ���");
		if(pass == password)
			System.out.println("������ȷ");
		else
			System.out.println("�������");
		sc.close();
	}
}
