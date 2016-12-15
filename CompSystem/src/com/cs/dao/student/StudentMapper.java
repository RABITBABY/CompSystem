package com.cs.dao.student;

import com.cs.pojo.Student;

public interface StudentMapper {
    int deleteByID(Integer studentno);

    int insert(Student record);

    int insertSelective(Student record);

    Student selectByStudentNo(Integer studentno);

    int updateByIDSelective(Student record);

    int updateByID(Student record);
}
