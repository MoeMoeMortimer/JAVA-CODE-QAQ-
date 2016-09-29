package com.hpe.t10.card;

import java.util.Scanner;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class CardManager {
	//���п�������Ϣ
	static ArrayList<Card> cards = new ArrayList<Card>();
	//������Ϣ����ԭ��ά����ת��ΪArrayList�����е�һά�洢���п���ţ����������ڶ�ά�洢������Ϣ
	static ArrayList<Trade[]> trade = new ArrayList<Trade[]>();
	static int ptr = -1;
	static int lastid = 1001;
	static int iniId = 0001; 
	static int index = -1;
	static Scanner sc = new Scanner(System.in);
	public static void main(String[] args) {
		while(true){
			System.out.println("----------- ���п�����ϵͳ -----------");
			System.out.println("��ӭ������ѡ��  1����         2��½      0�˳�");
			int select = sc.nextInt();
			if(select == 0)System.exit(0);
			else if(select == 1)add();
			else {
				login();
				while((index != -1)&&(cards.get(index).isState() == true)){
					Menu();
					int choice = sc.nextInt();
					// 1���޸�����  2��ѯ�˻���Ϣ  3��� 4ȡ��  5 ��ѯ������Ϣ
					switch(choice){
					case 1: Change();break;
					case 2: find();break;
					case 3: deposit();break;
					case 4: debit();break;
					case 5: history();break;
					case 6: index = -1;break;
					default:
						System.out.println("��Ч���������������롣");
					}
				}
			}	
		}	
	}
	private static void history(){
		for(int i = 0; i < trade.get(index).length; i++)
			System.out.println(trade.get(index)[i]);
	}		
	//������Ϣ
	
	private static void Change() {
		while(true){
			System.out.println("������ԭ���룺");
			String p1 = sc.next();
			if(p1.equals(cards.get(index).getPassword()))break;
			else 
				System.out.println("��������������������룡");
		}
		while(true){
			System.out.println("�����������룺");
			String p2 = sc.next();
			System.out.println("����ȷ�������룺");
			String p3 = sc.next();
			if(p3.equals(p2)){
				System.out.println("�����޸ĳɹ���");
				cards.get(index).setPassword(p3);
				break;
			}	
			else 
				System.out.println("�����������벻һ�£��޸�ʧ�ܣ�");
		}	
	}
	//���
	private static void deposit(){
		System.out.println("���������");
		double money = sc.nextDouble();
		cards.get(index).setBalance(cards.get(index).getBalance() + money);
		System.out.println("���ɹ������Ϊ" + cards.get(index).getBalance() + "Ԫ��");
		String tradeid = "1900"+(iniId++);
		String type = "���";
		String time = getNow();
		Trade tra = new Trade(tradeid, cards.get(index).getCardid(), money, type, time);
		trade.get(index). = tra;	
		}	
	

	private static void debit() {
		System.out.println("������ȡ���");
		double money = sc.nextDouble();
		if(money > cards[index].getBalance()){
			System.out.println("���㣬ȡ��ʧ�ܡ�");
		}else{
			cards[index].setBalance(cards[index].getBalance() - money);
			System.out.println("ȡ��ɹ������Ϊ" + cards[index].getBalance() + "Ԫ��");
			String tradeid = "1900"+(iniId++);
			String type = "ȡ��";
			String time = getNow();
			Trade tra = new Trade(tradeid, cards[index].getCardid(), money, type, time);
			trades[index][ct[index]++] = tra;
		}
		
	}
	
	
	private static void login() {
		int n = 3,flag = 0;
		String cid, password;
		while(index == -1){
			System.out.println("�����뿨��:");
			cid = sc.next();
			index = findById(cid);
			if(index == -1)
				System.out.println("�ÿ��Ų����ڣ�");
		}
		while(n != 0){
			System.out.println("���������룺");
			password = sc.next();
			if(password.equals(cards[index].getPassword())){
				System.out.println("��½�ɹ�");
				cards[index].setState(true);
				flag = 1;
				break;
			}
			n--;
			System.out.print("��½ʧ�ܣ�");
			if(n>0)System.out.println("������"+n+"���������");
			else{
				System.out.println("�������������࣬�˺�������");
				cards[index].setState(false);
				index = -1;
			}
		}
		if(flag == 1)System.out.println("��ӭ��½�������У�");
	}
	private static void add() {
		System.out.print("������");
		System.out.println("������");
		String name = sc.next();
		System.out.println("���֤�ţ�");
		String uid = sc.next();
		System.out.println("�ֻ��ţ�");
		String phone = sc.next();
		String cid = "20338765437";//���п�������ǰ׺
		cid = cid+(lastid++);
		String password = "999999";
		System.out.println("�˻�����" + getNow() +"��ͨ�ɹ������Ŀ���Ϊ" + cid +",Ĭ������Ϊ999999");
		System.out.println("�������ÿ�����");
		double balance = sc.nextDouble();
		Card c = new Card(cid, password, name, uid, phone, balance, false);
		ptr++;
		cards[ptr] = c;
	}
	//��ѯ�˻���Ϣ
	private static void find() {
		System.out.println("�˻���Ϣ���£�");
		System.out.println(cards[index]);
	}
	
	//�˵���
	private static void Menu() {
		System.out.println("--------------- ���п�����ϵͳ ---------------");
		System.out.println("1�޸�����  2��ѯ�˻���Ϣ  3���  4ȡ��  5 ��ѯ������Ϣ  6�˳�");
		System.out.println("��ѡ��ҵ��");
		
	}
	
	//ҵ��������
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
	
	//�Զ����ɿ���
	public int createCardID(){
		if(ptr == -1){
			return 1000;
		}else{
			String lastCardid = cards[ptr].getCardid();
			//��ȡ����λ
			lastCardid = lastCardid.substring(12,16);
			//���ַ�������ת������
			int cardid = Integer.parseInt(lastCardid);
			return cardid++;
		}
	}
	
	//��ȡ��ǰʱ��
	public static String getNow() {
		Date now = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:MM:ss");
		return sdf.format(now);
	}
}

