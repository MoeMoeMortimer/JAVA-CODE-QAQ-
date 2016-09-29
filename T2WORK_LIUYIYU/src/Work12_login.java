import java.util.Scanner;
public class Work12_login {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = 3;
		//String admin = "admin", pass = "admin";
		String account, password;
		while(n != 0){
			System.out.println("请输入用户名:");
			account = sc.next();
			System.out.println("请输入密码：");
			password = sc.next();
			if(account.equals("admin") && password.equals("admin")){
				System.out.println("登陆成功");
				System.exit(0);
			}
			n--;
			System.out.println("登陆失败，您还有"+n+"次输入机会");
		}
		sc.close();
	}
}
