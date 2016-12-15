package com.cs.dao.standard;

import com.cs.pojo.Standard;

public interface StandardMapper {
    int deleteByID(Integer standardid);

    int insert(Standard record);

    int insertSelective(Standard record);

    Standard selectByID(Integer standardid);

    int updateByIDSelective(Standard record);

    int updateByID(Standard record);
}