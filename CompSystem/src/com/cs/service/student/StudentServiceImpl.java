package com.cs.service.student;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cs.dao.material.MaterialMapper;
import com.cs.pojo.Material;
import com.cs.pojo.Student;

@Service("studentService")
public class StudentServiceImpl implements StudentService{

	@Autowired
	private MaterialMapper materialMapper;
	
	@Override
	public List<Material> getMaterials(Integer studentNo) {
		Student student  = materialMapper.selectByStudentNo(studentNo);
		List<Material> selectByStudentNo = student.getMaterials();
		return selectByStudentNo;
	}

}
