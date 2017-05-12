package com.cs.dao.group;

import java.security.acl.Group;
import java.util.List;
import java.util.Map;

import com.cs.pojo.Competition;
import com.cs.pojo.Groups;
import com.cs.pojo.Student;

public interface GroupsMapper {
	//根据studentno查找该学生报名的竞赛返回map
	List<Map<String, Object>> selectByStuNo(Integer studentno);
	//根据studentno查找该学生报名的竞赛返回competition
	List<Competition> selectCompetitionByStuNo(Integer studentno);
	/**
	 * 根据comId和studentno获取队伍信息。包括队长group和队员group
	 * Map ：
	 * Integer comId,Integer studentno
	 * @return
	 */
	List<Groups> selectByComIdAndStudentNo(Map<String,Object> map);
	
	//根据comId查找参与该竞赛的组别
	List<Groups> selectByComId(Integer comId);
	
	//根据groupsno查找该组的成员
	List<Student> selectByGroupsNo(Integer groupsNo);
	
	//根据id查找所在组的队长的group信息
	Groups selectGroupById(Integer id);
	
	//修改队伍状态
	int updateStatus(Groups groups);
	
	//修改队长意见
	int updateCaptainStatus(Groups groups);
	
	//根据groupsno删除
    int deleteByGroupsNo(Integer groupsno);
    //根据id删除
    int deleteByid(Integer id);
    //插入
    int insert(Groups record);
    //查找最大的groupsNo
    int selectMaxGroupsNo();

    int insertSelective(Groups record);

    Groups selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Groups record);

    int updateByPrimaryKey(Groups record);
    //未反馈获奖的组别
    List<Groups> selectNotAwardsGroups(Integer comId);
}