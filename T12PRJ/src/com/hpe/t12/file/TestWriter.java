package com.hpe.t12.file;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
//stream 字节流
//reader writer 字符流
public class TestWriter {
	//学生集合
	static ArrayList<Student> stulist = new ArrayList<Student>();
	public static void main(String[] args) {
		File f = new File("d:\\temp.txt");
		try {
			//创建FileWriter对象-字符输出流
			FileWriter fw = new FileWriter(f);
			//2创建字符过滤流
			PrintWriter pw = new PrintWriter(fw);
			//写入文件信息
			pw.println("1000,lalala,kaka,12");
			//关闭流
			pw.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		/**********读文件************/
		try {
			//1创建字符输入流-与文件建立关联
			FileReader fr = new FileReader(f);
			//2根据字符输入流创建字符过滤流
			BufferedReader br = new BufferedReader(fr);
			//3读文件
			while(true){
				String s = br.readLine();
				if(s == null){
					break;
				}else{
					putinList(s);
				}
			}
			//4关闭流
			br.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		//遍历集合
		System.out.println("------------");
		for(Student stu: stulist){
			System.out.println(stu);
		}
	}
	
	private static void putinList(String s){
		//1拆字符串
		String[] stuStr = s.split(",");
		//2取出输入数据组合对象
		int sid = Integer.parseInt(stuStr[0]);
		String name = stuStr[1];
		String sex = stuStr[2];
		int age = Integer.parseInt(stuStr[3]);
		Student stu = new Student(sid, name, sex, age);
		//3存入集合
		stulist.add(stu);
	}
}
