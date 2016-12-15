package com.cs.service.student;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cs.dao.material.MaterialMapper;
import com.cs.pojo.Material;

@Service("studentService")
public class StudentServiceImpl implements StudentService{

	@Autowired
	private MaterialMapper materialMapper;
	
	@Override
	public List<Material> getMaterials(Integer studentNo) {
		List<Material> selectByStudentNo = materialMapper.selectByStudentNo(studentNo);
		return selectByStudentNo;
	}

}
