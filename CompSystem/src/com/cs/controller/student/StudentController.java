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
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
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
import com.cs.service.student.StudentService;
import com.cs.service.teacher.TeacherService;


@Controller
@RequestMapping("/student")
public class StudentController {
	
	@Autowired
	private StudentService studentService;
		
	/**
	 * 获取学生已经报名的比赛
	 * @return
	 */
	/*@ResponseBody
	@RequestMapping("/getPro")
	public List<Project> getProInfo(@Param("studentNo") Integer studentNo){
		List<Project> projects = studentService.selectCompByStudentNo(studentNo);
		return projects;
	}*/
	
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
	 * 获取学生信息:包括基本信息和材料（包括已审批和等待审批）
	 * @param studentNo
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/getStuInfo")
	public Student getStuInfo(@Param("studentNo") Integer studentNo){
		return studentService.selectMaterialByNo(studentNo);
	}
	
	/**
	 * 学生报名竞赛：
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value="/toEntered",method = RequestMethod.POST)
	public void toEntered(@Param("comId") Integer comId,@Param("studentNo") Integer studentNo){
		//拿到竞赛id,找到竞赛所需的条件
		
		//根据学生id，找到符合的条件
		//比较，找出不满足的条件返回。
		/**
		 * class A{
		 *   isGroup:是否需要组队
		 *   a:判断是否符合条件。
		 *   List<Teacher>：指导老师
		 *   
		 * }
		 * 
		 * 拿到竞赛id,找到竞赛所需的条件
		 * if(竞赛所需的条件.type=1){//根据系别
		 *    判断学生的系别是否符合
		 *    if(不符合)--return 0;//系别不符合
		 *    if(符合){
		 *       if(竞赛所需的条件.type=0){//需要上传的图片的类型。
		 *           判断是否符合所需条件。
		 *           if(不符合){
		 *             返回，-1;//其他条件不符合
		 *           }else{
		 *             //符合，那么判断该比赛是否可以组队，
		 *             if(可以组队)
		 *             {
		 *                return Aclass;
		 *             }
		 *             else(不可以返回2){
		 *             
		 *             }
           
		 *           }
		 *           
		 *       }
		 *    }
		 * }
		 *
		 */
		
		
	}
	
	
	/**
	 * 保存学生报名信息。
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value="/saveEntered",method=RequestMethod.POST)
	public void saveEntered(Groups groups,List<Student> students){
	    //将学生保存到groups，和groupsDetail中
		
		
	}
	
	/**
	 * 修改学生个人信息。
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/updateInfo")
	public void updateInfo(Student student){
	    
	}
	
	/**
	 * 上传辅助材料。个人中心有上传按钮。点击上传，弹出框框，选择要上传什么材料，然后上传。
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/uploadMaterial")
	public void uploadMaterial(Material material){
	    
	}
	
}
