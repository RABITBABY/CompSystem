package com.cs.service.student;

import java.util.List;
import java.util.Map;

import com.cs.pojo.Awards;
import com.cs.pojo.Competition;
import com.cs.pojo.Material;
import com.cs.pojo.Student;

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
	 * 根据学号查找符合的条件
	 * @param studentNo
	 * @return
	 */
	//List<Condition> getConditions(Integer studentNo);
	
	/**
	 * 根据学号查找报名的竞赛
	 * @param studentNo
	 * @return
	 */
	//List<Project> selectCompByStudentNo(Integer studentNo);
	
	/**
	 * 根据学号查询获奖情况
	 * @param studentNo
	 * @return
	 */
	/*List<Awards> selectAwardsByStudentNo(Integer studentNo);*/
	
	/**
	 * 根据学号查询学生详细信息，包括材料等。
	 * @param studentNo
	 * @return
	 */
	/*Student selectMaterialByNo(Integer studentNo);*/
	
	
}
