package com.hpe.t11.exception;

import java.io.File;
import java.io.IOException;

public class TextException {
	public static int devide(int dividend, int divisor) throws Exception {
		// ȡ�����㣬dividend������, divisor����
		if (divisor == 0) {
			return 0;
		}
		int result = dividend / divisor;

		return result;
	}

	public static void main(String[] args) {
		System.out.println("����ʼ����");
		int result = 0;
		try {
			// �ѿ��ܲ����쳣�Ĵ������һ��Ȼ���ö��catch������
			result = devide(3, 0);
			File f = new File("d:\\JAVA\\newfile.txt");
			if (!f.exists()) {
				// �������ļ�
				f.createNewFile();
			}
		} catch (IOException e) {
			e.printStackTrace(); // ��ӡ�쳣ջ��Ϣ
		} catch (Exception e) {
			e.printStackTrace();
		}

		System.out.println("������Ϊ��" + result);
		System.out.println("�������н���");
		

	}
}
	try{
		
		}catch(Exception e){
			
		}
