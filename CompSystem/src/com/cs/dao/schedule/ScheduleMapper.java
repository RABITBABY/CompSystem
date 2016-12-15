package com.cs.dao.schedule;

import com.cs.pojo.Schedule;

public interface ScheduleMapper {
    int deleteByPrimaryKey(Integer scheduleid);

    int insert(Schedule record);

    int insertSelective(Schedule record);

    Schedule selectByScheduleId(Integer scheduleid);

    int updateByPrimaryKeySelective(Schedule record);

    int updateByPrimaryKey(Schedule record);
}