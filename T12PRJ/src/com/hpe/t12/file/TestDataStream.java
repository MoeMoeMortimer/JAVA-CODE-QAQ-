package com.hpe.t12.file;


import java.io.File;
import java.io.DataOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class TestDataStream {
	public static void main(String[] args) {
		File f = new File("d:\\JAVA\\temp.txt");
		try {
			//1�����ֽ���
			FileOutputStream fout = new FileOutputStream(f);
			//2�����ֽ��������ֽڹ�����
			DataOutputStream dout = new DataOutputStream(fout);
			//3д��������
			dout.writeInt(123456);
			dout.writeBytes("I love you 1314");
			dout.writeUTF("������İ��Ƕ�");
			//4�ر�
			dout.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
	}
}
