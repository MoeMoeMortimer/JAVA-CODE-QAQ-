package com.hpe.t11.exception;

import java.io.File;
import java.io.IOException;

public class TextException {
	public static int devide(int dividend, int divisor) throws Exception {
		// 取整运算，dividend被除数, divisor除数
		if (divisor == 0) {
			return 0;
		}
		int result = dividend / divisor;

		return result;
	}

	public static void main(String[] args) {
		System.out.println("程序开始运行");
		int result = 0;
		try {
			// 把可能产生异常的代码放在一起，然后用多个catch来捕获
			result = devide(3, 0);
			File f = new File("d:\\JAVA\\newfile.txt");
			if (!f.exists()) {
				// 创建新文件
				f.createNewFile();
			}
		} catch (IOException e) {
			e.printStackTrace(); // 打印异常栈信息
		} catch (Exception e) {
			e.printStackTrace();
		}

		System.out.println("运算结果为：" + result);
		System.out.println("程序运行结束");
		

	}
}
	try{
		
		}catch(Exception e){
			
		}
