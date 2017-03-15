package com.cs.service.student;

import java.util.List;

import org.springframework.stereotype.Service;

import com.cs.pojo.Awards;
import com.cs.pojo.Student;


@Service("studentService")
public class StudentServiceImpl implements StudentService {

	@Override
	public Student stuLogin(Student stu) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Student selectByNo(int studentNo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Awards> selectAwardsByStudentNo(Integer studentNo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Student selectMaterialByNo(Integer studentNo) {
		// TODO Auto-generated method stub
		return null;
	}
	
}
