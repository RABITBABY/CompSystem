package com.cs.service.student;

import java.util.List;

import com.cs.pojo.Awards;
import com.cs.pojo.Competition;
import com.cs.pojo.Material;
import com.cs.pojo.Project;
import com.cs.pojo.Student;

public interface StudentService {

	/**
	 * 学生登录
	 * @param stu
	 * @return
	 */
	Student stuLogin(Student stu);
	
	/**
	 * 根据学生no查找学生
	 * @param studentNo
	 * @return
	 */
	Student selectByNo(int studentNo);
	
	/**
	 * 根据学号查找材料
	 * @param studentNo
	 * @return
	 */
	List<Material> getMaterials(Integer studentNo);
	
	/**
	 * 根据学号查找报名的竞赛
	 * @param studentNo
	 * @return
	 */
	List<Project> selectCompByStudentNo(Integer studentNo);
	
	/**
	 * 根据学号查询获奖情况
	 * @param studentNo
	 * @return
	 */
	List<Awards> selectAwardsByStudentNo(Integer studentNo);
	
}
