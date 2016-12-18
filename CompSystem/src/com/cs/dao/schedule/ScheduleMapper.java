package com.cs.dao.schedule;

import java.util.List;

import com.cs.pojo.Schedule;

public interface ScheduleMapper {
	
	/**
	 * 批量插入培训工作安排
	 * @param schedules
	 * @return
	 */
	int addScheduleBatch(List<Schedule> schedules);
	
    int deleteByPrimaryKey(Integer scheduleid);

    int insert(Schedule record);

    int insertSelective(Schedule record);

    Schedule selectByScheduleId(Integer scheduleid);

    int updateByPrimaryKeySelective(Schedule record);

    int updateByPrimaryKey(Schedule record);
}