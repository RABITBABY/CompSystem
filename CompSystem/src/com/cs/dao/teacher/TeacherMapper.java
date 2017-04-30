package com.cs.dao.teacher;

import java.util.List;

import com.cs.pojo.Teacher;

public interface TeacherMapper {
	List<Teacher> selectAllTeacher();
	
    int deleteByPrimaryKey(Integer teacherno);

    int insert(Teacher record);

    int insertSelective(Teacher record);

    Teacher selectByPrimaryKey(Integer teacherno);

    int updateByPrimaryKeySelective(Teacher record);

    int updateByPrimaryKey(Teacher record);
}