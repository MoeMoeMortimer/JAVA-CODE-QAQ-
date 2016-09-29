package com.hpe.t12.file;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class TestStringIO {
	public static void main(String[] args) {
		File f = new File("d:\\temp.txt");
		try {
			FileWriter fw = new FileWriter(f);// �����ļ��ַ�������
			String id = "1001";
			String name = "����";
			String sex = "Ů";
			int age = 20;
			Integer integerNum = new Integer(age);// ʹ�ð�װ�ཫ������������ת�����ַ���
			String strage = integerNum.toString();
			// д�ļ���FileWriter�̳���Writer������з���
			fw.write(id);
			fw.write(name);
			fw.write(sex);
			fw.write(strage);
			// �ر���
			fw.close();
		} catch (IOException ex) {
			ex.printStackTrace();
		}
		// ��ȡ�ļ�
		try {
			FileReader fr = new FileReader(f);// �����ļ��ַ�������
			// �����ַ����飬���ն�ȡ������
			char[] buf = new char[1000];
			// ��ȡ�ļ����ݵ�buf,����ʵ�����ݵĳ���
			int length = fr.read(buf);
			// ���ַ�����ת���ַ���
			String readStr = new String(buf, 0, length);
			System.out.println(readStr);
			// �ر���
			fr.close();
		} catch (IOException ex) {
			ex.printStackTrace();
		}
	}
}