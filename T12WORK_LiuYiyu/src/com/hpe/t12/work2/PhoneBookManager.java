package com.hpe.t12.work2;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class PhoneBookManager {
	// �绰������
	static ArrayList<PhoneBook> books = new ArrayList<PhoneBook>();
	static Scanner sc = new Scanner(System.in);
	static File f = new File("d:\\phonebook.txt");	//�绰���ļ�
	static File f1 = new File("d:\\history.txt");	//������־�ļ�
	public static void main(String[] args) {
		if (f.exists() == false || f1.exists() == false) {
			// ����һ���µ绰��
			try {
				f.createNewFile();
				f1.createNewFile();
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		int choice;
		while (true) {
			Menu();
			choice = sc.nextInt();
			switch (choice) {
			case 1:
				add();
				break;
			case 2:
				delete();
				break;
			case 3:
				update();
				break;
			case 4:
				find();
				break;
			case 5:
				findAll();
				break;
			case 6:
				readAllfromHistory(f1);
				break;
			case 7:
				System.exit(0);
			default:
				System.out.println("��Ч���������������롣");
			}
		}
	}

	public static void Menu() {
		System.out.println("--------------- �绰������ϵͳ ----------------");
		System.out.println("1����  2ɾ��  3�޸�  4����  5��������   6�鿴������¼   7�˳�");
		System.out.println("��ѡ��ҵ��");
	}

	private static void findAll() {
		readAlltoList(f);
		System.out.println("----------------- ������ϵ�� -----------------");
		for (PhoneBook b : books) {
			System.out.println(b);
		}
	}
	
	private static void find() {
		readAlltoList(f);
		System.out.println("------------------ ���ҵ绰�� -----------------");
		System.out.println("��ѡ�� 1.��ȷ���ң����������ң�   2.ģ������");
		int choice = sc.nextInt();
		if (choice == 2) {
			vagueSearch();
		}
		System.out.println("������Ҫ���ҵ�������");
		String name = sc.next();
		int index = findByName(name);
		if (index == -1)
			System.out.println("û���ҵ������Ϣ��");
		else
			System.out.println(books.get(index));
	}

	//Ϊ�޸Ĳ��������ģ������
	private static void update() {
		readAlltoList(f);
		System.out.println("----------------- �޸ĵ绰�� -----------------");
		System.out.println("��ѡ�� 1.��ȷ���ң����������ң�   2.ģ������");
		int choice = sc.nextInt();
		if (choice == 2) {
			vagueSearch();
		}
		System.out.println("������Ҫ�޸ĵ�������");
		String name = sc.next();
		int index = findByName(name);
		if (index == -1)
			System.out.println("û���ҵ������Ϣ��");
		else {
			System.out.println(books.get(index));
			System.out.println("������������Ϣ��");
			System.out.println("������");
			String newname = sc.next();
			System.out.println("�Ա�");
			String sex = sc.next();
			System.out.println("���䣺");
			int age = sc.nextInt();
			System.out.println("�绰��");
			String tel = sc.next();
			System.out.println("QQ��");
			String QQ = sc.next();
			System.out.println("��ַ��");
			String addr = sc.next();
			// ����ָ��λ�õ�Ԫ��
			PhoneBook newitem = new PhoneBook(newname, sex, addr, tel, QQ, age);
			String s = transformHistory("�޸�", books.get(index), newitem);
			appendNewtoFile(f1, s);
			books.set(index, newitem);	
		}
		System.out.println("�޸ĳɹ���" + books.get(index));
		writeAlltoList(f);
	}

	//Ϊɾ�����������ģ������
	private static void delete() {
		readAlltoList(f);
		System.out.println("----------------- ɾ���绰�� ----------------");
		System.out.println("��ѡ�� 1.��ȷ���ң����������ң�   2.ģ������");
		int choice = sc.nextInt();
		if (choice == 2) {
			vagueSearch();
		}
		System.out.println("������Ҫɾ����������");
		String name = sc.next();
		int index = findByName(name);
		if (index == -1) {
			System.out.println("û���ҵ������Ϣ��");
			return;
		} else {
			System.out.println(books.get(index));
			System.out.println("��ȷ��Ҫɾ���� 1��0��");
			int result = sc.nextInt();
			if (result == 1) {
				books.remove(index);
				String s = transformHistory("ɾ��", books.get(index), null);
				appendNewtoFile(f1, s);
			}
		}
		readAlltoList(f);
	}
	
	//���
	private static void add() {
		System.out.println("------------ ���ӵ绰�� -----------");
		System.out.println("������");
		String name = sc.next();
		System.out.println("�Ա�");
		String sex = sc.next();
		System.out.println("���䣺");
		int age = sc.nextInt();
		System.out.println("�绰��");
		String tel = sc.next();
		System.out.println("QQ��");
		String QQ = sc.next();
		System.out.println("��ַ��");
		String addr = sc.next();
		// ��϶���
		PhoneBook book = new PhoneBook(name, sex, tel, QQ, addr, age);
		System.out.println("��ӳɹ���" + book);
		String s = name + " " + sex + " " + tel + " " + QQ + " " + addr + " " + age;
		String s1 = transformHistory("����", book, null);
		appendNewtoFile(f,s);
		appendNewtoFile(f1, s1);
	}

	// ҵ�������������������±�
	public static int findByName(String name) {
		int index = -1;
		for (int i = 0; i <= books.size(); i++) {
			if (name.equals(books.get(i).getName())) {
				index = i;
				break;
			}
		}
		return index;
	}
	
	//���޸���Ϣת��Ϊһ��������¼���������ļ�д��
	private static String transformHistory(String operation, PhoneBook from, PhoneBook to){
		String message;
		Date lastModifiedTime = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy��MM��dd��,HH:mm:ss");
		if(operation.equals("�޸�")){
			message = "��������:" + operation + "\t" + "�޸�ʱ��:" +sdf.format(lastModifiedTime)+ "\n" 
			+ "ԭ��ϵ����Ϣ��" + from + "\n" + "����ϵ����Ϣ��" + to + "\n";
		}else{
				message = "��������:" + operation + "\t" + "�޸�ʱ��:" +sdf.format(lastModifiedTime)+ "\n" + "��ϵ����Ϣ��" + from + "\n";
		}
		return message;
	}
		
	//�����ļ��ж�������ϢתΪPhoneBook������뼯��
	private static void putinList(String s) {
		// 1���ַ���
		String[] bkStr = s.split(" ");
		// 2ȡ������������϶���name, sex, addr, tel, QQ, age
		String name = bkStr[0];
		String sex = bkStr[1];
		String addr = bkStr[2];
		String tel = bkStr[3];
		String QQ = bkStr[4];
		int age = Integer.parseInt(bkStr[5]);
		PhoneBook b = new PhoneBook(name, sex, tel, QQ, addr, age);
		// 3���뼯��
		books.add(b);
	}
	
	
	// ʹ��������ʽʵ��ģ����ѯ
	// regex = ".*?�ؼ���.*?"
	private static void vagueSearch() {
		System.out.println("�����벿�ֹؼ���(���ڸ���ϵ�˵�������Ϣ����)��");
		String piece = sc.next();
		String regex = "^.*?" + piece + ".*?$";
		for (PhoneBook b : books) {
			String s = ""+b.getAge();
			//������Ϣ����һ��ƥ�伴��
			if (s.matches(regex) || b.getName().matches(regex) || b.getAddr().matches(regex)
				|| b.getTel().matches(regex) || b.getSex().matches(regex) || b.getQQ().matches(regex))
				System.out.println(b);
		}
	}
	
	
	/**
	 * ��ĩβ���ӣ�append��
	 * ����һ���������ļ���д���ַ����ݵ��ַ������������ 
	 * ����ļ������ڣ����Զ�������
	 * ��·������ʱ�����쳣
	 * ���ڴ���ʱ����true������ʵ�ֶ��ļ�����д��
	 */
	private static void appendNewtoFile(File f,String s){
		FileWriter fw = null;
		try {
			fw = new FileWriter(f, true);
			PrintWriter pw = new PrintWriter(fw);
			// д���ļ���Ϣ
			pw.println(s);
			// �ر���
			pw.close();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (fw != null) {
				try {
					fw.close();
				} catch (IOException e) {
					throw new RuntimeException("�绰���ر�ʧ�ܣ�");
				}
			}
		}
	}
	
	//��ȡ���еĲ�����¼
	private static void readAllfromHistory(File f) {
	try {
		// 1�����ַ�������-���ļ���������
		FileReader fr = new FileReader(f);
		// 2�����ַ������������ַ�������
		BufferedReader br = new BufferedReader(fr);
		// 3���ļ�
		while (true) {
			String s = br.readLine();
			if (s == null) {
				break;
			} else {
				System.out.println(s);
			}
		}
		// 4�ر���
		br.close();
	} catch (Exception e) {
		e.printStackTrace();
	}
}
	//���ļ��ж�ȡ������Ϣ����ӵ�ArrayList��
	private static void readAlltoList(File f) {
		books.clear();
		try {
			// 1�����ַ�������-���ļ���������
			FileReader fr = new FileReader(f);
			// 2�����ַ������������ַ�������
			BufferedReader br = new BufferedReader(fr);
			// 3���ļ�
			while (true) {
				String s = br.readLine();
				if (s == null) {
					break;
				} else {
					putinList(s);
				}
			}
			// 4�ر���
			br.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	//��books��������Ϣд���ļ���
	private static void writeAlltoList(File f){
		FileWriter fw = null;
		try {
			fw = new FileWriter(f);
			PrintWriter pw = new PrintWriter(fw);
			// д���ļ���Ϣ
			for(PhoneBook b: books){
				String s = b.getName() + " " + b.getSex() + " " + b.getAddr() + " " + b.getTel() + " " + b.getQQ() + " " + b.getAge();
				pw.println(s);
			}
			// �ر���
			pw.close();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (fw != null) {
				try {
					fw.close();
				} catch (IOException e) {
					throw new RuntimeException("�ļ��ر�ʧ�ܣ�");
				}
			}
		}
	}
}
