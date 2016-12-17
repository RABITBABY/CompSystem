package com.cs.service.student;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cs.dao.awards.AwardsMapper;
import com.cs.dao.competition.CompetitionMapper;
import com.cs.dao.condition.ConditionMapper;
import com.cs.dao.material.MaterialMapper;
import com.cs.dao.project.ProjectMapper;
import com.cs.dao.student.StudentMapper;
import com.cs.pojo.Awards;
import com.cs.pojo.Competition;
import com.cs.pojo.Condition;
import com.cs.pojo.Material;
import com.cs.pojo.Project;
import com.cs.pojo.Student;

@Service("studentService")
public class StudentServiceImpl implements StudentService {
	@Autowired
	private StudentMapper stuMapper;
	@Autowired
	private MaterialMapper materialMapper;
	@Autowired
	private ProjectMapper projectMapper;
	@Autowired
	private AwardsMapper awardsMapper;
	@Autowired
	private ConditionMapper conditionMapper;
	
	@Override
	public Student stuLogin(Student stu) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Student selectByNo(int studentNo) {
		return stuMapper.selectByStudentNo(studentNo);
	}


	@Override
	public List<Project> selectCompByStudentNo(Integer studentNo) {
		 return projectMapper.selectProjectByStudentNo(studentNo);
	}

	@Override
	public List<Awards> selectAwardsByStudentNo(Integer studentNo) {
		return awardsMapper.selectAwardsByStudentNo(studentNo);
	}

	@Override
	public List<Condition> getConditions(Integer studentNo) {
		List<Condition> conditions = conditionMapper.selectPassConditions(studentNo);
		return conditions;
	}

	@Override
	public Student selectMaterialByNo(Integer studentNo) {
		Student student = stuMapper.selectMaterialByNo(studentNo);
		return student;
	}

}
