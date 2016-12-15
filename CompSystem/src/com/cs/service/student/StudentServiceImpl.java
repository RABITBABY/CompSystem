package com.cs.service.student;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cs.dao.material.MaterialMapper;
import com.cs.dao.student.StudentMapper;
import com.cs.pojo.Material;
import com.cs.pojo.Student;
@Service("studentService")
public class StudentServiceImpl implements StudentService {
	@Autowired
	StudentMapper mapper;
	@Autowired
	private MaterialMapper materialMapper;
	
	@Override
	public Student stuLogin(Student stu) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Student selectByNo(int studentNo) {
		return mapper.selectByStudentNo(studentNo);
	}

	@Override
	public List<Material> getMaterials(Integer studentNo) {
		List<Material> selectByStudentNo = materialMapper.selectByStudentNo(studentNo);
		return selectByStudentNo;
	}

}
