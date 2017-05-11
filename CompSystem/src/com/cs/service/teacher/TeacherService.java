package com.cs.service.teacher;

import java.io.File;
import java.util.List;
import java.util.Map;

import org.apache.commons.io.FileUtils;

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
	public CompetitionInfoVo addComp(CompetitionInfoVo compVo);
	
	/**
	 * 根据teacherno查找申报列表/以及结果
	 * @return
	 */
	public List<Competition> getCompResults(Integer teacherNo);
	
	
	
	/**
	 * 根据btnStatus状态查找竞赛
	 *  1：待审批 2.审批通过  3.审批不通过  
	 *  4：报名中，3：竞赛中，4：竞赛结束
	 * @return
	 */
	public List<Competition> getCompByBtnStatus(Integer btnStatus,Integer teacherNo);
	
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
	public File createWord(Integer comId);
	/**
	 * 修改申报表
	 * @param comId
	 * @return
	 */
	public CompetitionInfoVo updateComp(CompetitionInfoVo compVo);
	
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
	
	
	/**
	 * 查看所有的教师
	 * @param comId
	 * @return
	 */
	public List<Teacher> selectAllTeacher();
	
	/**
	 * 审批员获取等待审批列表
	 * @return
	 */
	public List<Competition> getApproCompList(Integer teacherno);
	
	/**
	 * 获取所有申报列表
	 * @return
	 */
	public List<Competition> selectAllComp();
	
	/**
	 * 保存或提交申报书
	 * @param compVo
	 * @return
	 */
	public CompetitionInfoVo addOrUpdateComp(CompetitionInfoVo compVo);
	
	/**
	 * 查找该教师所负责的竞赛
	 * */
	public List<Competition>  selectByLeaderNo(Integer leaderNo);
	/**
	 * 查找该教师所负责培训的竞赛
	 * */
	public List<Competition>  selectScheCompByTeacherNo(Integer teacherno);
	 /**
	  * 查找该教师所指导的竞赛
	  * */
	public List<Competition>  selectGuideCompByTeacherNo(Integer teacherno);

	
}
