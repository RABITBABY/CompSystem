package com.cs.dao.group;

import java.util.List;

import org.apache.ibatis.annotations.Update;

import com.cs.pojo.Groups;
import com.cs.pojo.Student;

public interface GroupsMapper {
	
    /**
	 * 根据组No,修改状态
	 * @param teacherNo
	 * @return
	 */
	int updateGroupsStatus(Groups groups);
	
    int deleteByPrimaryKey(Integer groupsno);

    int insert(Groups record);

    int insertSelective(Groups record);

    Groups selectByGroupsNo(Integer groupsno);

    int updateByPrimaryKeySelective(Groups record);


}