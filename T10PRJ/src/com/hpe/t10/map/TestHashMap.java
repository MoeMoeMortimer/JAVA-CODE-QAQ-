package com.hpe.t10.map;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import com.hoe.t10.po.Student;

public class TestHashMap {
	public static void main(String[] args) {
		// 创建一个map集合
		HashMap<String, Student> stumap = new HashMap<String, Student>();

		// 添加
		stumap.put("zhangsan", new Student("张三", 2));
		stumap.put("zhangsan", new Student("张三", 7));
		stumap.put("zhangsan", new Student("张三", 1));
		stumap.put("zhangsan", new Student("张三", 1));
		stumap.put("lisi", new Student("李四", 2));
		stumap.put("wangwu", new Student("王五", 3));
		Student stu1 = stumap.get("lisi");
		System.out.println(stu1);

		// 移除
		stumap.remove("lisi");
		System.out.println(stumap.size());

		// 遍历
		// 1通过遍历键来遍历集合
		Set<String> keyset = stumap.keySet();
		for (String s : keyset) {
			System.out.println(s + ":" + stumap.get(s));
		}
		// 2通过遍历映射关系遍历集合
		Set entset = stumap.entrySet();
		Iterator it = entset.iterator();
		while (it.hasNext()) {
			Map.Entry ent = (Map.Entry) it.next();
			System.out.println(ent.getKey() + ":" + ent.getValue());
		}
	}
}
