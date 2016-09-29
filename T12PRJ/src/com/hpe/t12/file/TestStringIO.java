package com.hpe.t12.file;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class TestStringIO {
	public static void main(String[] args) {
		File f = new File("d:\\temp.txt");
		try {
			FileWriter fw = new FileWriter(f);// 创建文件字符流对象
			String id = "1001";
			String name = "阿花";
			String sex = "女";
			int age = 20;
			Integer integerNum = new Integer(age);// 使用包装类将基本数据类型转化成字符串
			String strage = integerNum.toString();
			// 写文件，FileWriter继承了Writer类的所有方法
			fw.write(id);
			fw.write(name);
			fw.write(sex);
			fw.write(strage);
			// 关闭流
			fw.close();
		} catch (IOException ex) {
			ex.printStackTrace();
		}
		// 读取文件
		try {
			FileReader fr = new FileReader(f);// 创建文件字符流对象
			// 创建字符数组，接收读取的数据
			char[] buf = new char[1000];
			// 读取文件内容到buf,返回实际数据的长度
			int length = fr.read(buf);
			// 将字符数组转成字符串
			String readStr = new String(buf, 0, length);
			System.out.println(readStr);
			// 关闭流
			fr.close();
		} catch (IOException ex) {
			ex.printStackTrace();
		}
	}
}