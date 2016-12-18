package com.cs.dao.hour;

import java.util.List;

import com.cs.pojo.Hours;

public interface HoursMapper {
	
	/**
	 * 批量添加课时预算
	 * @param hours
	 * @return
	 */
	int addHoursBatch(List<Hours> hours);
	
    int deleteByPrimaryKey(Integer hoursid);

    int insert(Hours record);

    int insertSelective(Hours record);

    Hours selectByHoursId(Integer hoursid);

    int updateByPrimaryKeySelective(Hours record);

    int updateByPrimaryKey(Hours record);
}