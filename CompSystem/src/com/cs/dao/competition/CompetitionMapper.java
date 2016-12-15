package com.cs.dao.competition;

import java.util.List;

import com.cs.pojo.Competition;

public interface CompetitionMapper {
	/**
	 * 根据id删除申报表
	 * @param comid
	 * @return
	 */
    int deleteByPrimaryKey(Integer comid);
    
    
    int insert(Competition record);
    
    int insertSelective(Competition record);

    Competition selectByComId(Integer comid);

    int updateByPrimaryKeySelective(Competition record);

    int updateByPrimaryKey(Competition record);
}