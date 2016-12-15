package com.cs.service.teacher;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cs.dao.teacher.TeacherMapper;
import com.cs.pojo.Student;
import com.cs.pojo.Teacher;

@Service("teacherService")
public class TeacherServiceImpl implements TeacherService{

	@Autowired
	private TeacherMapper teacherMapper;

	@Override
	public Teacher selectByTeacherNo(Integer teacherNo) {
		Teacher findTeacher = teacherMapper.selectByTeacherNo(teacherNo);
		return findTeacher;
	}

	@Override
	public boolean updateByTeacherNo(Teacher teacher) {
		return teacherMapper.updateByTeacherNo(teacher);
	}

}
