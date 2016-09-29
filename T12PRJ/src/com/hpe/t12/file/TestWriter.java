package com.hpe.t12.file;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
//stream �ֽ���
//reader writer �ַ���
public class TestWriter {
	//ѧ������
	static ArrayList<Student> stulist = new ArrayList<Student>();
	public static void main(String[] args) {
		File f = new File("d:\\temp.txt");
		try {
			//����FileWriter����-�ַ������
			FileWriter fw = new FileWriter(f);
			//2�����ַ�������
			PrintWriter pw = new PrintWriter(fw);
			//д���ļ���Ϣ
			pw.println("1000,lalala,kaka,12");
			//�ر���
			pw.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		/**********���ļ�************/
		try {
			//1�����ַ�������-���ļ���������
			FileReader fr = new FileReader(f);
			//2�����ַ������������ַ�������
			BufferedReader br = new BufferedReader(fr);
			//3���ļ�
			while(true){
				String s = br.readLine();
				if(s == null){
					break;
				}else{
					putinList(s);
				}
			}
			//4�ر���
			br.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		//��������
		System.out.println("------------");
		for(Student stu: stulist){
			System.out.println(stu);
		}
	}
	
	private static void putinList(String s){
		//1���ַ���
		String[] stuStr = s.split(",");
		//2ȡ������������϶���
		int sid = Integer.parseInt(stuStr[0]);
		String name = stuStr[1];
		String sex = stuStr[2];
		int age = Integer.parseInt(stuStr[3]);
		Student stu = new Student(sid, name, sex, age);
		//3���뼯��
		stulist.add(stu);
	}
}
