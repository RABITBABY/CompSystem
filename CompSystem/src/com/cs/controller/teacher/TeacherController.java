package com.cs.controller.teacher;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.FormParam;
import javax.ws.rs.GET;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.cs.pojo.Budget;
import com.cs.pojo.Competition;
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
	 * 竞赛申报表保存：一般添加返回什么呢？
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value="/saveComp",method=RequestMethod.POST)
	public boolean saveComp(Competition competition){
		/*Teacher teacher=new Teacher();
		teacher.setTeacherNo(1);
		Competition competition=new Competition();
		competition.setComName("测试budget2");
		competition.setTeacher(teacher);
		
		List<Budget> budgets=new ArrayList<Budget>();
		
		Budget budget=new Budget();
		budget.setReasons("ssss");
		budget.setSubject("ddd");
		budget.setSum(1);
		
		Budget budget1=new Budget();
		budget1.setReasons("ssss2");
		budget1.setSubject("ddd2");
		budget1.setSum(2);
		
		budgets.add(budget);
		budgets.add(budget1);
		
		competition.setBudgets(budgets);*/
				
		return teacherService.saveCompetition(competition);
	}
	
	/**
	 * 根据教师id查看竞赛申报表列表：
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value="/getComp")
	public List<Competition> getComp(@Param("teacherNo") Integer teacherNo){
		
		return null;
	}
	
	/**
	 * 审核通过后完善信息，竞赛条件。负责人签名。报名开始时间等。
	 * @return
	 */
	
	/**
	 * 查看什么竞赛有那些学生。
	 * @return
	 */
	
	/**
	 * 审核报名学生。修改状态
	 * @return
	 */
	
	/**
	 * 查看已经比赛完毕的竞赛，反馈竞赛结果
	 * 将结果加入awards表
	 * @return
	 */

	
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
	@RequestMapping(value="/updateInfo",method=RequestMethod.POST)
	public boolean updateTeacher(Teacher teacher) {

		boolean updateByTeacherNo = teacherService.updateByTeacherNo(teacher);
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
