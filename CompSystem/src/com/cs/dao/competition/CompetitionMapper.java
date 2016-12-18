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
    
    /**
     * 添加竞赛申报表
     * @param record
     * @return
     */
    int addCompetition(Competition competition);
    
    /**
     * 根据comId查找申报表
     * @param comid
     * @return
     */
    Competition selectByComId(Integer comid);
    
    int insert(Competition record);    

    int updateByPrimaryKeySelective(Competition record);

    int updateByPrimaryKey(Competition record);
}