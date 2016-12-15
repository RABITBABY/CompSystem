package com.cs.service.teacher;

import com.cs.pojo.Student;
import com.cs.pojo.Teacher;

public interface TeacherService {

	/**
	 * 根据id查找老师的信息
	 * @param teacher
	 * @return
	 */
	Teacher selectByTeacherNo(Integer teacherNo);
	
	/**
	 * 根据教师id修改信息
	 * @param teacher
	 * @return
	 */
	boolean updateByTeacherNo(Teacher teacher); 
}
