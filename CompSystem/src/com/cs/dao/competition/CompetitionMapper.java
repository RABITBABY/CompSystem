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
    
    /**
     * 系部：审批申报表
     * @param competition
     * @return
     */
    int updateByDepart(Competition competition);
    
    /**
     * 教学处：审批申报表
     * @param competition
     * @return
     */
    int updateByTeach(Competition competition);
    
    
    int insert(Competition record);
    
    int insertSelective(Competition record);

    Competition selectByComId(Integer comid);

    int updateByPrimaryKeySelective(Competition record);

    int updateByPrimaryKey(Competition record);
}