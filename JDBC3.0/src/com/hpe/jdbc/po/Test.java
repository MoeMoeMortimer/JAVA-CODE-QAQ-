package com.hpe.jdbc.po;

import java.lang.reflect.Field;

public class Test {
	public static void main(String[] args) {
		//ͨ���������class���󴴽��Ķ����õ�ǰ���ͽ���ת��
		Product obj = (Product) getObject(Product.class);
		System.out.println(obj instanceof Product);
	}
	/**
	 * ����ָ�����Ͳ����Ķ���
	 * @return
	 */
	public static Object getObject(Class clazz) {
		//��ȡ��ĳ���class��Ϣ�Ϳ��Ի�ȡ����������Ժͷ�����Ϣ
		//�������Ի򷽷���Ϣ���ظ���ľ���ʵ������
		//����ģʽ
		//��ȡ����
		Field[] fs = clazz.getFields();
		System.out.println("����1��"+fs[0].toString());
		Object obj = null;
		try {
			return clazz.newInstance();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e){
		}
		return obj;
	}
	
}
