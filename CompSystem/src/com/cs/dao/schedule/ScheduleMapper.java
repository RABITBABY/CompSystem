package com.cs.dao.schedule;

import java.util.List;

import com.cs.pojo.Schedule;

public interface ScheduleMapper {
	List<Schedule> selectByComId(Integer comId);
	
    int insert(Schedule record);

    int insertSelective(Schedule record);
}