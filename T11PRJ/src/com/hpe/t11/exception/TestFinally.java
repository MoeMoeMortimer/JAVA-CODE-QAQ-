package com.hpe.t11.exception;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class TestFinally {
	public static void main(String[] args) {
		//读取d:\\JAVA\\newfile.txt中的内容：从磁盘->内存
		//1创建文件对象
		File f = new File("d:\\JAVA\\newfile.txt");
		FileInputStream fin = null;
		try {
			//2创建文件输入流
			fin = new FileInputStream(f);
			//3创建内存空间
			byte[] buf = new byte[1024];
			//4读取文件
			int length = fin.read(buf);
			String s = new String(buf, 0, length);
			System.out.println(s);
			return;
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch(IOException e){
			e.printStackTrace();
		} finally{
			//清理工作，finally语句块无论程序执行时是否发生异常，最终都会被执行
			try {
				System.out.println("即使try块中有return语句，我也会执行~！");
				fin.close();    //关闭流
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
