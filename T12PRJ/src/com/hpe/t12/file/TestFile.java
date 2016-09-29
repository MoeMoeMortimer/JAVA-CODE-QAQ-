package com.hpe.t12.file;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TestFile {
	public static void main(String[] args) {
		//创建File对象,f对象与d:\\JAVA\\temp.txt建立关联
		File f = new File("d:\\JAVA\\temp.txt");
		System.out.println(f.exists());
		if(f.exists() == false){
			//创建一个新文件
			try {
				f.createNewFile();
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
			//通过f对象查看文件信息或设置文件属性
			System.out.println("绝对路径"+f.getAbsolutePath());
			System.out.println("文件名称"+f.getName());
			System.out.println("文件大小"+f.length());
			long time = f.lastModified();//毫秒值
			Date lastModifiedTime = new Date(time);
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日,HH:mm:ss");
			System.out.println("创建（修改）时间"+sdf.format(lastModifiedTime));
			System.out.println("是否可读"+f.canRead());
			System.out.println("是否可写"+f.canWrite());
			System.out.println("是否隐藏"+f.isHidden());
			//但对象没有读写文件的方法，需要流
		}
		
	}
}
