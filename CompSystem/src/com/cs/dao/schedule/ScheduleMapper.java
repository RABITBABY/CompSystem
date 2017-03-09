package com.cs.dao.schedule;

import com.cs.pojo.Schedule;

public interface ScheduleMapper {
    int insert(Schedule record);

    int insertSelective(Schedule record);
}