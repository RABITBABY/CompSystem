package com.cs.service.student;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cs.dao.awards.AwardsMapper;
import com.cs.dao.competition.CompetitionMapper;
import com.cs.dao.material.MaterialMapper;
import com.cs.dao.student.StudentMapper;
import com.cs.pojo.Awards;
import com.cs.pojo.Competition;
import com.cs.pojo.Material;
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
	
}
