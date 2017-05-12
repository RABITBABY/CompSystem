package com.cs.controller.teacher;

import java.io.BufferedInputStream;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;

import org.apache.commons.io.FileUtils;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.ModelAndView;

import com.cs.dao.competition.CompetitionMapper;
import com.cs.dao.condition.ConditionsMapper;
import com.cs.dao.message.MessageMapper;
import com.cs.pojo.Awards;
import com.cs.pojo.Budget;
import com.cs.pojo.Competition;
import com.cs.pojo.Conditions;
import com.cs.pojo.Department;
import com.cs.pojo.FileUpload;
import com.cs.pojo.Groups;
import com.cs.pojo.Hours;
import com.cs.pojo.Material;
import com.cs.pojo.Message;
import com.cs.pojo.Schedule;
import com.cs.pojo.Student;
import com.cs.pojo.Teacher;
import com.cs.service.condition.ConditionService;
import com.cs.service.groups.GroupsService;
import com.cs.service.teacher.TeacherService;
import com.cs.vo.CompetitionInfoVo;

import freemarker.template.Configuration;
import freemarker.template.Template;

@Controller
@RequestMapping("/teacher")
public class TeacherController {
	/**
	 * 1.查看、修改教师个人信息√ 
	 * 2.管理申报表。 
	 *   2.1）根据teacherno查看所有申报书审批结果（列表以及结果。）√
	 *     2.1.2）查看申报书详情√ 
	 *   2.2）新增或保存申报书 √
	 *   2.3）修改√、删除√。仅限申报不通过时。
	 *   2.4）查看所有申报书审批结果（列表以及结果。）√
	 *   2.5）查找该教师所负责 的竞赛（竞赛负责人，因为申报人不一定是负责人）√
	 *   2.6）查找该教师所负责培训的竞赛（培训课时，教师）√
	 *   2.7）查找该教师所指导的竞赛（指导老师。）√
	 *   3.1）查看某个竞赛参与的组别(待审批、审批通过)。√ 
	 *     3.1.0）查看某个竞赛参与的组别。包括该组组员√ 
	 *     3.1.1）查看某个组别中的成员√ 
	 *   3.2）管理（拒绝/允许）某个报名竞赛的组别√
	 * 4.查看已经结束的竞赛。√ 
	 *   4.1）反馈竞赛结果 √ 
	 * 5.导出申报表√
	 * 6.审批员的功能
	 *    6.1系主任审批申报书√
	 *    6.2教学处审批申报书√
	 * 7.查找所有的教师√
	 * 8.获取所有的条件√
	 *   8.1根据type获取条件√
	 * 9.获取个人消息。√
	 * 10.待审核列表√
	 * 11.获取草稿箱的审批表。√
	 * 12.根据teacherno查找可报名的竞赛√
	 * 13.查找该教师负责或申报的竞赛√
	 * 14.查找comId竞赛未反馈获奖的组别√
	 */

	@Autowired
	private TeacherService teacherService;
	@Autowired
	private GroupsService groupsService;
	@Autowired
	private ConditionService conditionService;
	@Autowired
	private MessageMapper messageMapper;
	//@Autowired  
    //private HttpServletRequest request; 
	@Autowired  
	private CompetitionMapper comMapper;
	@Autowired  
	private ConditionsMapper conditionsMapper;

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
	@RequestMapping(value = "/updateTeacherInfo")
	public boolean updateTeacherInfo(@RequestBody Teacher teacher) {
		return teacherService.updateByTeacherNo(teacher);
	}

	/**
	 * 2.1根据teacherno查看申报列表及结果
	 * @param teacherNo
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/getCompResult")
	public List<Competition> getCompResult(Integer teacherNo) {
		return teacherService.getCompResults(teacherNo);
	}

	/**
	 * 2.1.2）查看申报书详情
	 * 
	 * @param comId
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/getCompDetail")
	public Map<String, Object> getCompDetail(Integer comId) {
		return teacherService.getCompDetail(comId);
	}

	/**
	 * 2.2）新增或保存申报书
	 * 
	 * @param comId
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/addOrUpdateComp")
	public CompetitionInfoVo addOrUpdateComp(@RequestBody CompetitionInfoVo competitionInfovo) {
		System.out.println(competitionInfovo);
		return teacherService.addOrUpdateComp(competitionInfovo);
	}

	/**
	 * 2.3删除申报表
	 * 
	 * @param comId
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/deleteComp")
	public void deleteComp(Integer comId) {
		teacherService.deleteComp(comId);
	} 
	
	/**
	 * 2.3）修改申报书
	 * 
	 * @param comId
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/updateComp")
	public void updateComp(@RequestBody CompetitionInfoVo compVo) {
		teacherService.updateComp(compVo);
	}
	/**
	 * 2.4查看所有申报书审批结果（列表以及结果。）
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/getAllCompResult")
	public List<Competition> getAllCompResult() {
		return teacherService.selectAllComp();
	}
	/**
	 * 2.5）查找该教师所负责 的竞赛（竞赛负责人，因为申报人不一定是负责人）
	 * @param teacherNo
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/getResponsibltyComp")
	public List<Competition> getResponsibltyComp(Integer leaderNo) {
		return teacherService.selectByLeaderNo(leaderNo);
	}
	
	/**
	 * 2.6）查找该教师所负责培训的竞赛（培训课时，教师）
	 * @param teacherNo
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/getSchComp")
	public List<Competition> getSchComp(Integer teacherno) {
		return teacherService.selectScheCompByTeacherNo(teacherno);
	}
	
	/**
	 * 2.7）查找该教师所指导的竞赛（指导老师。）
	 * @param teacherNo
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/getGuideComp")
	public List<Competition> getGuideComp(Integer teacherno) {
		return teacherService.selectGuideCompByTeacherNo(teacherno);
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
	 * 3.1.0）查看某个竞赛参与的组别。包括该组组员
	 * 
	 * @param comId
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/getCompGroupsAndMember")
	public List<Map<String,Object>> getCompGroupsAndMember(Integer comId) {
		return groupsService.getGroupsAndMember(comId);
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
		return teacherService.getGroupsMember(groupsNo);
	}

	/**
	 * 3.2）管理（拒绝/允许）某个报名竞赛的组别
	 * 
	 * @param teacherNo
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/manageGroupsMember")
	public boolean manageGroupsMember(Integer groupNo,Integer status) {
		Groups groups=new Groups();
		groups.setGroupsno(groupNo);
		groups.setStatus(status);
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
		return teacherService.getEndCompetition(teacherNo);
	}

	/**
	 * 4.1）反馈竞赛结果
	 * 
	 * @param awards
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/setCompResult")
	public void setCompResult(@RequestParam("file") MultipartFile file,Awards awards,HttpServletRequest request) throws IllegalStateException, IOException{
		// 判断文件是否为空  
        if (!file.isEmpty()) {  
            try {  
            	//文件名
            	String fileName="fileUpload/awards/"+UUID.randomUUID().toString()+".jpg";  
                // 文件保存路径  
                String filePath = request.getSession().getServletContext().getRealPath("/") +fileName;
                // 转存文件  
                file.transferTo(new File(filePath));  
				
				//保存进数据库
				awards.setAwardsimg(fileName);
				awards.setIspublish(0);
				teacherService.setCompResult(awards);
            } catch (Exception e) {  
                e.printStackTrace();  
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
	@RequestMapping("/getAprroveTable")    
    public ResponseEntity<byte[]> getAprroveTable(HttpServletRequest request,Integer comId) throws IOException {    
    	File file=teacherService.createWord(comId);

        HttpHeaders headers = new HttpHeaders();    

        String fileName=new String(file.getName().getBytes("UTF-8"),"iso-8859-1");

        headers.setContentDispositionFormData("attachment", fileName);   

        headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);   

        return new ResponseEntity<byte[]>(FileUtils.readFileToByteArray(file), headers, HttpStatus.CREATED);    

    } 
	
	/**
	 *测试
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value ="/getAprrove")    
	public  void getAprrove(Integer comId,HttpServletResponse response) throws UnsupportedEncodingException {
		
	}
	
	/**
	 * 6.1系主任审批申报书
	 * @param comId
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/updateCompStatusByDept")
	public void updateCompStatusByDept(@RequestBody Competition comp) {
		teacherService.updateCompStatusByDept(comp);
	}
	
	/**
	 * 6.2教学处审批申报书
	 * @param comId
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/updateCompStatusByTea")
	public void updateCompStatusByTea(@RequestBody Competition comp) {
		teacherService.updateCompStatusByTea(comp);
	}
	
	 
	 /**
	 * 7.查找所有的教师
     * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/getAllTeacher")
	public List<Teacher> getAllTeacher() {
		return teacherService.selectAllTeacher();
	}
	
	/**
	 * 8.获取所有的条件√
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/getAllConditions")
	public List<Conditions> getAllConditions(){
	    return conditionService.getAllCondition();
	}
	
	/**
	 * 8.1根据type获取条件√
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/getConditionsByType")
	public List<Conditions> getConditionsByType(Integer type){
	    return conditionsMapper.getConditionsByType(type);
	}
	
	/**
	 * 9.获取个人消息。√
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/getAllMessage")
	public List<Message> getAllMessage(String no){
	    return messageMapper.selectBysendtoNo(no);
	}
	/**
	 * 10.待审核列表
	 * @param teacherNo
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/getApproCompList")
	public List<Competition> getApproCompList(Integer teacherNo) {
		return teacherService.getApproCompList(teacherNo);
	}
	
	
	/**
	 * 11.获取草稿箱的审批表
	 * @param teacherNo
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/getNoSubmitComp")
	public List<Competition> getNoSubmitComp(Integer teacherNo) {
		return comMapper.selectNoSubmitByTeacherNo(teacherNo);
	}
    
	/**
	 * 12.根据teacherno查找可报名的竞赛
	 * @param teacherNo
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/getApplyComp")
	public List<Competition> getApplyComp(Integer teacherNo) {
		return comMapper.selectApplyCompByteacherNo(teacherNo);
	}
	
	/**
	 * 13.查找该教师负责或申报的竞赛
	 * 根据btnStatus去获取竞赛列表
	 *  0:所有
	 *  1：待审批 2.审批通过  3.审批不通过  
	 *  4：报名中，5：竞赛中，6：竞赛结束
	 * @param teacherNo
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/getResponOrApplyComp")
	public List<Competition> getResponOrApplyComp(Integer teacherNo,Integer btnStatus) {
		if (btnStatus==null) {
			btnStatus=0;
		}
		return teacherService.getCompByBtnStatus(btnStatus, teacherNo);
	}
	
	/**
	 * 14.查找comId竞赛未反馈获奖的组别√
	 * @param teacherNo
	 * @param btnStatus
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/getNotAwardsGroups")
	public List<Groups> getNotAwardsGroups(Integer comId) {
		return groupsService.getNotAwardsGroups(comId);
	}
}
