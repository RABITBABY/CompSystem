package com.cs.controller.login;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cs.pojo.Administer;
import com.cs.pojo.Student;
import com.cs.pojo.Teacher;
import com.cs.service.administer.AdministerService;
import com.cs.service.student.StudentService;
import com.cs.service.teacher.TeacherService;

@Controller
public class LoginController {
	
	@Autowired
	AdministerService adminImpl;
	@Autowired
	StudentService stuImpl;
	@Autowired
	TeacherService teachImpl;
	
	
	/**
	 * 判断登录的方法
	 * @param username  用户名
	 * @param password  密码
	 * @param role  角色0dsfhjsdfhsdgfds
	 * skdfkj 

	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/login" ,method=RequestMethod.POST)
	public Map IsAdmin(@RequestParam(value = "account",required=false) String account,
			@RequestParam(value = "password",required=false)String password,
			@RequestParam(value = "role",required=false) String role, 
			HttpSession session){
		
		Map<String , Object> resultMap=new HashMap<String, Object>();
		Map<String , Object> resultMap1=new HashMap<String, Object>();
		String stateCode="1";
		String info="";
		String userId="";
		String userName="";
		String roleNum="";//1--教师，2--审批员，3--学生，4--管理员
		String resultStr="";
		//显示传递的数据
		System.out.println(password+"---"+account+"--"+role);
		
		
		//获取前台页面的信息---先判断角色色
		if("teacher".equals(role)){//教师
			
			Teacher teacher=teachImpl.selectByTeacherNo(Integer.parseInt(account));
			
			if(teacher!=null){
				if(password.equals(teacher.getPassword())){
					System.out.println(teacher);
					session.setAttribute("user", teacher); 
					if(teacher.getExaminer()==0){//教师
						roleNum="1";
						resultStr="teacher";
					}else{//审批员
						roleNum="2";
						resultStr="examiner";
					}
					userId=String.valueOf(teacher.getTeacherno());
					userName=teacher.getTeachername();
					resultMap1.put("user", teacher);
					info= "success";
				}else{
					stateCode="0";
					info= "wrongPassword";
				}
			}else{
				stateCode="0";
				info= "wrongAccount";
			}
			
		}else if("student".equals(role)){//学生
			Student stu =stuImpl.selectByNo(Integer.parseInt(account));
			if(stu!=null){
				if(password.equals(stu.getPassword())){
					roleNum="3";
					userId=String.valueOf(stu.getStudentno());
					userName=stu.getStudentname();
					info= "success";
					resultStr="student";
					resultMap1.put("user", stu);
				}else{
					stateCode="0";
					info= "wrongPassword";
				}
			} else{
				stateCode="0";
				info= "wrongAcount";
			}
		}else if("admin".equals(role)){//管理员
			Administer admin=adminImpl.selectByID(account);
			if(admin!=null){
				if(password.equals(admin.getPassword())){
					roleNum="4";
					userId=admin.getAdminno();
					userName=admin.getAdminname();
					info= "success";
					resultStr="admin";
					resultMap1.put("user", admin);
				}else{
					stateCode="0";
					info= "wrongPassword";
				}
			}else{
				stateCode="0";
				info= "wrongAcount";
			}
		}
		resultMap.put("stateCode", stateCode);
		resultMap.put("info", info);
		resultMap.put("userId", userId);
		resultMap.put("userName", userName);
		resultMap.put("roleNum", roleNum);
		resultMap.put("resultStr", resultStr);
		System.out.println("resultMap"+resultMap);
		if("1".equals(stateCode)){
			
			session.setAttribute("loginInfo", resultMap);
		}
		return resultMap1;
		
	}

	@ResponseBody
	@RequestMapping(value = "/signIn")
	public Map login(String account,String password, String role, HttpServletRequest request){
		
		Map<String , Object> resultMap=new HashMap<String, Object>();
		String stateCode="1";
		String info="";
		String userId="";
		String userName="";
		String roleNum="";//1--教师，2--审批员，3--学生，4--管理员
		//显示传递的数据
		System.out.println(password+"---"+account+"--"+role);
		
		
		//获取前台页面的信息---先判断角色色
		if("teacher".equals(role)){//教师
			
			Teacher teacher=teachImpl.selectByTeacherNo(Integer.parseInt(account));
			
			if(teacher!=null){
				if(password.equals(teacher.getPassword())){
					System.out.println(teacher);
					request.getSession().setAttribute("user", teacher); 
					if(teacher.getExaminer()==0){//教师
						roleNum="1";
					}else{//审批员
						roleNum="2";
					}
					userId=String.valueOf(teacher.getTeacherno());
					userName=teacher.getTeachername();
					info= "success";
					request.getSession().setAttribute("teacher", teacher);
				}else{
					stateCode="0";
					info= "wrongPassword";
				}
			}else{
				stateCode="0";
				info= "wrongAccount";
			}
			
		}else if("student".equals(role)){//学生
			Student stu =stuImpl.selectByNo(Integer.parseInt(account));
			if(stu!=null){
				if(password.equals(stu.getPassword())){
					roleNum="3";
					userId=String.valueOf(stu.getStudentno());
					userName=stu.getStudentname();
					info= "success";
					request.getSession().setAttribute("student", stu);
				}else{
					stateCode="0";
					info= "wrongPassword";
				}
			} else{
				stateCode="0";
				info= "wrongAcount";
			}
		}else if("admin".equals(role)){//管理员
			Administer admin=adminImpl.selectByID(account);
			if(admin!=null){
				if(password.equals(admin.getPassword())){
					roleNum="4";
					userId=admin.getAdminno();
					userName=admin.getAdminname();
					info= "success";
					request.getSession().setAttribute("admin", admin);
				}else{
					stateCode="0";
					info= "wrongPassword";
				}
			}else{
				stateCode="0";
				info= "wrongAcount";
			}
		}
		resultMap.put("stateCode", stateCode);
		resultMap.put("info", info);
		resultMap.put("userId", userId);
		resultMap.put("userName", userName);
		resultMap.put("roleNum", roleNum);
		System.out.println("resultMap"+resultMap);
		if("1".equals(stateCode)){
			
			request.getSession().setAttribute("loginInfo", resultMap);
		}
		return resultMap;
	}

	
	
	/**
	 * 获取登录用户的信息
	 * @param session
	 * @return
	 */
	@ResponseBody
	@RequestMapping("loginInfo")
	public Map LoginInfo(HttpSession session){
		Map< String, Object> resultMap=new HashMap<String, Object>();
		String stateCode="1";
		resultMap=(Map)session.getAttribute("loginInfo");
		if(resultMap==null){
			stateCode="0";
		}
		return resultMap;
	}
	/**
	 * 登出--删除用户登录的信息
	 * @param session
	 */
	@ResponseBody
	@RequestMapping("logOut")
	public void logOut(HttpSession session){
		session.removeAttribute("loginInfo");
	}
	
}
