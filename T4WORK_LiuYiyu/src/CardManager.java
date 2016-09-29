import java.util.Scanner;
import java.text.SimpleDateFormat;
import java.util.Date;
public class CardManager {
	static Card[] cards = new Card[100];
	static Trade[][] trades = new Trade[100][100];
	static int[] ct = new int[100];
	static int ptr = -1;
	static int lastid = 1001;
	static int iniId = 0001; 
	static int index = -1;
	static Scanner sc = new Scanner(System.in);
	public static void main(String[] args) {
		while(true){
			System.out.println("----------- 银行卡管理系统 -----------");
			System.out.println("欢迎您，请选择：  1开户         2登陆      0退出");
			int select = sc.nextInt();
			if(select == 0)break;
			else if(select == 1)add();
			else {
				login();
				while((index != -1)&&(cards[index].isState() == true)){
					Menu();
					int choice = sc.nextInt();
					// 1）修改密码  2查询账户信息  3存款 4取款  5 查询交易信息
					switch(choice){
					case 1: Change();break;
					case 2: find();break;
					case 3: deposit();break;
					case 4: debit();break;
					case 5: history();break;
					case 6: index = -1;break;
					default:
						System.out.println("无效的请求，请重新输入。");
					}
				}
			}	
		}	
	}
	private static void history(){
		for(int i = 0; i < ct[index]; i++)
			System.out.println(trades[index][i]);
	}		
	//交易信息
	
	private static void Change() {
		while(true){
			System.out.println("请输入原密码：");
			String p1 = sc.next();
			if(p1.equals(cards[index].getPassword()))break;
			else 
				System.out.println("密码输入错误，请重新输入！");
		}
		while(true){
			System.out.println("请输入新密码：");
			String p2 = sc.next();
			System.out.println("请再确认新密码：");
			String p3 = sc.next();
			if(p3.equals(p2)){
				System.out.println("密码修改成功！");
				cards[index].setPassword(p3);
				break;
			}	
			else 
				System.out.println("两次密码输入不一致，修改失败！");
		}	
	}
	//存款
	private static void deposit(){
		System.out.println("请输入存款金额：");
		double money = sc.nextDouble();
		cards[index].setBalance(cards[index].getBalance() + money);
		System.out.println("存款成功，余额为" + cards[index].getBalance() + "元。");
		String tradeid = "1900"+(iniId++);
		String type = "存款";
		String time = getNow();
		Trade tra = new Trade(tradeid, cards[index].getCardid(), money, type, time);
		trades[index][ct[index]++] = tra;	
		}	
	

	private static void debit() {
		System.out.println("请输入取款金额：");
		double money = sc.nextDouble();
		if(money > cards[index].getBalance()){
			System.out.println("余额不足，取款失败。");
		}else{
			cards[index].setBalance(cards[index].getBalance() - money);
			System.out.println("取款成功，余额为" + cards[index].getBalance() + "元。");
			String tradeid = "1900"+(iniId++);
			String type = "取款";
			String time = getNow();
			Trade tra = new Trade(tradeid, cards[index].getCardid(), money, type, time);
			trades[index][ct[index]++] = tra;
		}
		
	}
	public static String getNow() {
		Date now = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:MM:ss");
		return sdf.format(now);
	}
	
	private static void login() {
		int n = 3,flag = 0;
		String cid, password;
		while(index == -1){
			System.out.println("请输入卡号:");
			cid = sc.next();
			index = findById(cid);
			if(index == -1)
				System.out.println("该卡号不存在！");
		}
		while(n != 0){
			System.out.println("请输入密码：");
			password = sc.next();
			if(password.equals(cards[index].getPassword())){
				System.out.println("登陆成功");
				cards[index].setState(true);
				flag = 1;
				break;
			}
			n--;
			System.out.print("登陆失败，");
			if(n>0)System.out.println("您还有"+n+"次输入机会");
			else{
				System.out.println("密码错误次数过多，账号已锁定");
				cards[index].setState(false);
				index = -1;
			}
		}
		if(flag == 1)System.out.println("欢迎登陆网上银行！");
	}
	private static void add() {
		System.out.print("请输入");
		System.out.println("姓名：");
		String name = sc.next();
		System.out.println("身份证号：");
		String uid = sc.next();
		System.out.println("手机号：");
		String phone = sc.next();
		String cid = "20338765437";//本行开户卡号前缀
		cid = cid+(lastid++);
		String password = "999999";
		System.out.println("账户已于" + getNow() +"开通成功！您的卡号为" + cid +",默认密码为999999");
		System.out.println("请您设置开户金额：");
		double balance = sc.nextDouble();
		Card c = new Card(cid, password, name, uid, phone, balance, false);
		ptr++;
		cards[ptr] = c;
	}
	//查询账户信息
	private static void find() {
		System.out.println("账户信息如下：");
		System.out.println(cards[index]);
	}

	private static void Menu() {
		System.out.println("--------------- 银行卡管理系统 ---------------");
		System.out.println("1修改密码  2查询账户信息  3存款  4取款  5 查询交易信息  6退出");
		System.out.println("请选择业务：");
		
	}
	public static int findById(String cardid){
		int index = -1;
		for(int i = 0; i <= ptr; i++){
			if(cardid.equals(cards[i].getCardid())){
				index = i;
				break;
			}
		}
		return index;
	}
	public int createCardID(){
		if(ptr == -1){
			return 1000;
		}else{
			String lastCardid = cards[ptr ].getCardid();
			//截取后四位
			lastCardid = lastCardid.substring(12,16);
			//将字符串数字转成整数
			int cardid = Integer.parseInt(lastCardid);
			return cardid++;
		}
	}
}
