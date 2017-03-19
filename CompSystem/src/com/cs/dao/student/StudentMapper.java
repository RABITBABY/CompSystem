package com.cs.dao.student;

import com.cs.pojo.Student;

public interface StudentMapper {
	
	//查看学生个人信息
	Student selectByPrimaryKey(Integer studentno);
	//修改学生个人信息
	int updateByPrimaryKeySelective(Student record);
	
}