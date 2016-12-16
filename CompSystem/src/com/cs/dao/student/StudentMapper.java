package com.cs.dao.student;

import java.util.List;

import com.cs.pojo.Student;

public interface StudentMapper {
    int deleteByID(Integer studentno);

    int insert(Student record);

    int insertSelective(Student record);

    /**
     * 根据学号no查询学生信息
     * @param studentno
     * @return
     */
    Student selectByStudentNo(Integer studentno);
    

    int updateByIDSelective(Student record);

    int updateByID(Student record);
}
