package com.cs.dao.group;

import java.security.acl.Group;
import java.util.List;
import java.util.Map;

import com.cs.pojo.Competition;
import com.cs.pojo.Groups;
import com.cs.pojo.Student;

public interface GroupsMapper {
	//根据studentno查找该学生报名的竞赛
	List<Map<String, Object>> selectByStuNo(Integer studentno);
	
	//根据comId查找参与该竞赛的组别
	List<Groups> selectByComId(Integer comId);
	
	//根据groupsno查找该组的成员
	List<Student> selectByGroupsNo(Integer groupsNo);
	
	//修改队伍状态
	int updateStatus(Groups groups);
	
    int deleteByPrimaryKey(Integer groupsno);

    int insert(Groups record);

    int insertSelective(Groups record);

    Groups selectByPrimaryKey(Integer groupsno);

    int updateByPrimaryKeySelective(Groups record);

    int updateByPrimaryKey(Groups record);
}