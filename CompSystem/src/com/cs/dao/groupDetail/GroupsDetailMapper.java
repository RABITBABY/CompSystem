package com.cs.dao.groupDetail;

import com.cs.pojo.GroupsDetail;



public interface GroupsDetailMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(GroupsDetail record);

    int insertSelective(GroupsDetail record);

    GroupsDetail selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(GroupsDetail record);

    int updateByPrimaryKey(GroupsDetail record);
}