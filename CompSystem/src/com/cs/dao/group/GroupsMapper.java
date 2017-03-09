package com.cs.dao.group;

import com.cs.pojo.Groups;

public interface GroupsMapper {
    int deleteByPrimaryKey(Integer groupsno);

    int insert(Groups record);

    int insertSelective(Groups record);

    Groups selectByPrimaryKey(Integer groupsno);

    int updateByPrimaryKeySelective(Groups record);

    int updateByPrimaryKey(Groups record);
}