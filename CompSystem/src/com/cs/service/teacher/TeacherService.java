package com.cs.service.teacher;

import java.util.List;

import com.cs.pojo.Competition;
import com.cs.pojo.Student;
import com.cs.pojo.Teacher;

public interface TeacherService {

	/**
	 * 根据id查找老师的信息
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
	 * 保存教师填写的申报表
	 * @param teacher
	 * @return
	 */
	boolean saveCompetition(Competition competition); 
	
	/**
	 * 根据教师no查找申报表：列表
	 * @param teacherNo
	 * @return
	 */
	List<Competition> findCompByTeacherNo(Integer teacherNo);
	
	/**
	 * 根据竞赛id查找竞赛详细内容：包括预算，课时预算。等
	 * @param comId
	 * @return
	 */
	Competition findByComId(Integer comId);
	
}
