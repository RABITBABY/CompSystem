package com.cs.dao.teacher;

import java.util.List;

import org.apache.ibatis.annotations.Param;

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
    
    /**
     * 为竞赛添加指导老师。
     * @param teachers
     * @return
     */
    int addGuideTeacher(@Param("teacherNo") Integer teacherNo,@Param("comId")Integer comId);
    

}