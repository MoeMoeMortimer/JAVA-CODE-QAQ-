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
				System.out.println("��Ч������������ѡ��ҵ��");break;
			}
		}
	}
	public static void print() {
		System.out.println("����ѡ��ҵ��");
		System.out.println("1 ��ѯ   2  ȡ��   3  ���   0�˳�");
	}
	
	public static void query() {
		System.out.println("�������Ϊ��"+money+"Ԫ��");
	}
	
	public static void login() {
		int n = 3;
		String account, password;
		while(n != 0){
			System.out.println("�������û���:");
			account = sc.next();
			System.out.println("���������룺");
			password = sc.next();
			if(account.equals("20160001") && password.equals("999999")){
				System.out.println("��½�ɹ�");
				flag = 1;
				break;
			}
			n--;
			System.out.println("��½ʧ��");
			if(n>0)System.out.println("������"+n+"���������");
			else System.out.println("�������࣬�˺�������");
		}
		if(flag == 1)System.out.println("��ӭ��½�������У�");
	}
	
	public static void save() {
		System.out.println("����������:");
		double debt = sc.nextDouble();
		money += debt;
		System.out.println("���ɹ����������Ϊ��" + money + "Ԫ��");
	}

	public static void debit() {
		System.out.println("������ȡ����:");
		double depo = sc.nextDouble();
		if(depo <= money){
			money -= depo;
			System.out.println("ȡ��ɹ����������Ϊ��"+money + "Ԫ��");
		}
		else
			System.out.println("���㣬ȡ��ʧ�ܡ�");
	}
	}

