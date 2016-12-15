package com.cs.service.student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cs.dao.student.StudentMapper;
import com.cs.pojo.Student;
@Service
public class StudentServiceImpl implements StudentService {
	@Autowired
	StudentMapper mapper;

	@Override
	public Student stuLogin(Student stu) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Student selectByNo(int studentNo) {
		return mapper.selectByID(studentNo);
	}

}
