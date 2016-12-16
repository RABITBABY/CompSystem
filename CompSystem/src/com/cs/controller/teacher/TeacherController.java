package com.cs.controller.teacher;

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
import com.cs.pojo.Schedule;
import com.cs.pojo.Teacher;
import com.cs.service.teacher.TeacherService;


@Controller
@RequestMapping("/teacher")
public class TeacherController {
	
	@Autowired
	private TeacherService teacherService;
	/*
	@InitBinder("hours")
    public void initBinderFormBean1(WebDataBinder binder) {  
        binder.setFieldDefaultPrefix("hours.");  
    }
    @InitBinder("schedule")
    public void initBinderFormBean2(WebDataBinder binder) {  
        binder.setFieldDefaultPrefix("schedule.");  
    }*/
	
	/**
	 * 获取老师个人信息
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/getInfo")
	public Teacher getInfo(){
		//使用session获取登录的教师，此处先使用假的老师:1号
		Teacher teacherInfo = teacherService.selectByTeacherNo(1);
		return teacherInfo;
	}
	
	/**
	 * 修改教师信息
	 */
	@ResponseBody
	@RequestMapping("/updateInfo")
	public boolean updateTeacher() {
		Teacher teacher=new Teacher();
		teacher.setTeacherNo(2);
		teacher.setGender("女");
		
		Department department=new Department();
		department.setDepartmentId(2);
		teacher.setDepartment(department);
		
		boolean updateByTeacherNo = teacherService.updateByTeacherNo(teacher);
		
		System.out.println(updateByTeacherNo);
		return updateByTeacherNo;
	}
	
	/*@ResponseBody
	@RequestMapping("/get.do")
	private void get(Hours hours,Schedule schedule){
		System.out.println(hours.getHours());
		System.out.println(hours.getHours());
		System.out.println(sch.getHours());
	}
	
	@RequestMapping("/toget.do")
	private String toget(){
		return "test";
	}
	*/
	
	
}
