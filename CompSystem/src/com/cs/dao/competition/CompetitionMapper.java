package com.cs.dao.competition;

import java.util.List;

import com.cs.pojo.Competition;
import com.cs.pojo.Teacher;

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
     * 根据comId查找申报表：用于查看详情
     * 连接competition和project表，查出。
     * @param comid
     * @return
     */
    Competition selectALlByComId(Integer comId);
    
    /**
     * 根据comId查找申报表:只查competition
     * 给project，关联
     * @param comid
     * @return
     */
    Competition selectByComId(Integer comId);
    
    /**
     * 根据教师no查找申报表：用于在教师端，查看申报表列表。
     * 在competition表中查找、
     * @param teacherNo
     * @return
     */
    List<Competition> selectByTeacherNo(Integer teacherNo);

    int updateByPrimaryKeySelective(Competition record);

}