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
			// 通过文件对象创建文件输出流
			FileOutputStream fileout = new FileOutputStream(f);
			DataOutputStream dataout = new DataOutputStream(fileout);
			int id = 1;
			String name = "爱你的阿花";
			double money = 5000.0;
			dataout.writeInt(id);// 写入整型数据
			dataout.writeUTF(name);// 写入字符型数据
			dataout.writeDouble(money);// 写入双精度数据
			dataout.writeBytes("I love you~");
			dataout.close();// 关闭流
		} catch (IOException ex) {
			ex.printStackTrace();
		}
		try {
			// 通过文件对象创建文输入流
			FileInputStream filein = new FileInputStream(f);
			DataInputStream datain = new DataInputStream(filein);
			int id = 0;
			double money = 0;
			String name = "";
			String note = "";
			id = datain.readInt();// 读取整型数据
			name = datain.readUTF();// 读取字符串数据
			money = datain.readDouble();// 读取双精度数据
			//note;
			byte[] buf = new byte[1024];
			int length = filein.read(buf);
			note = new String(buf, 0, length);
			System.out.println("帐户信息为：" + id + "  " + name + "  " + money + "  留言："+note);
			datain.close();// 关闭流
		} catch (IOException ex) {
			ex.printStackTrace();
		}
	}
}
