package com.hpe.t10.list;

import java.util.ArrayList;

import java.util.Iterator;

import com.hoe.t10.po.Student;

public class TestArrayList {	
	public static void main(String[] args) {
		//���켯��
		ArrayList list1 = new ArrayList();
		list1.add(1);
		list1.add("good");
		list1.add(3.14);
		
		int i = (int)list1.get(0);
		String s1 = (String)list1.get(1);
		//˵����ͨ��ԭʼ���췽�������ļ��ϣ�����洢�������͵Ķ���
		//���Ѷ�����ӵ����Ϻ󣬶����Զ�ת��Object����
		//��ô���Ӽ�����ȡ����ʱ��Ҫ����ǿ������ת��
		//jdk5��Լ��������˷��ʹ���Ҳ����ָ�����ϵĴ洢����
		
		/************************************************/
		
		ArrayList<String> list2 = new ArrayList<String>();
		
		list2.add("qwer");
		String s2 = list2.get(0);
		
		/************************************************/
		
		ArrayList<Student> list3 = new ArrayList<Student>();
		//���
		list3.add(new Student("����",1));
		list3.add(new Student("������",2));
		list3.add(new Student("������Ʊ",3));
		list3.add(new Student("���ض�ֽ",4));
		list3.add(new Student("hentai��",5));
		//��ȡ����һ��Ԫ��
		Student stu1 = list3.get(2);
		System.out.println(stu1);
		//ɾ��
		list3.remove(1);
		Student stu2 = list3.get(1);
		System.out.println(stu2);
		//����
		System.out.println(list3);
		//����һ��ͨ������
		for(int k =  0; k < list3.size();k++){
			System.out.println(list3.get(k));
		}
		//��������ʹ�õ������������鳮����
		Iterator<Student> it = list3.iterator();
		while(it.hasNext()){
			System.out.println(it.next());
		}
		//JDK5֮�������˱�����������ǿ��forѭ����forEachѭ�� 
		for(Student stu : list3){
			System.out.println(stu);
		}
	}
}
