package com.hpe.t9.StringWork;

import java.util.Scanner;

public class UserManger {
	static User[] user = new User[100];
	static Scanner sc = new Scanner(System.in);
	static int ptr = -1;

	public static void main(String[] args) {
		while (true) {
			System.out.println("-----------�û���������ϵͳ----------");
			System.out.println("��ӭ������ѡ��1.ע��      2.��¼     0.�˳�");
			int choice = sc.nextInt();
			//���ջس�����
			String lf = sc.nextLine();
			switch (choice) {
			case 1:
				register();
				break;
			case 2:
				login();
				break;
			case 0:
				System.exit(0);
			default:
				System.out.println("��Ч���������������룡");
			}
		}
	}

	private static void login() {
		while(true){
			System.out.println("�������û�����");
			String username = sc.nextLine();
			int index = findByName(username);
			if(index == -1){
				System.out.println("���û������ڣ�");
				continue;
			}else {
				while(true){
					System.out.println("���������룺");
					String pass = sc.nextLine();
					if(!pass.equals(user[index].getPassword())){
						System.out.println("�������");
						continue;
					}
					else{
						System.out.println("���ѳɹ���¼��");
						break;
					}
				}
				break;
			}
		}

	}

	private static void register() {
		String username, password, id, chname, tel, email;
		// �û��������룬�ǳƣ��������֣��ֻ��ţ�����
		//����>=��λ,��ĸ�����ֻ��»���
		while (true) {
			System.out.println("�������û�����");
			username = sc.nextLine();
			if (findByName(username) != -1) {
				System.out.println("���û����ѱ�ע�ᡣ");
				continue;
			} else if (username.length() == 0) {
				System.out.println("�û�������Ϊ�գ�");
				continue;
			} else {
				break;
			}
		}
		while (true) {
			System.out.println("����������(����Ϊ��λ,����ĸ�����ֻ��»������)��");
			password = sc.nextLine();
			if (password.length() == 0) {
				System.out.println("���벻��Ϊ�գ�");
				continue;
			}
			String regex1 = "^[0-9a-zA-Z_]{6,}$";
			if (password.matches(regex1)) {
				System.out.println("��ȷ�����룺");
				String pass = sc.nextLine();
				if (pass.equals(password)) {
					break;
				} else {
					System.out.println("�������");
					continue;
				}
			} else {
				System.out.println("�����ʽ����Ӧ����Ϊ��λ,����ĸ�����ֻ��»�����ɡ�");
				continue;
			}
		}

		while (true) {
			System.out.println("�������ǳƣ�");
			id = sc.nextLine();
			if (id.length() == 0) {
				System.out.println("�ǳƲ���Ϊ�գ�");
				continue;
			}
			String regex2 = "^[0-9a-zA-Z_]+$";// "^[0-9]{17}[0-9]|x$";
			if (id.matches(regex2)) {
				System.out.println("�����ǳ�Ϊ��");
				System.out.println(id);
				break;
			} else {
				System.out.println("�ǳƸ�ʽ���������������롣");
				continue;
			}
		}

		while (true) {
			System.out.println("�������������֣�");
			chname = sc.nextLine();
			if (chname.length() == 0) {
				System.out.println("�������ֲ���Ϊ�գ�");
				continue;
			}
			String regex2 = "^[\u4e00-\u9fa5]+$";
			if (!chname.matches(regex2)) {
				System.out.println("�������ֲ��ܰ���Ӣ����ĸ�����֣������������롣");
				continue;
			} else {
				System.out.println("������������Ϊ��");
				System.out.println(chname);
				break;
			}
		}

		while (true) {
			System.out.println("�������ֻ��ţ�");
			tel = sc.nextLine();
			if (tel.length() == 0) {
				System.out.println("�ֻ��Ų���Ϊ�գ�");
				continue;
			}
			String regex = "^[0-9]{11}$";
			if (tel.matches(regex)) {
				System.out.println("�����ֻ���Ϊ��");
				System.out.println(tel);
				break;
			} else {
				System.out.println("�ֻ��Ÿ�ʽ�������������롣");
				continue;
			}
		}

		while (true) {
			System.out.println("���������䣺");
			email = sc.nextLine();
			if (email.length() == 0) {
				System.out.println("���䲻��Ϊ�գ�");
				continue;
			}
			String regex = "^[a-zA-Z0-9][a-zA-Z0-9_-]*@([a-zA-Z0-9_-]+\\.)+(com|gov|net|com\\.cn|edu\\.cn)$";
			if (email.matches(regex)) {
				System.out.println("��������Ϊ��");
				System.out.println(email);
				break;
			} else {
				System.out.println("�����ʽ�������������롣");
				continue;
			}
		}
		User u = new User(username, password, id, chname, tel, email);
		ptr++;
		user[ptr] = u;
		System.out.println("���ѳɹ�ע�ᣬ" + u);

	}
	
	//ҵ��������
	public static int findByName(String name) {
		int index = -1;
		for (int i = 0; i <= ptr; i++) {
			if (name.equals(user[i].getUsername())) {
				index = i;
				break;
			}
		}
		return index;
	}
}
