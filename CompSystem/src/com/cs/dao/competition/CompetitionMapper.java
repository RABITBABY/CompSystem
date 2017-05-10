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
	
	/*查找已经结束的竞赛*/
	List<Competition> selectEndComp(Integer teacherNo);
	
	/*删除*/
    int deleteByPrimaryKey(Integer comid);
     
    /*查找该教师所申报的竞赛*/
    List<Competition> selectByTeacherno(Integer teacherno);
    
    /*查找该教师所负责的竞赛*/
    List<Competition> selectByLeaderNo(Integer leaderNo);
    
    /*查找该教师所负责培训的竞赛*/
    List<Competition> selectScheCompByTeacherNo(Integer teacherno);
    
    /*查找该教师所指导的竞赛*/
    List<Competition> selectGuideCompByTeacherNo(Integer teacherno);
    
    /*查找该教师草稿箱。为提交审批的申报书*/
    List<Competition> selectNoSubmitByTeacherNo(Integer teacherno);
    
    /*教师端查找可报名竞赛。*/
    List<Competition> selectApplyCompByteacherNo(Integer teacherno);
    
    /*查找该教师负责或申报的竞赛*/
    List<Competition> selectByLeaderNoOrTeacher(Integer teacherno);
    
    List<Competition> selectAllComp();

    int insert(Competition record);

    int insertSelective(Competition record);

    Competition selectByPrimaryKey(Integer comid);

    int updateByPrimaryKeySelective(Competition record);

    int updateByPrimaryKey(Competition record);
    /*系部待审批的竞赛*/
    List<Competition> examDeptComp(Integer teacherNo);
    /*教学处待审批的竞赛*/
    List<Competition> examTeaComp(Integer teacherNo);
    
    //max
    List<Map<String,Object>> selectByAdmin(Map map);
    int getTotal();
    int updatePubState(Map map);
    
    List<Competition> beforeToday();
    List<Competition> afterToday();
    
    List<Map> analysisCom(Map map);
    
    List<Map> unPubCom();
    
    
    
}
