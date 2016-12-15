package com.cs.dao.project;

import java.util.List;

import com.cs.pojo.Condition;
import com.cs.pojo.Project;

public interface ProjectMapper {
	
	/**
	 * 根据学生id查找竞赛列表
	 * @return
	 */
	List<Project> selectProjectByStudentNo(Integer studentNo);
	/**
	 * 获取还能报名的竞赛信息
	 * @return
	 */
	List<Project> AvailableCom();
	
    int deleteByPrimaryKey(Integer comid);

    int insert(Project record);

    int insertSelective(Project record);

    Project selectByPrimaryKey(Integer comid);

    int updateByPrimaryKeySelective(Project record);

    int updateByPrimaryKeyWithBLOBs(Project record);

    int updateByPrimaryKey(Project record);
}