import java.util.Scanner;
public class Work18_bank {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = 3, flag = 0;
		double money = 1557;
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
		while(flag == 1){
			int choice;		
			System.out.println("����ѡ��ҵ��");
			System.out.println("1 ��ѯ   2  ȡ��   3  ���   0�˳�");
			choice = sc.nextInt();
			if(choice == 0)System.exit(0);
			else if(choice == 1){
				System.out.println("�������Ϊ��"+money);
			}
			else if(choice == 2){
				System.out.println("������ȡ����:");
				double depo = sc.nextDouble();
				if(depo <= money){
					money -= depo;
					System.out.println("ȡ��ɹ����������Ϊ��"+money + "��");
				}
				else
					System.out.println("���㣬ȡ��ʧ�ܡ�");
			}
			else if(choice == 3){
				double debt = sc.nextDouble();
				money += debt;
				System.out.println("���ɹ����������Ϊ��" + money + "��");
			}
			else System.out.println("��Ч������������ѡ��ҵ��");
		}
		sc.close();
	}
}
