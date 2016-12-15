package com.cs.service.student;

import com.cs.pojo.Student;

public interface StudentService {

	Student stuLogin(Student stu);
	
	Student selectByNo(int studentNo);
}
