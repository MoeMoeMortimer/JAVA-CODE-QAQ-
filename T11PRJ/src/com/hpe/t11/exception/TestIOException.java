package com.hpe.t11.exception;

import java.io.File;
import java.io.IOException;

public class TestIOException {
	public static void main(String[] args) throws IOException {
		System.out.println("����ʼ����");
		File f = new File("d:\\JAVA\\newfile.txt");
		if(!f.exists()){
			//�������ļ�
			f.createNewFile();
		}
		System.out.println("�������н���");
	}
}
