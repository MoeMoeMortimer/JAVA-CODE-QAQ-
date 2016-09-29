package com.hpe.jdbc.view;
import java.util.List;
import java.util.Scanner;

import com.hpe.jdbc.dao.CustomerDao;
import com.hpe.jdbc.dao.CustomerDaoImpl;
import com.hpe.jdbc.po.Customer;

public class CustomerManager {
	//�������ݷ��ʶ���
	static CustomerDao pdao = new CustomerDaoImpl();
	static Scanner sc = new Scanner(System.in);
	public static void main(String[] args) {
		while(true){
			System.out.println("1����  2ɾ��  3�޸�  4���ݱ�Ų���  5��������  6ģ����ѯ  0�˳�");
			int select = sc.nextInt();
			switch(select){
			case 1:add();break;
			case 2:delete();break;
			case 3:update();break;
			case 4:findByID();break;
			case 5:findAll();break;
			case 6:findByCondition();break;
			case 0:System.exit(0);
			default:System.out.println("����ѡ������");
			}
		}
	}
	private static void add() {
		System.out.println("------------ ���ӿͻ� ------------");
		System.out.println("�ͻ���ţ�");
		Integer cusid = sc.nextInt();
		System.out.println("�ͻ����ƣ�");
		String cusname = sc.next();
		System.out.println("�ͻ��绰��");
		String custel = sc.next();
		System.out.println("�ͻ���ַ��");
		String cusaddr = sc.next();
		//��϶���
		Customer p = new Customer(cusid,cusname,custel,cusaddr);
		//�������ݷ�����
		int result = pdao.add(p);
		if(result > 0){
			System.out.println("��ӳɹ���");
		}else{
			System.out.println("���ʧ�ܣ�");
		}
		
	}
	private static void delete() {
		System.out.println("------------ ɾ���ͻ� ------------");
		System.out.println("�ͻ���ţ�");
		int cusid = sc.nextInt();
		//��ѯ
		Customer p = pdao.findByID(cusid);
		if(p == null){
			System.out.println("û�иÿͻ���Ϣ");
			return ;
		}
		//��ӡ�ͻ���Ϣ
		System.out.println(p);
		System.out.println("��ȷ��Ҫɾ���� 1��   0��");
		int answer = sc.nextInt();
		if(answer == 1){
			//�������ݷ�����
			int result = pdao.delete(cusid);
			if(result > 0){
				System.out.println("ɾ���ɹ���");
			}else{
				System.out.println("ɾ��ʧ�ܣ�");
			}
		}
	}
	private static void update() {
		System.out.println("------------ �޸Ŀͻ���Ϣ ------------");
		System.out.println("������Ҫ�޸ĵĿͻ���ţ�");
		int cusid = sc.nextInt();
		//��ѯ
		Customer p = pdao.findByID(cusid);
		if(p == null){
			System.out.println("û�и���Ʒ��Ϣ");
			return ;
		}
		//��ӡ��Ʒ��Ϣ
		System.out.println(p);
		//ִ���޸�
		System.out.println("�ͻ����ƣ�");
		String cusname = sc.next();
		System.out.println("�ͻ��绰��");
		String custel = sc.next();
		System.out.println("�ͻ���ַ��");
		String cusaddr = sc.next();
		p.setCusname(cusname);
		p.setCustel(custel);
		p.setCusaddr(cusaddr);
		//�������ݷ�����
		int result = pdao.update(p);
		if(result > 0){
			System.out.println("�޸ĳɹ���");
		}else{
			System.out.println("�޸�ʧ�ܣ�");
		}
	}
	private static void findByID() {
		System.out.println("------------ ���ݱ�Ų��ҿͻ� ------------");
		System.out.println("������Ҫ���ҵĿͻ���ţ�");
		int cusid = sc.nextInt();
		//��ѯ
		Customer p = pdao.findByID(cusid);
		if(p == null){
			System.out.println("û�иÿͻ���Ϣ");
			return ;
		}
		//��ӡ�ͻ���Ϣ
		System.out.println(p);
		
	}
	private static void findAll() {
		System.out.println("------------ ��ѯ���� -----------");
		List<Customer> list = pdao.findAll();
		for(Customer p : list){
			System.out.println(p);
		}
	}
	private static void findByCondition() {
		System.out.println("----------- ģ����ѯ -----------");
		System.out.println("������ͻ����ƻ�绰����ַ�ؼ��֣�");
		String condition = sc.next();
		List<Customer> list = pdao.findByCondition(condition);
		if(list.size() == 0){
			System.out.println("û�в�ѯ����Ϣ");
		}else{
			for(Customer p : list){
				System.out.println(p);
			}
		}
	}
}
