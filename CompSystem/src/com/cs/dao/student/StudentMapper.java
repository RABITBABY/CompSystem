package com.cs.dao.student;

import com.cs.pojo.Student;

public interface StudentMapper {
    int deleteByPrimaryKey(Integer studentno);

    int insert(Student record);

    int insertSelective(Student record);

    Student selectByPrimaryKey(Integer studentNo);

    int updateByPrimaryKeySelective(Student record);

    int updateByPrimaryKey(Student record);
}