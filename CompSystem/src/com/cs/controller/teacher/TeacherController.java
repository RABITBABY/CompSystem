package com.cs.controller.teacher;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

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
import com.cs.pojo.Groups;
import com.cs.pojo.Hours;
import com.cs.pojo.Schedule;
import com.cs.pojo.Teacher;
import com.cs.service.teacher.TeacherService;


@Controller
@RequestMapping("/teacher")
public class TeacherController {
	/**
	 * 1.查看、修改教师个人信息
	 * 2.管理申报表。
	 *   2.1）查看所有申报书审批结果（列表以及结果。）
	 *      2.1.1）根据结果查看申报书，比如，查找所有通过的申报书
	 *      2.1.2）查看申报书详情
	 *   2.2）新增
	 *   2.3）修改、删除。仅限申报不通过时。
	 * 3.查看审批通过的竞赛。
	 *   3.1）查看某个竞赛参与的组别。
	 *      3.1.1）查看某个组别中的成员
	 *   3.2）管理（删除）某个报名竞赛的组别
	 * 4.查看已经结束的竞赛。
	 *   4.1）反馈竞赛结果
	 */
	
	@Autowired
	private TeacherService teacherService;

	/**
	 * 1.查看教师个人信息
	 * @param teacherNo
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value="/getTeacherInfo")
	public Teacher getTeacherInfo(Integer teacherNo) {
	   return teacherService.selectByTeacherNo(teacherNo);
	}
	
	/**
	 * 1.修改教师信息
	 */
	@ResponseBody
	@RequestMapping(value="/updateTeacherInfo",method=RequestMethod.POST)
	public boolean updateTeacherInfo(Teacher teacher) {
	    return teacherService.updateByTeacherNo(teacher);
	}
	
	/**
	 * 2.1根据teacherno查看申报列表及结果
	 * @param teacherNo
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value="/getCompResult")
	public List<Competition> getCompResult(Integer teacherNo) {
	   return teacherService.getCompResults(teacherNo);
	}
	
	/**
	 *  2.1.1）根据结果查看申报书，比如，查找所有通过的申报书
	 * @param competition
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value="/getCompBySpStatus")
	public List<Competition> getCompBySpStatus() {
		Integer depStatus=1;
		Integer teaStatusInteger=1;
		Competition competition=new Competition();
		competition.setDepspstatus(depStatus);
		competition.setTeaspstatus(teaStatusInteger);
		competition.setTeacherno(1);
	   return teacherService.getCompBySpStatus(competition);
	}
	
	/**
	 *  2.1.2）查看申报书详情
	 * @param comId
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value="/getCompDetail")
	public Competition getCompDetail() {
	   return teacherService.getCompDetail(1);
	}
	
	/**
	 * 删除申报表
	 * @param teacherNo
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value="/deleteComp")
	public boolean deleteComp(Integer comId) {
	   return teacherService.deleteComp(comId);
	}
	
	
	
	/**
	 * 根据comId查看参与该竞赛的组别
	 * @param teacherNo
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value="/getCompGroups")
	public List<Groups> getCompGroups(Integer comId) {
	   return teacherService.getCompGroups(comId);
	}
	
	
	
	
}
