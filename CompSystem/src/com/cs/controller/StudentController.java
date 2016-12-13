package com.cs.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.cs.pojo.Student;
import com.cs.service.student.StudentService;

@Controller
@RequestMapping("/login")
public class StudentController {


	@RequestMapping("/toLogin.do")
	public String toLogin() {
		// 前缀/WEB-INF/jsp/
		// 后缀.jsp
		return "index";
		//组合/WEB-INF/jsp/login/login.jsp
	}
	
	/*@RequestMapping("/doLogin.do")
	public ModelAndView dologin(Student student){
		ModelAndView modelAndView=new ModelAndView();
		System.out.println("conroller----");
	    Student stu=stuService.stuLogin(student);	
		if (stu!=null) {
			modelAndView.setViewName("student/studentIndex");			
		}else{
			modelAndView.setViewName("login/login");
			modelAndView.addObject("msg", "账号或密码错误");
		}
		return modelAndView;
	}*/

}
