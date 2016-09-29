package com.hpe.t12.file;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TestFile {
	public static void main(String[] args) {
		//����File����,f������d:\\JAVA\\temp.txt��������
		File f = new File("d:\\JAVA\\temp.txt");
		System.out.println(f.exists());
		if(f.exists() == false){
			//����һ�����ļ�
			try {
				f.createNewFile();
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
			//ͨ��f����鿴�ļ���Ϣ�������ļ�����
			System.out.println("����·��"+f.getAbsolutePath());
			System.out.println("�ļ�����"+f.getName());
			System.out.println("�ļ���С"+f.length());
			long time = f.lastModified();//����ֵ
			Date lastModifiedTime = new Date(time);
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy��MM��dd��,HH:mm:ss");
			System.out.println("�������޸ģ�ʱ��"+sdf.format(lastModifiedTime));
			System.out.println("�Ƿ�ɶ�"+f.canRead());
			System.out.println("�Ƿ��д"+f.canWrite());
			System.out.println("�Ƿ�����"+f.isHidden());
			//������û�ж�д�ļ��ķ�������Ҫ��
		}
		
	}
}
