package com.cs.dao.awards;

import com.cs.pojo.Awards;

public interface AwardsMapper {
    int deleteByPrimaryKey(Integer awardsid);

    int insert(Awards record);

    int insertSelective(Awards record);

    Awards selectByPrimaryKey(Integer awardsid);

    int updateByPrimaryKeySelective(Awards record);

    int updateByPrimaryKey(Awards record);
}