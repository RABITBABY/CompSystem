package com.cs.service.student;

import java.util.List;

import com.cs.pojo.Competition;
import com.cs.pojo.Material;
import com.cs.pojo.Project;
import com.cs.pojo.Student;

public interface StudentService {

	Student stuLogin(Student stu);
	
	Student selectByNo(int studentNo);
	
	List<Material> getMaterials(Integer studentNo);
	
	List<Project> selectCompByStudentNo(Integer studentNo);
}
