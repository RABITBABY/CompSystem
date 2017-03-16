package com.cs.service.student;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cs.dao.student.StudentMapper;
import com.cs.pojo.Awards;
import com.cs.pojo.Student;


@Service("studentService")
public class StudentServiceImpl implements StudentService {

	@Autowired
	private StudentMapper studentMapper;
	@Override
	public Student stuLogin(Student stu) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Student selectByNo(int studentno) {
		return studentMapper.selectByPrimaryKey(studentno);
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
