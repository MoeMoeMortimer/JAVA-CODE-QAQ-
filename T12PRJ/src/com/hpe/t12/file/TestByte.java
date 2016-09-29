package com.hpe.t12.file;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class TestByte {
	public static void main(String[] args) {
		//创建字节数据
		String message = null;
		//创建File对象,f对象与C:\\T12File\\temp.txt建立关联
		File fsrc = new File("C:\\T12File\\temp.txt");
		if(fsrc.exists() == false){
			//创建一个新文件
			try {
				fsrc.createNewFile();
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		
		//写文件-字节流
		try {
			//1创建字节流对象
			FileOutputStream fout = new FileOutputStream(fsrc);
			//2写入文件
			  //2.1准备字节数据 
			  String s = "I love you";
			  //将字符串转成字节
			  byte[] buf = s.getBytes();
			  //2.2 写入文件
			  fout.write(buf);
			//3关闭流
			  fout.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		//读文件，从磁盘读到内存
		try {
			//创建输入流
			FileInputStream fin = new FileInputStream(fsrc);
			//2读取文件
			  //2.1 准备字节空间（1KB）
			  byte[] buf = new byte[1024];
			  //2.2读取（通过流将文件数据读到指定字节数组中，返回读取的字节数）
			  int length = fin.read(buf);
			  //打印：将字节转成字符串
			  message = new String(buf, 0, length);
			  System.out.println(message);
			  //关闭流
			  fin.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		//创建File对象,f对象与d:\\temp.txt建立关联
		File fend = new File("d:\\temp.txt");
		if(fend.exists() == false){
			//创建一个新文件
			try {
				fend.createNewFile();
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		try {
			//1创建字节流对象
			FileOutputStream fout = new FileOutputStream(fend);
			//2写入文件
			  //2.1准备字节数据
			  //将字符串转成字节
			  byte[] buf = message.getBytes();
			  //2.2 写入文件
			  fout.write(buf);
			//3关闭流
			  fout.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		//读文件，从磁盘读到内存
		try {
			//创建输入流
			FileInputStream fin = new FileInputStream(fend);
			//2读取文件
			//2.1 准备字节空间（1KB）
				byte[] buf = new byte[1024];
				//2.2读取（通过流将文件数据读到指定字节数组中，返回读取的字节数）
				int length = fin.read(buf);
				//打印：将字节转成字符串
				String dst = new String(buf, 0, length);
				System.out.println(dst);
				//关闭流
				fin.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
	}
}
