package com.cs.controller.student;

import java.util.List;

import javax.ws.rs.FormParam;
import javax.ws.rs.GET;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.cs.pojo.Budget;
import com.cs.pojo.Department;
import com.cs.pojo.Hours;
import com.cs.pojo.Material;
import com.cs.pojo.Schedule;
import com.cs.pojo.Teacher;
import com.cs.service.student.StudentService;
import com.cs.service.teacher.TeacherService;


@Controller
@RequestMapping("/student")
public class StudentController {
	
	@Autowired
	private StudentService studentService;
	
	/**
	 * 获取学生材料信息
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/getMaterial.do")
	public List<Material> getInfo(){
		//假学生
		List<Material> materials = studentService.getMaterials(1);
		return materials;
	}
	
	
}
