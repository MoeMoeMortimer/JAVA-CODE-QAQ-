import java.util.Scanner;
public class Work18_bank {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = 3, flag = 0;
		double money = 1557;
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
		while(flag == 1){
			int choice;		
			System.out.println("请您选择业务：");
			System.out.println("1 查询   2  取款   3  存款   0退出");
			choice = sc.nextInt();
			if(choice == 0)System.exit(0);
			else if(choice == 1){
				System.out.println("您的余额为："+money);
			}
			else if(choice == 2){
				System.out.println("请输入取款金额:");
				double depo = sc.nextDouble();
				if(depo <= money){
					money -= depo;
					System.out.println("取款成功，您的余额为："+money + "。");
				}
				else
					System.out.println("余额不足，取款失败。");
			}
			else if(choice == 3){
				double debt = sc.nextDouble();
				money += debt;
				System.out.println("存款成功，您的余额为：" + money + "。");
			}
			else System.out.println("无效的请求，请重新选择业务。");
		}
		sc.close();
	}
}
