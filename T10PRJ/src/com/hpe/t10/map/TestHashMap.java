package com.hpe.t10.map;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import com.hoe.t10.po.Student;

public class TestHashMap {
	public static void main(String[] args) {
		// ����һ��map����
		HashMap<String, Student> stumap = new HashMap<String, Student>();

		// ���
		stumap.put("zhangsan", new Student("����", 2));
		stumap.put("zhangsan", new Student("����", 7));
		stumap.put("zhangsan", new Student("����", 1));
		stumap.put("zhangsan", new Student("����", 1));
		stumap.put("lisi", new Student("����", 2));
		stumap.put("wangwu", new Student("����", 3));
		Student stu1 = stumap.get("lisi");
		System.out.println(stu1);

		// �Ƴ�
		stumap.remove("lisi");
		System.out.println(stumap.size());

		// ����
		// 1ͨ������������������
		Set<String> keyset = stumap.keySet();
		for (String s : keyset) {
			System.out.println(s + ":" + stumap.get(s));
		}
		// 2ͨ������ӳ���ϵ��������
		Set entset = stumap.entrySet();
		Iterator it = entset.iterator();
		while (it.hasNext()) {
			Map.Entry ent = (Map.Entry) it.next();
			System.out.println(ent.getKey() + ":" + ent.getValue());
		}
	}
}
