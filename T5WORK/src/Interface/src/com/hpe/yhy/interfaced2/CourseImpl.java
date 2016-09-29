package com.hpe.yhy.interfaced2;

public class CourseImpl implements CourseDao {
StudentsDao stu;
	@Override
	public void addCourse() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deletCourse() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateCourse() {
		// TODO Auto-generated method stub
		stu.addStu();//可以调用没有实现的方法
	}

}
