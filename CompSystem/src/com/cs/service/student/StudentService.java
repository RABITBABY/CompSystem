package com.cs.service.student;

import java.util.List;

import com.cs.pojo.Material;
import com.cs.pojo.Student;

public interface StudentService {

	/*Student stuLogin(Student stu);*/
	
	List<Material> getMaterials(Integer studentNo);
	
}
