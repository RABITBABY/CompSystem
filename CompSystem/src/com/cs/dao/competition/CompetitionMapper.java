package com.cs.dao.competition;

import com.cs.pojo.Competition;

public interface CompetitionMapper {
    int deleteByPrimaryKey(Integer comid);

    int insert(Competition record);

    int insertSelective(Competition record);

    Competition selectByPrimaryKey(Integer comid);

    int updateByPrimaryKeySelective(Competition record);

    int updateByPrimaryKey(Competition record);
}