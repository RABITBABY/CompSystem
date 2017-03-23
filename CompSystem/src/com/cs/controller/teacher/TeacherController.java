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
	
	/**
	 * 查看教师个人信息
	 * @param teacherNo
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value="/getTeacherInfo")
	public Teacher getTeacherInfo(Integer teacherNo) {
	   return teacherService.selectByTeacherNo(teacherNo);
	}
	
	/**
	 * 竞赛申报:
	 * 申报表保存：
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value="/saveComp",method=RequestMethod.POST)
	public boolean saveComp(Competition competition){
		/*测试数据
		//申报的老师
		Teacher teacher=new Teacher();
		teacher.setTeacherNo(1);
		Competition competition=new Competition();
		competition.setComName("测试budget2");
		competition.setTeacher(teacher);
		//指导老师
		Teacher guideTeacher=new Teacher();
		guideTeacher.setTeacherNo(2);
		List<Teacher> teachers=new ArrayList<Teacher>();
		teachers.add(guideTeacher);
		competition.setGuideTeachers(teachers);
		//工作安排
		Schedule schedule=new Schedule();
		schedule.setContent("ssss");
		schedule.setHours(9);
		List<Schedule> schedules=new ArrayList<Schedule>();
		schedules.add(schedule);
		competition.setSchedules(schedules);
		
		//经费预算
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
		competition.setBudgets(budgets);
		//课时预算
		Hours hours=new Hours();
		hours.setHours(4);
		List<Hours> hList=new ArrayList<Hours>();
		hList.add(hours);		
		competition.setHours(hList);*/
				
		return teacherService.saveCompetition(competition);
	}
	
	/*
	 * 查看审批结果：
	 * 1.根据教师id查看竞赛申报表列表：
	 * 2.申报成功的列表可以进行补全竞赛详细材料:对project表进行添加。
	 * 3.根据id查看申报表详情。project 
	 * *4.根据审批结果搜索
	 */
	/**
	 * 1.根据教师id查看竞赛申报表列表：
	 * @param teacherNo
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value="/getCompList")
	public List<Competition> getCompList(@Param("teacherNo") Integer teacherNo){		
		return teacherService.findCompByTeacherNo(1);
	}
	/**
	 * 2.审核通过后完善信息，竞赛条件。负责人签名。报名开始时间等。
	 * 操作【condition表，project表】，以及competition表
	 * @return
	 */
	
	
	/**
	 * 3.查看申报表：根据comId;查找出来的包括经费预算，比赛条件等。要记得配置collection
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value="/getCompByComId")
	public Competition getCompByComId(@Param("comId") Integer comId){		
		return teacherService.findByComId(comId);
	}
	
	
	
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
