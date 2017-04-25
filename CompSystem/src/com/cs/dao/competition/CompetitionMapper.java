package com.cs.dao.competition;

import java.util.List;
import java.util.Map;

import com.cs.pojo.Competition;

public interface CompetitionMapper {
	/*根据状态查找竞赛。比如，所有通过申报的竞赛*/
	List<Competition> selectBySpStatus(Competition competition);
	
	/*系主任审批*/
	int updateByDeptAdmin(Competition competition);
	
	/*教学处审批*/
	int updateByTea(Competition competition);
	
	List<Competition> selectEndComp(Integer teacherNo);
	
    int deleteByPrimaryKey(Integer comid);
    
    List<Competition> selectByTeacherno(Integer teacherno);

    int insert(Competition record);

    int insertSelective(Competition record);

    Competition selectByPrimaryKey(Integer comid);

    int updateByPrimaryKeySelective(Competition record);

    int updateByPrimaryKey(Competition record);
    
    //max
    List<Map<String,Object>> selectByAdmin(Map map);
    int getTotal();
    int updatePubState(Map map);
    
    List<Competition> todayCompetition();
    List<Competition> yesterdayCompetition();
    List<Competition> tomorrowCompetition();
    List<Competition> lastWeekCompetition();
    List<Competition> nextWeekCompetition();
    List<Competition> lastMoonCompetition();
    
    
    
    
    
    
    
}
