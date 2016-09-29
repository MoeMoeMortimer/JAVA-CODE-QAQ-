package com.hpe.jdbc.view;

import java.math.BigDecimal;
import java.util.List;
import java.util.Scanner;

import com.hpe.jdbc.biz.ProductBizImpl;
import com.hpe.jdbc.po.Product;

public class ProductManager {
	//����ҵ��ʵ��
	static ProductBizImpl pbiz = new ProductBizImpl();
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
		System.out.println("------------ ������Ʒ ------------");
		System.out.println("��Ʒ��ţ�");
		Integer proid = sc.nextInt();
		System.out.println("��Ʒ���ƣ�");
		String proname = sc.next();
		System.out.println("��Ʒ�ͺţ�");
		String type = sc.next();
		Integer storecount = 0;
		System.out.println("���鹺���:");
		BigDecimal sugpurchase = sc.nextBigDecimal();
		System.out.println("�������ۼۣ�");
		BigDecimal sugsell = sc.nextBigDecimal();
		//��϶���
		Product p = new Product(proid,proname,type,storecount,sugpurchase,sugsell);
		//�������ݷ�����
		boolean result = pbiz.add(p);
		if(result){
			System.out.println("��ӳɹ���");
		}else{
			System.out.println("���ʧ�ܣ�");
		}
		
	}
	private static void delete() {
		System.out.println("------------ ɾ����Ʒ ------------");
		System.out.println("��Ʒ��ţ�");
		int proid = sc.nextInt();
		//��ѯ
		Product p = pbiz.findByID(proid);
		if(p == null){
			System.out.println("û�и���Ʒ��Ϣ");
			return ;
		}
		//��ӡ��Ʒ��Ϣ
		System.out.println(p);
		System.out.println("��ȷ��Ҫɾ���� 1��   0��");
		int answer = sc.nextInt();
		if(answer == 1){
			//�������ݷ�����
			boolean result = pbiz.delete(proid);
			if(result){
				System.out.println("ɾ���ɹ���");
			}else{
				System.out.println("ɾ��ʧ�ܣ�");
			}
		}
	}
	private static void update() {
		System.out.println("------------ �޸���Ʒ ------------");
		System.out.println("������Ҫ�޸ĵ���Ʒ��ţ�");
		int proid = sc.nextInt();
		//��ѯ
		Product p = pbiz.findByID(proid);
		if(p == null){
			System.out.println("û�и���Ʒ��Ϣ");
			return ;
		}
		//��ӡ��Ʒ��Ϣ
		System.out.println(p);
		//ִ���޸�
		System.out.println("��Ʒ���ƣ�");
		String proname = sc.next();
		System.out.println("��Ʒ�ͺţ�");
		String type = sc.next();
		Integer storecount = 0;
		System.out.println("���鹺���:");
		BigDecimal sugpurchase = sc.nextBigDecimal();
		System.out.println("�������ۼۣ�");
		BigDecimal sugsell = sc.nextBigDecimal();
		p.setProname(proname);
		p.setType(type);
		p.setStorecount(storecount);
		p.setSugpurchase(sugpurchase);
		p.setSugsell(sugsell);
		//�������ݷ�����
		boolean result = pbiz.update(p);
		if(result){
			System.out.println("�޸ĳɹ���");
		}else{
			System.out.println("�޸�ʧ�ܣ�");
		}
	}
	private static void findByID() {
		System.out.println("------------ ���ݱ�Ų�����Ʒ ------------");
		System.out.println("������Ҫ���ҵ���Ʒ��ţ�");
		int proid = sc.nextInt();
		//��ѯ
		Product p = pbiz.findByID(proid);
		if(p == null){
			System.out.println("û�и���Ʒ��Ϣ");
			return ;
		}
		//��ӡ��Ʒ��Ϣ
		System.out.println(p);
		
	}
	private static void findAll() {
		System.out.println("------------ ��ѯ���� -----------");
		List<Product> list = pbiz.findAll();
		for(Product p : list){
			System.out.println(p);
		}
	}

	private static void findByCondition() {
		System.out.println("----------- ģ����ѯ -----------");
		System.out.println("��������Ʒ���ƻ��ͺŹؼ��֣�");
		String condition = sc.next();
		List<Product> list = pbiz.findByCondition(condition);
		if(list.size() == 0){
			System.out.println("û�в�ѯ����Ϣ");
		}else{
			for(Product p : list){
				System.out.println(p);
			}
		}
	}
}
