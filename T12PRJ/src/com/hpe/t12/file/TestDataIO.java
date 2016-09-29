package com.hpe.t12.file;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class TestDataIO {
	public static void main(String[] args) {
		File f = new File("d:\\temp.txt");
		try {
			// ͨ���ļ����󴴽��ļ������
			FileOutputStream fileout = new FileOutputStream(f);
			DataOutputStream dataout = new DataOutputStream(fileout);
			int id = 1;
			String name = "����İ���";
			double money = 5000.0;
			dataout.writeInt(id);// д����������
			dataout.writeUTF(name);// д���ַ�������
			dataout.writeDouble(money);// д��˫��������
			dataout.writeBytes("I love you~");
			dataout.close();// �ر���
		} catch (IOException ex) {
			ex.printStackTrace();
		}
		try {
			// ͨ���ļ����󴴽���������
			FileInputStream filein = new FileInputStream(f);
			DataInputStream datain = new DataInputStream(filein);
			int id = 0;
			double money = 0;
			String name = "";
			String note = "";
			id = datain.readInt();// ��ȡ��������
			name = datain.readUTF();// ��ȡ�ַ�������
			money = datain.readDouble();// ��ȡ˫��������
			//note;
			byte[] buf = new byte[1024];
			int length = filein.read(buf);
			note = new String(buf, 0, length);
			System.out.println("�ʻ���ϢΪ��" + id + "  " + name + "  " + money + "  ���ԣ�"+note);
			datain.close();// �ر���
		} catch (IOException ex) {
			ex.printStackTrace();
		}
	}
}
