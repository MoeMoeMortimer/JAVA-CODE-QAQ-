package com.hpe.jdbc.po;

import java.lang.reflect.Field;

public class Test {
	public static void main(String[] args) {
		//通过传递类的class对象创建的对象并用当前类型进行转换
		Product obj = (Product) getObject(Product.class);
		System.out.println(obj instanceof Product);
	}
	/**
	 * 返回指定类型产生的对象
	 * @return
	 */
	public static Object getObject(Class clazz) {
		//获取到某类的class信息就可以获取到该类的属性和方法信息
		//根据属性或方法信息返回该类的具体实例对象
		//工厂模式
		//获取属性
		Field[] fs = clazz.getFields();
		System.out.println("属性1："+fs[0].toString());
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
