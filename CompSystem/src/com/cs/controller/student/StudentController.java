package com.cs.controller.student;

import java.util.List;

import javax.ws.rs.FormParam;
import javax.ws.rs.GET;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.cs.pojo.Awards;
import com.cs.pojo.Budget;
import com.cs.pojo.Competition;
import com.cs.pojo.Condition;
import com.cs.pojo.Department;
import com.cs.pojo.Hours;
import com.cs.pojo.Material;
import com.cs.pojo.Project;
import com.cs.pojo.Schedule;
import com.cs.pojo.Student;
import com.cs.pojo.Teacher;
import com.cs.service.student.StudentService;
import com.cs.service.teacher.TeacherService;


@Controller
@RequestMapping("/student")
public class StudentController {
	
	@Autowired
	private StudentService studentService;
	
	/**
	 * 获取学生材料信息：
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/getMaterials")
	public List<Material> getMaterials(@Param("studentNo") Integer studentNo){
		List<Material> materials = studentService.getMaterials(studentNo);
		return materials;
	}
	
	/**
	 * 获取学生参数满足的条件：状态为1
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/getConditions")
	public List<Condition> getConditions(@Param("studentNo") Integer studentNo){
		List<Condition> conditions = studentService.getConditions(studentNo);
		return conditions;
	}
	
	/**
	 * 获取学生报名的比赛
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/getComp")
	public List<Project> getCompInfo(@Param("studentNo") Integer studentNo){
		List<Project> projects = studentService.selectCompByStudentNo(studentNo);
		return projects;
	}
	
	/**
	 * 获取学生获得的奖项
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/getAwards")
	public List<Awards> getAwards(@Param("studentNo") Integer studentNo){
		List<Awards> awards=studentService.selectAwardsByStudentNo(studentNo);
		return awards;
	}
	
	/**
	 * 获取学生信息
	 * @param studentNo
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/getStuInfo")
	public Student getStuInfo(@Param("studentNo") Integer studentNo){
		return studentService.selectByStudentNo(studentNo);
	}
	
}
