package com.cs.dao.project;

import com.cs.pojo.Condition;
import com.cs.pojo.Project;

public interface ProjectMapper {
	
    int deleteByPrimaryKey(Integer comid);

    int insert(Project record);

    int insertSelective(Project record);

    Project selectByPrimaryKey(Integer comid);

    int updateByPrimaryKeySelective(Project record);

    int updateByPrimaryKeyWithBLOBs(Project record);

    int updateByPrimaryKey(Project record);
}