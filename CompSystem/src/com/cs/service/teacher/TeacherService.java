package com.cs.service.teacher;

import java.util.List;
import java.util.Map;

import com.cs.pojo.Competition;
import com.cs.pojo.Groups;
import com.cs.pojo.Student;
import com.cs.pojo.Teacher;

public interface TeacherService {

	/**
	 * 根据teacherno查找老师的信息
	 * @param teacher
	 * @return
	 */
	Teacher selectByTeacherNo(Integer teacherNo);
	
	/**
	 * 根据教师id修改信息
	 * @param teacher
	 * @return
	 */
	boolean updateByTeacherNo(Teacher teacher); 

	/**
	 * 删除申报表
	 * @param comId
	 * @return
	 */
	public boolean deleteComp(Integer comId);
	
	/**
	 * 根据teacherno查找申报列表/以及结果
	 * @return
	 */
	public List<Competition> getCompResults(Integer teacherNo);
	
	/**
	 * 根据comId查找该竞赛参与的组别
	 * @return
	 */
	public List<Groups> getCompGroups(Integer comId);
	
	/**
	 * 根据SpStatus状态查找竞赛
	 * @return
	 */
	public List<Competition> getCompBySpStatus(Competition competition);
	
	/**
	 * 根据comId查找竞赛详情
	 * @return
	 */
	public Map<String,Object> getCompDetail(Integer comId);
	
	/**
	 * 根据groupsNo该组组员
	 * @return
	 */
	public List<Student> getGroupsMember(Integer groupsNo);
	
	/**
	 * 修改队伍状态：教师审批参赛学生
	 * @return
	 */
	public boolean approveGroups(Groups groups);
	
	/**
	 * 查找结束的竞赛
	 * @return
	 */
	public List<Competition> getEndCompetition(Integer teacherNo);
	
}
