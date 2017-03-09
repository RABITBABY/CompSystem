package com.cs.dao.guideteacher;

import com.cs.pojo.GuideTeacher;

public interface GuideTeacherMapper {
    int deleteByPrimaryKey(Integer guideteaid);

    int insert(GuideTeacher record);

    int insertSelective(GuideTeacher record);

    GuideTeacher selectByPrimaryKey(Integer guideteaid);

    int updateByPrimaryKeySelective(GuideTeacher record);

    int updateByPrimaryKey(GuideTeacher record);
}