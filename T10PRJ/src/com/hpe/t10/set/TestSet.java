package com.hpe.t10.set;
import com.hoe.t10.po.Student;
import java.util.HashSet;

public class TestSet {
	public static void main(String[] args) {
		String s1 = "张三";
		String s2 = "张三";
		System.out.println(s1.hashCode()+","+s2.hashCode());
		HashSet<Student> set2 = new HashSet<Student> ();
		set2.add(new Student("张三",1));
		set2.add(new Student("张三",1));
		set2.add(new Student("张三",1));
		for(Student stu: set2){
			System.out.println(stu);
		}
	}
}
