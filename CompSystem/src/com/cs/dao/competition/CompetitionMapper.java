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
	
	/*系部申报列表中已经结束的竞赛*/
	List<Competition> selectDeptEndComp(Integer teacherNo);
	
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
    
    /*查找该教师正在进行的竞赛 */
    List<Competition> selectNowComp(Integer teacherno);
    
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
    int getTotal(Map map);
    int updatePubState(Map map);
    
    List<Competition> beforeToday();
    List<Competition> afterToday();
    
    List<Map> analysisCom(Map map);
    
    List<Map> unPubaward(String department);
    List<Map> unPubCom(String department);
    //查找系部审批员中所有的申报书
    List<Competition> selectDeptComp(Integer teacherNo);
    //查找系部审批表中，教学处未审批的部分
    List<Competition> selectNoTeaCompInDept(Integer teacherNo);
    //查找系部审批表中，审批通过部分
    List<Competition> selectDeptCompPass(Integer teacherNo);
    //查找系部审批表中，正在报名的部分
    List<Competition> selectDeptCompApply(Integer teacherNo);
    //系部审批表中，正在举行的竞赛
    List<Competition> selectDeptNowComp(Integer teacherNo);
    //系部审批表中，审批不通过的竞赛
    List<Competition> selectDeptNotPassComp(Integer teacherNo);
    //教学处申报书中待系部审批的竞赛
    List<Competition> selectNoDeptCompInTea(Integer teacherNo);
    //教学处申报书中审批通过的竞赛
    List<Competition> selectTeaCompPass(Integer teacherNo);
    //教学处申报书中审批不通过的竞赛
    List<Competition> selectTeaCompFail(Integer teacherNo);
    //教学处申报书中正在报名的竞赛
    List<Competition> selectTeaCompApply(Integer teacherNo);
    //教学处申报书中正在比赛的竞赛
    List<Competition> selectTeaNowComp(Integer teacherNo);
    //教学处申报书中已经结束的竞赛
    List<Competition> selectTeaEndComp(Integer teacherNo);
}

