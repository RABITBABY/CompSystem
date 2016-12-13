package com.cs.controller.teacher;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;


@Controller
@RequestMapping("/teacher")
public class TeacherController {
	
	/**
	 * 获取老师个人信息
	 * @return
	 */
	@RequestMapping("/getInfo.do")
	public ModelAndView getInfo(){
		ModelAndView mView=new ModelAndView();		
		//注册
//		boolean result = rService.addUser(user);
//		if (result) {
//			mView.setViewName("login/login");
//		}else{
//			mView.setViewName("regs/regs");
//			mView.addObject("reg_msg", "注册失败，请重新注册");
//		}
		return mView;
	}
}
