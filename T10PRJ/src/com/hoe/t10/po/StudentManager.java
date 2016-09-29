package com.hoe.t10.po;

import java.util.ArrayList;
import java.util.Scanner;

public class StudentManager {
	static ArrayList<Student> slist = new ArrayList<Student>();
	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		while(true){
			System.out.println("1.����   2.ɾ��  3.�޸�   4.����    5.��������   6.�˳�");
			System.out.println("��ѡ��ҵ��");
			String select = sc.next();
			String regex = "[1-6]";
			if(!select.matches(regex)){
				System.out.println("����1-6��ѡ��һ�����֡�");
				continue;
			}
			switch(select){
			case "1":add();break;
			case "2":delete();break;
			case "3":update();break;
			case "4":find();break;
			case "5":findAll();break;
			case "6":System.exit(0);
			}
		}
	}

	private static void findAll() {
		System.out.println("----------����ѧ����Ϣ----------");
		for(Student stu : slist){
			System.out.println(stu);
		}
		
	}

	private static void find() {
		// TODO Auto-generated method stub
		
	}

	private static void update() {
		// TODO Auto-generated method stub
		System.out.println("--------------ɾ��-------------");
		while(true){
			System.out.println("������Ҫɾ����ѧ�ţ�");
			String ssid = sc.next();
			String regex = "^[0-9]{8}$";
			if(!ssid.matches(regex)){
				System.out.println("ѧ�ű���Ϊ���֣�");
				continue;
			}
			int sid = Integer.parseInt(ssid);
			//�Ҹ�sid�ڼ����е�λ��
			int index = findIndexBySid(sid);
			if(index == -1){
				System.out.println("û�и�ѧ����Ϣ");
				break;
			}else{
				//����У���ӡ��Ϣ
				System.out.println(slist.get(index));
				System.out.println("ȷ��Ҫɾ��ô�� 1��  0��");
				int answer = sc.nextInt();
				slist.remove(index);
				System.out.println("ɾ���ɹ���");
				break;
			}
		}
	}

	private static int findIndexBySid(int sid) {
		int index = -1;
		for(int i = 0;  i < slist.size(); i++){
			if(sid == slist.get(i).getSid()){
				index = i;
				break;
			}
		}
		return index;
	}

	private static void delete() {
		// ɾ��ָ������
		
	}
	
	private static void add() {
		System.out.println("------------����------------");
		//ѧ�Ŵ��� 1.���룬��Ҫ�ж���û���ظ�ֵ��   2.�Զ�����
		int sid = createSid();
		System.out.println("������");
		String name = sc.next();
		//��϶���
		Student stu = new Student(name, sid);
		//��ӵ�����
		slist.add(stu);
		System.out.println("��ӳɹ���");
	}

	private static int createSid() {
		// TODO Auto-generated method stub
		return 0;
	}
}
