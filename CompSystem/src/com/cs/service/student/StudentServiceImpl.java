package com.cs.service.student;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cs.dao.group.GroupsMapper;
import com.cs.dao.student.StudentMapper;
import com.cs.pojo.Awards;
import com.cs.pojo.Competition;
import com.cs.pojo.Groups;
import com.cs.pojo.Student;


@Service("studentService")
public class StudentServiceImpl implements StudentService {

	@Autowired
	private StudentMapper studentMapper;
	
	@Autowired
	private GroupsMapper groupsMapper;

	@Override
	public Student selectByNo(int studentNo) {
		return studentMapper.selectByPrimaryKey(studentNo);
	}

	@Override
	public int updateByNo(Student student) {
	   return studentMapper.updateByPrimaryKeySelective(student);
	}

	/**
	 * sdf
	 */
	@Override
	public List<Map<String, Object>> getCompByStudentNo(Integer studentNo) {
		return groupsMapper.selectByStuNo(studentNo);
	}

	
	
}
