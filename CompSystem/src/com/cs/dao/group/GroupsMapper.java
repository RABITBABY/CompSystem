package com.cs.dao.group;

import java.util.List;
import java.util.Map;

import com.cs.pojo.Competition;
import com.cs.pojo.Groups;

public interface GroupsMapper {
	//根据studentno查找该学生报名的竞赛
	List<Map<String, Object>> selectByStuNo(Integer studentno);
	
	//根据comId查找参与该竞赛的组别
	List<Groups> selectByComId(Integer comId);
	
    int deleteByPrimaryKey(Integer groupsno);

    int insert(Groups record);

    int insertSelective(Groups record);

    Groups selectByPrimaryKey(Integer groupsno);

    int updateByPrimaryKeySelective(Groups record);

    int updateByPrimaryKey(Groups record);
}