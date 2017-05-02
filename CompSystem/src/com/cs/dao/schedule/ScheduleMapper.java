package com.cs.dao.schedule;

import java.util.List;
import java.util.Map;

import com.cs.pojo.Schedule;

public interface ScheduleMapper {
	
	int addCompScheduleBatch(List<Schedule> schedules);
	
	int updateByPrimaryKeySelective(Schedule schedule);
	
	int deleteByComId(Integer comId);
	
	List<Schedule> selectByComId(Integer comId);
	
    int insert(Schedule record);

    int insertSelective(Schedule record);
    
    
    List<Map> scheduleList(int comId);
}