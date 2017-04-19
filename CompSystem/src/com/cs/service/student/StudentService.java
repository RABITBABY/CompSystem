package com.cs.service.student;

import java.util.List;
import java.util.Map;

import com.cs.pojo.Awards;
import com.cs.pojo.Competition;
import com.cs.pojo.Conditions;
import com.cs.pojo.Groups;
import com.cs.pojo.Material;
import com.cs.pojo.Student;
import com.cs.pojo.Teacher;

public interface StudentService {
	
	/**
	 * 根据学生no查找学生
	 * @param studentNo
	 * @return
	 */
	Student selectByNo(int studentno);
	
	/**
	 * 根据学生no修改学生信息
	 * @param studentNo
	 * @return
	 */
	int updateByNo(Student studentno);
	
	/**
	 * 根据学号查找报名的所有竞赛
	 * @param studentNo
	 * @return
	 */
	List<Map<String, Object>> getCompByStudentNo(Integer studentNo);
	
	/**
	 * 根据学号查询获奖情况
	 * @param studentNo
	 * @return
	 */
	List<Map<String, Object>> selectAwardsByStudentNo(Integer studentNo);
	
	/**
	 * 判断学生不满足的竞赛条件
	 * @param studentNo
	 * @return
	 */
	List<Conditions> getDissatisfyConditions(Integer studentNo,Integer comId);
	
	/**
	 * 加入队伍
	 * @param 
	 * @return
	 */
	void joinGroup(Integer groupsNo,Integer studentNo);
	
	/**
	 * 获取该竞赛的指导老师
	 * @param comId
	 * @return
	 */
	List<Teacher> getCompGuideTeacher(Integer comId);
	
	/**
	 * 队长审批意见
	 * @param comId
	 * @return
	 */
	void setCaptainStatus(Groups groups);
}
