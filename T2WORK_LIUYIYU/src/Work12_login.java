import java.util.Scanner;
public class Work12_login {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = 3;
		//String admin = "admin", pass = "admin";
		String account, password;
		while(n != 0){
			System.out.println("�������û���:");
			account = sc.next();
			System.out.println("���������룺");
			password = sc.next();
			if(account.equals("admin") && password.equals("admin")){
				System.out.println("��½�ɹ�");
				System.exit(0);
			}
			n--;
			System.out.println("��½ʧ�ܣ�������"+n+"���������");
		}
		sc.close();
	}
}
