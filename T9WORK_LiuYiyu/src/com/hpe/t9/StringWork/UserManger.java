package com.hpe.t9.StringWork;

import java.util.Scanner;

public class UserManger {
	static User[] user = new User[100];
	static Scanner sc = new Scanner(System.in);
	static int ptr = -1;

	public static void main(String[] args) {
		while (true) {
			System.out.println("-----------用户自助服务系统----------");
			System.out.println("欢迎您！请选择：1.注册      2.登录     0.退出");
			int choice = sc.nextInt();
			//接收回车换行
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
				System.out.println("无效的请求，请重新输入！");
			}
		}
	}

	private static void login() {
		while(true){
			System.out.println("请输入用户名：");
			String username = sc.nextLine();
			int index = findByName(username);
			if(index == -1){
				System.out.println("该用户不存在！");
				continue;
			}else {
				while(true){
					System.out.println("请输入密码：");
					String pass = sc.nextLine();
					if(!pass.equals(user[index].getPassword())){
						System.out.println("密码错误！");
						continue;
					}
					else{
						System.out.println("您已成功登录！");
						break;
					}
				}
				break;
			}
		}

	}

	private static void register() {
		String username, password, id, chname, tel, email;
		// 用户名，密码，昵称，中文名字，手机号，邮箱
		//密码>=六位,字母、数字或下划线
		while (true) {
			System.out.println("请输入用户名：");
			username = sc.nextLine();
			if (findByName(username) != -1) {
				System.out.println("该用户名已被注册。");
				continue;
			} else if (username.length() == 0) {
				System.out.println("用户名不能为空！");
				continue;
			} else {
				break;
			}
		}
		while (true) {
			System.out.println("请输入密码(至少为六位,由字母、数字或下划线组成)：");
			password = sc.nextLine();
			if (password.length() == 0) {
				System.out.println("密码不能为空！");
				continue;
			}
			String regex1 = "^[0-9a-zA-Z_]{6,}$";
			if (password.matches(regex1)) {
				System.out.println("请确认密码：");
				String pass = sc.nextLine();
				if (pass.equals(password)) {
					break;
				} else {
					System.out.println("密码错误！");
					continue;
				}
			} else {
				System.out.println("密码格式错误，应至少为六位,由字母、数字或下划线组成。");
				continue;
			}
		}

		while (true) {
			System.out.println("请输入昵称：");
			id = sc.nextLine();
			if (id.length() == 0) {
				System.out.println("昵称不能为空！");
				continue;
			}
			String regex2 = "^[0-9a-zA-Z_]+$";// "^[0-9]{17}[0-9]|x$";
			if (id.matches(regex2)) {
				System.out.println("您的昵称为：");
				System.out.println(id);
				break;
			} else {
				System.out.println("昵称格式错误，请您重新输入。");
				continue;
			}
		}

		while (true) {
			System.out.println("请输入中文名字：");
			chname = sc.nextLine();
			if (chname.length() == 0) {
				System.out.println("中文名字不能为空！");
				continue;
			}
			String regex2 = "^[\u4e00-\u9fa5]+$";
			if (!chname.matches(regex2)) {
				System.out.println("中文名字不能包含英文字母或数字，请您重新输入。");
				continue;
			} else {
				System.out.println("您的中文名字为：");
				System.out.println(chname);
				break;
			}
		}

		while (true) {
			System.out.println("请输入手机号：");
			tel = sc.nextLine();
			if (tel.length() == 0) {
				System.out.println("手机号不能为空！");
				continue;
			}
			String regex = "^[0-9]{11}$";
			if (tel.matches(regex)) {
				System.out.println("您的手机号为：");
				System.out.println(tel);
				break;
			} else {
				System.out.println("手机号格式错误，请重新输入。");
				continue;
			}
		}

		while (true) {
			System.out.println("请输入邮箱：");
			email = sc.nextLine();
			if (email.length() == 0) {
				System.out.println("邮箱不能为空！");
				continue;
			}
			String regex = "^[a-zA-Z0-9][a-zA-Z0-9_-]*@([a-zA-Z0-9_-]+\\.)+(com|gov|net|com\\.cn|edu\\.cn)$";
			if (email.matches(regex)) {
				System.out.println("您的邮箱为：");
				System.out.println(email);
				break;
			} else {
				System.out.println("邮箱格式错误，请重新输入。");
				continue;
			}
		}
		User u = new User(username, password, id, chname, tel, email);
		ptr++;
		user[ptr] = u;
		System.out.println("您已成功注册，" + u);

	}
	
	//业务辅助方法
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
