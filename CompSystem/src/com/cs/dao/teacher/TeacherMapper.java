package com.cs.dao.teacher;

import com.cs.pojo.Teacher;

public interface TeacherMapper {
	
    /**
     * 根据教师职工号查找
     * @param teacherno
     * @return
     */
    Teacher selectByTeacherNo(Integer teacherno);

    /**
     * 修改教师信息
     */
    boolean updateByTeacherNo(Teacher teacher);
    

}