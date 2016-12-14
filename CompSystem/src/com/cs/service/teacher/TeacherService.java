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
	 * 修改教师信息
	 * @param teacher
	 */
	void updateTeacher(Teacher teacher);
	
}
