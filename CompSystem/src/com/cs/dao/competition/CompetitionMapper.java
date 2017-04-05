package com.cs.dao.competition;

import java.util.List;

import com.cs.pojo.Competition;

public interface CompetitionMapper {
	/*根据状态查找竞赛。比如，所有通过申报的竞赛*/
	List<Competition> selectBySpStatus(Competition competition);
	
	List<Competition> selectEndComp(Integer teacherNo);
	
    int deleteByPrimaryKey(Integer comid);
    
    List<Competition> selectByTeacherno(Integer teacherno);

    int insert(Competition record);

    int insertSelective(Competition record);

    Competition selectByPrimaryKey(Integer comid);

    int updateByPrimaryKeySelective(Competition record);

    int updateByPrimaryKey(Competition record);
}