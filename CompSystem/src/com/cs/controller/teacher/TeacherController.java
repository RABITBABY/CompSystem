package com.cs.controller.teacher;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
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
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.ModelAndView;

import com.cs.pojo.Awards;
import com.cs.pojo.Budget;
import com.cs.pojo.Competition;
import com.cs.pojo.Department;
import com.cs.pojo.Groups;
import com.cs.pojo.Hours;
import com.cs.pojo.Material;
import com.cs.pojo.Schedule;
import com.cs.pojo.Student;
import com.cs.pojo.Teacher;
import com.cs.service.groups.GroupsService;
import com.cs.service.teacher.TeacherService;
import com.cs.vo.CompetitionInfoVo;

@Controller
@RequestMapping("/teacher")
public class TeacherController {
	/**
	 * 1.查看、修改教师个人信息√ 
	 * 2.管理申报表。 
	 *   2.1）查看所有申报书审批结果（列表以及结果。）√
	 *     2.1.1）根据结果查看申报书，比如，查找所有通过的申报书√ 
	 *     2.1.2）查看申报书详情√ 
	 *   2.2）新增 √
	 *   2.3）修改√、删除√。仅限申报不通过时。
	 * 3.查看审批通过的竞赛。 ——》2.1.1）根据结果查看申报书：这两个差不多
	 *   3.1）查看某个竞赛参与的组别。√ 
	 *     3.1.1）查看某个组别中的成员√ 
	 *   3.2）管理（删除/允许）某个报名竞赛的组别√
	 * 4.查看已经结束的竞赛。√ 
	 *   4.1）反馈竞赛结果 √ 
	 * 5.导出申报表√
	 */

	@Autowired
	private TeacherService teacherService;
	@Autowired
	private GroupsService groupsService;

	/**
	 * 1.查看教师个人信息
	 * 
	 * @param teacherNo
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/getTeacherInfo")
	public Teacher getTeacherInfo(Integer teacherNo) {
		return teacherService.selectByTeacherNo(teacherNo);
	}

	/**
	 * 1.修改教师信息
	 */
	@ResponseBody
	@RequestMapping(value = "/updateTeacherInfo", method = RequestMethod.POST)
	public boolean updateTeacherInfo(Teacher teacher) {
		return teacherService.updateByTeacherNo(teacher);
	}

	/**
	 * 2.1根据teacherno查看申报列表及结果
	 * 
	 * @param teacherNo
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/getCompResult")
	public List<Competition> getCompResult(Integer teacherNo) {
		return teacherService.getCompResults(teacherNo);
	}

	/**
	 * 2.1.1）根据申报结果查看申报书，比如，查找所有通过的申报书
	 * 
	 * @param competition
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/getCompBySpStatus")
	public List<Competition> getCompBySpStatus() {
		Integer depStatus = 1;
		Integer teaStatusInteger = 1;
		Competition competition = new Competition();
		competition.setDepspstatus(depStatus);
		competition.setTeaspstatus(teaStatusInteger);
		competition.setTeacherno(1);
		return teacherService.getCompBySpStatus(competition);
	}

	/**
	 * 2.1.2）查看申报书详情
	 * 
	 * @param comId
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/getCompDetail")
	public Map<String, Object> getCompDetail() {
		return teacherService.getCompDetail(1);
	}

	/**
	 * 2.2）新增申报书
	 * 
	 * @param comId
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/addComp")
	public void addComp(CompetitionInfoVo competitionInfovo) {
		teacherService.addComp(competitionInfovo);
	}

	/**
	 * 2.3删除申报表
	 * 
	 * @param comId
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/deleteComp")
	public void deleteComp(CompetitionInfoVo compVo) {
		teacherService.deleteComp(compVo);
	} 
	
	/**
	 * 2.3）修改申报书
	 * 
	 * @param comId
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/updateComp")
	public void updateComp(CompetitionInfoVo compVo) {
		teacherService.updateComp(compVo);
	}

	/**
	 * 3.1）查看某个竞赛参与的组别。
	 * 
	 * @param comId
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/getCompGroups")
	public List<Groups> getCompGroups(Integer comId) {
		return groupsService.getCompGroups(comId);
	}

	/**
	 * 3.1.1）查看某个组别中的成员
	 * 
	 * @param groupsNo
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/getGroupsMember")
	public List<Student> getGroupsMember(Integer groupsNo) {
		return teacherService.getGroupsMember(1);
	}

	/**
	 * 3.2）管理（删除/允许）某个报名竞赛的组别
	 * 
	 * @param teacherNo
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/manageGroupsMember")
	public boolean manageGroupsMember(Groups groups) {
		return teacherService.approveGroups(groups);
	}

	/**
	 * 4.查看已经结束的竞赛。
	 * 
	 * @param teacherNo
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/getEndCompetition")
	public List<Competition> getEndCompetition(Integer teacherNo) {
		return teacherService.getEndCompetition(1);
	}

	/**
	 * 4.1）反馈竞赛结果
	 * 
	 * @param awards
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/setCompResult")
	public void setCompResult(HttpServletRequest request,Awards[] awards) throws IllegalStateException, IOException{
		//将当前上下文初始化给CommonsMultipartResolver（多部分解析器）
				CommonsMultipartResolver multipartResolver=new CommonsMultipartResolver(
						request.getSession().getServletContext());
				//检查表单是否有enctype="multipart/form-data"属性
				if(multipartResolver.isMultipart(request)){
					//将request变成多部分request
					MultipartHttpServletRequest multiRquest=(MultipartHttpServletRequest)request;
					//获取multiRquest的所有文件名
					Iterator iter=multiRquest.getFileNames();
					while (iter.hasNext()) {
						//一次遍历所有文件
						MultipartFile file=multiRquest.getFile(iter.next().toString());
						if(file!=null){//文件不为空
							for(int i=0;i<awards.length;i++){
								String imageName=awards[i].getGroupsno().toString()+System.currentTimeMillis();
								//上传的位置-----------------------------------------
								String path=request.getSession().getServletContext().getRealPath(File.separator)+"fileUpload\\awards\\"+imageName+".jpg";
								//上传
								file.transferTo(new File(path));
								
								//保存进数据库
								awards[i].setAwardsimg(imageName+".jpg");
								teacherService.setCompResult(awards[i]);
							}
							
						}
					}
				}
	}
		

	/**
	 * 5.导出申报表
	 * 
	 * @param comId
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/getAprroveTable")
	public boolean getAprroveTable() {
		return teacherService.createWord(1);
	}
}
