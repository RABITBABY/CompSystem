package com.cs.dao.teacher;

import com.cs.pojo.Teacher;

public interface TeacherMapper {
    int deleteByPrimaryKey(Integer teacherno);

    int insert(Teacher record);

    int insertSelective(Teacher record);

    Teacher selectByPrimaryKey(Integer teacherno);

    int updateByPrimaryKeySelective(Teacher record);

    int updateByPrimaryKey(Teacher record);
}