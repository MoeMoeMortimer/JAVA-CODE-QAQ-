package com.hpe.t10.Student;

import java.util.ArrayList;
import java.util.Scanner;

public class StudentManager {
	static ArrayList<Student> slist = new ArrayList<Student>();
	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		while (true) {
			Menu();
			String select = sc.next();
			String regex = "[1-6]";
			if (!select.matches(regex)) {
				System.out.println("����1-6��ѡ��һ�����֡�");
				continue;
			}
			switch (select) {
			case "1":
				add();
				break;
			case "2":
				delete();
				break;
			case "3":
				update();
				break;
			case "4":
				find();
				break;
			case "5":
				findAll();
				break;
			case "6":
				System.exit(0);
			}
		}
	}

	private static void Menu() {
		System.out.println("----------- ѧ������ϵͳ -----------");
		System.out.println("1����  2ɾ��  3�޸�  4����  5��������  6�˳�");
		System.out.println("��ѡ��ҵ��");
	}

	private static void findAll() {
		System.out.println("---------- ����ѧ����Ϣ ----------");
		for (Student stu : slist) {
			System.out.println(stu);
		}
	}

	private static void find() {
		System.out.println("---------------- ����ѧ����Ϣ --------------");
		System.out.println("��ѡ��1.��ȷ����(��ѧ�Ų���)     2.ģ������");
		int choice = sc.nextInt();
		if (choice == 2) {
			vagueSearch();
		} else {
			System.out.println("������Ҫ���ҵ�ѧ�ţ�");
			int sid = sc.nextInt();
			int index = findIndexBySid(sid);
			if (index == -1)
				System.out.println("û���ҵ������Ϣ��");
			else
				System.out.println(slist.get(index));
		}
	}

	private static void delete() {
		// ɾ��ָ������
		System.out.println("---------------- ɾ��ѧ����Ϣ ---------------");
		while (true) {
			System.out.println("��ѡ��1.��ȷ����(��ѧ�Ų���)     2.ģ������");
			int choice = sc.nextInt();
			if (choice == 2) {
				vagueSearch();
			}
			System.out.println("������Ҫɾ����ѧ�ţ�");
			String ssid = sc.next();
			String regex = "^[0-9]{8}$";
			if (!ssid.matches(regex)) {
				System.out.println("ѧ�ű���Ϊ���֣�");
				continue;
			}
			int sid = Integer.parseInt(ssid);
			// �Ҹ�sid�ڼ����е�λ��
			int index = findIndexBySid(sid);
			if (index == -1) {
				System.out.println("û�и�ѧ����Ϣ");
				break;
			} else {
				// ����У���ӡ��Ϣ
				System.out.println(slist.get(index));
				System.out.println("ȷ��Ҫɾ��ô�� 1��  0��");
				int answer = sc.nextInt();
				if (answer == 1) {
					slist.remove(index);
					System.out.println("ɾ���ɹ���");
				}
				break;
			}
		}
	}

	private static void update() {
		// �޸�ָ����������Ϣ
		System.out.println("------------- �޸�ѧ����Ϣ ------------");
		System.out.println("��ѡ��1.��ȷ����(��ѧ�Ų���)   2.ģ������");
		int choice = sc.nextInt();
		if (choice == 2) {
			vagueSearch();
		}
		System.out.println("������Ҫ�޸ĵ�ѧ�ţ�");
		int sid = sc.nextInt();
		int index = findIndexBySid(sid);
		if (index == -1)
			System.out.println("û���ҵ������Ϣ��");
		else {
			System.out.println(slist.get(index));
			System.out.println("����������Ϣ��");
			System.out.println("������");
			String newname = sc.next();
			System.out.println("ѧ�ţ�");
			int id = sc.nextInt();
			// ����ָ��λ�õ�Ԫ��
			Student newitem = new Student(newname, id);
			slist.set(index, newitem);
		}
		System.out.println("�޸ĳɹ���" + slist.get(index));

	}

	private static void add() {
		System.out.println("------------����------------");
		// ѧ�Ŵ��� 1.���룬��Ҫ�ж���û���ظ�ֵ�� 2.�Զ�����
		int sid = createSid();
		// �Իس�
		String lf = sc.nextLine();
		while (true) {
			System.out.println("������ѧ������(��Ϊ����)��");
			String name = sc.nextLine();
			if (name.length() == 0) {
				System.out.println("��������Ϊ�գ�");
				continue;
			}
			String regex2 = "^[\u4e00-\u9fa5]+$";
			if (!name.matches(regex2)) {
				System.out.println("�������ֲ��ܰ���Ӣ����ĸ�����֣������������롣");
				continue;
			} else {
				// ��϶���
				Student stu = new Student(name, sid);
				// ��ӵ�����
				slist.add(stu);
				System.out.println("��ӳɹ���");
				System.out.println(stu);
				break;
			}
		}
	}

	// �Զ�����ѧ��
	private static int createSid() {
		int ptr = slist.size();
		if (ptr == 0) {
			return 15002000;
		} else {
			int lastsid = slist.get(ptr - 1).getSid();
			return ++lastsid;
		}
	}

	// ����ѧ�Ų�������
	private static int findIndexBySid(int sid) {
		int index = -1;
		for (int i = 0; i < slist.size(); i++) {
			if (sid == slist.get(i).getSid()) {
				index = i;
				break;
			}
		}
		return index;
	}

	// ʹ��������ʽʵ��ģ����ѯ
	// regex = ".*?�ؼ���.*?"
	private static void vagueSearch() {
		System.out.println("�����벿�ֹؼ��֣�");
		String piece = sc.next();
		String regex = "^.*?" + piece + ".*?$";
		for (Student stu : slist) {
			String s = "" + stu.getSid();
			if (s.matches(regex) || stu.getName().matches(regex))
				System.out.println(stu);
		}
	}
}
