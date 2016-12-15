package com.cs.dao.hour;

import com.cs.pojo.Hours;

public interface HoursMapper {
    int deleteByPrimaryKey(Integer hoursid);

    int insert(Hours record);

    int insertSelective(Hours record);

    Hours selectByHoursId(Integer hoursid);

    int updateByPrimaryKeySelective(Hours record);

    int updateByPrimaryKey(Hours record);
}