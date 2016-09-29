package com.hpe.t11.exception;

import java.io.File;
import java.io.IOException;

public class TestIOException {
	public static void main(String[] args) throws IOException {
		System.out.println("程序开始运行");
		File f = new File("d:\\JAVA\\newfile.txt");
		if(!f.exists()){
			//创建新文件
			f.createNewFile();
		}
		System.out.println("程序运行结束");
	}
}
