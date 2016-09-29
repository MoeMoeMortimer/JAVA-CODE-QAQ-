package com.hpe.t12.file;


import java.io.File;
import java.io.DataOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class TestDataStream {
	public static void main(String[] args) {
		File f = new File("d:\\JAVA\\temp.txt");
		try {
			//1创建字节流
			FileOutputStream fout = new FileOutputStream(f);
			//2根据字节流创建字节过滤流
			DataOutputStream dout = new DataOutputStream(fout);
			//3写基本数据
			dout.writeInt(123456);
			dout.writeBytes("I love you 1314");
			dout.writeUTF("垂杨紫陌洛城东");
			//4关闭
			dout.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
	}
}
