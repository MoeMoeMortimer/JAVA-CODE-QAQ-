import java.util.Scanner;
public class Work3_password {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int admin = 10001, pass = 123456;
		int account, password;
		System.out.println("ÇëÊäÈëÕËºÅ£º");
		account = sc.nextInt();
		System.out.println("ÇëÊäÈëÃÜÂë£º");
		password = sc.nextInt();
		sc.close();
		if(admin == account)
			System.out.println("ÕËºÅÕıÈ·");
		else System.out.println("ÕËºÅ´íÎó");
		if(pass == password)
			System.out.println("ÃÜÂëÕıÈ·");
		else
			System.out.println("ÃÜÂë´íÎó");
		sc.close();
	}
}
