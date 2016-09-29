package com.hpe.t11.exception;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class TestFinally {
	public static void main(String[] args) {
		//��ȡd:\\JAVA\\newfile.txt�е����ݣ��Ӵ���->�ڴ�
		//1�����ļ�����
		File f = new File("d:\\JAVA\\newfile.txt");
		FileInputStream fin = null;
		try {
			//2�����ļ�������
			fin = new FileInputStream(f);
			//3�����ڴ�ռ�
			byte[] buf = new byte[1024];
			//4��ȡ�ļ�
			int length = fin.read(buf);
			String s = new String(buf, 0, length);
			System.out.println(s);
			return;
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch(IOException e){
			e.printStackTrace();
		} finally{
			//��������finally�������۳���ִ��ʱ�Ƿ����쳣�����ն��ᱻִ��
			try {
				System.out.println("��ʹtry������return��䣬��Ҳ��ִ��~��");
				fin.close();    //�ر���
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
