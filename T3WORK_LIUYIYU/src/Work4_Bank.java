import java.util.Scanner;

public class Work4_Bank {
	static int money = 1500;
	static int flag = 0;
	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		login();
		while(flag == 1){
			print();
			int choice = sc.nextInt();
			switch(choice){
			case 1:query();break;
			case 2:debit();break;
			case 3:save();break;
			case 4:System.exit(0);
			default:
				System.out.println("无效的请求，请重新选择业务。");break;
			}
		}
	}
	public static void print() {
		System.out.println("请您选择业务：");
		System.out.println("1 查询   2  取款   3  存款   0退出");
	}
	
	public static void query() {
		System.out.println("您的余额为："+money+"元。");
	}
	
	public static void login() {
		int n = 3;
		String account, password;
		while(n != 0){
			System.out.println("请输入用户名:");
			account = sc.next();
			System.out.println("请输入密码：");
			password = sc.next();
			if(account.equals("20160001") && password.equals("999999")){
				System.out.println("登陆成功");
				flag = 1;
				break;
			}
			n--;
			System.out.println("登陆失败");
			if(n>0)System.out.println("您还有"+n+"次输入机会");
			else System.out.println("次数过多，账号已锁定");
		}
		if(flag == 1)System.out.println("欢迎登陆网上银行！");
	}
	
	public static void save() {
		System.out.println("请输入存款金额:");
		double debt = sc.nextDouble();
		money += debt;
		System.out.println("存款成功，您的余额为：" + money + "元。");
	}

	public static void debit() {
		System.out.println("请输入取款金额:");
		double depo = sc.nextDouble();
		if(depo <= money){
			money -= depo;
			System.out.println("取款成功，您的余额为："+money + "元。");
		}
		else
			System.out.println("余额不足，取款失败。");
	}
	}

