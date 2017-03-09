package com.cs.dao.standard;

import com.cs.pojo.Standard;

public interface StandardMapper {
    int deleteByPrimaryKey(Integer standardid);

    int insert(Standard record);

    int insertSelective(Standard record);

    Standard selectByPrimaryKey(Integer standardid);

    int updateByPrimaryKeySelective(Standard record);

    int updateByPrimaryKey(Standard record);
}