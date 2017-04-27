package com.cs.service.teacher;

import java.util.List;
import java.util.Map;

import com.cs.pojo.Awards;
import com.cs.pojo.Competition;
import com.cs.pojo.Groups;
import com.cs.pojo.Student;
import com.cs.pojo.Teacher;
import com.cs.vo.CompetitionInfoVo;

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
	public void deleteComp(Integer comId);
	
	/**
	 * 新增申报表
	 * @param comId
	 * @return
	 */
	public void addComp(CompetitionInfoVo compVo);
	
	/**
	 * 根据teacherno查找申报列表/以及结果
	 * @return
	 */
	public List<Competition> getCompResults(Integer teacherNo);
	
	
	
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
	
	/**
	 * 反馈比赛结果
	 * @return
	 */
	public boolean setCompResult(Awards awards);

	/**
	 * 导出申报表
	 * @param comId
	 * @return
	 */
	public boolean createWord(Integer comId);
	
	/**
	 * 修改申报表
	 * @param comId
	 * @return
	 */
	public void updateComp(CompetitionInfoVo compVo);
	
	/**
	 * 系主任审批
	 * @param comId
	 * @return
	 */
	public void updateCompStatusByDept(Competition comp);
	
	/**
	 * 教学处审批
	 * @param comId
	 * @return
	 */
	public void updateCompStatusByTea(Competition comp);
	
	
}
