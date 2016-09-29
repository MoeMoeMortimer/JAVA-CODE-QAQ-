package com.hpe.t12.file;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class TestByte {
	public static void main(String[] args) {
		//�����ֽ�����
		String message = null;
		//����File����,f������C:\\T12File\\temp.txt��������
		File fsrc = new File("C:\\T12File\\temp.txt");
		if(fsrc.exists() == false){
			//����һ�����ļ�
			try {
				fsrc.createNewFile();
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		
		//д�ļ�-�ֽ���
		try {
			//1�����ֽ�������
			FileOutputStream fout = new FileOutputStream(fsrc);
			//2д���ļ�
			  //2.1׼���ֽ����� 
			  String s = "I love you";
			  //���ַ���ת���ֽ�
			  byte[] buf = s.getBytes();
			  //2.2 д���ļ�
			  fout.write(buf);
			//3�ر���
			  fout.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		//���ļ����Ӵ��̶����ڴ�
		try {
			//����������
			FileInputStream fin = new FileInputStream(fsrc);
			//2��ȡ�ļ�
			  //2.1 ׼���ֽڿռ䣨1KB��
			  byte[] buf = new byte[1024];
			  //2.2��ȡ��ͨ�������ļ����ݶ���ָ���ֽ������У����ض�ȡ���ֽ�����
			  int length = fin.read(buf);
			  //��ӡ�����ֽ�ת���ַ���
			  message = new String(buf, 0, length);
			  System.out.println(message);
			  //�ر���
			  fin.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		//����File����,f������d:\\temp.txt��������
		File fend = new File("d:\\temp.txt");
		if(fend.exists() == false){
			//����һ�����ļ�
			try {
				fend.createNewFile();
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		try {
			//1�����ֽ�������
			FileOutputStream fout = new FileOutputStream(fend);
			//2д���ļ�
			  //2.1׼���ֽ�����
			  //���ַ���ת���ֽ�
			  byte[] buf = message.getBytes();
			  //2.2 д���ļ�
			  fout.write(buf);
			//3�ر���
			  fout.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		//���ļ����Ӵ��̶����ڴ�
		try {
			//����������
			FileInputStream fin = new FileInputStream(fend);
			//2��ȡ�ļ�
			//2.1 ׼���ֽڿռ䣨1KB��
				byte[] buf = new byte[1024];
				//2.2��ȡ��ͨ�������ļ����ݶ���ָ���ֽ������У����ض�ȡ���ֽ�����
				int length = fin.read(buf);
				//��ӡ�����ֽ�ת���ַ���
				String dst = new String(buf, 0, length);
				System.out.println(dst);
				//�ر���
				fin.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
	}
}
