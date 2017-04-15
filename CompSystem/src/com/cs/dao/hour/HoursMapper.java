package com.cs.dao.hour;

import java.util.List;

import com.cs.pojo.Hours;

public interface HoursMapper {
	
	List<Hours> selectByComId(Integer comId);
	
	int addCompHoursBatch(List<Hours> hoursList);
	
    int deleteByPrimaryKey(Integer hoursid);

    int insert(Hours record);

    int insertSelective(Hours record);

    Hours selectByPrimaryKey(Integer hoursid);

    int updateByPrimaryKeySelective(Hours record);

    int updateByPrimaryKey(Hours record);
}