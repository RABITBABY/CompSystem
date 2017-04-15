package com.cs.dao.guideteacher;

import java.util.List;

import com.cs.pojo.GuideTeacher;
import com.cs.pojo.Teacher;

public interface GuideTeacherMapper {
	/*根据comId查找指导老师列表*/
    List<Teacher> selectComId(Integer comId);
    
    int addCompGuideTeacherBatch(List<GuideTeacher> guideTeachers);
    
    int deleteByPrimaryKey(Integer guideteaid);

    int insert(GuideTeacher record);

    int insertSelective(GuideTeacher record);

    GuideTeacher selectByPrimaryKey(Integer guideteaid);

    int updateByPrimaryKeySelective(GuideTeacher record);

    int updateByPrimaryKey(GuideTeacher record);
}