package com.cs.controller.login;

import javax.servlet.http.HttpSession;

import org.apache.ibatis.annotations.Param;
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
import com.cs.service.administer.AdministerServiceImpl;
import com.cs.service.student.StudentService;
import com.cs.service.student.StudentServiceImpl;
import com.cs.service.teacher.TeacherService;
import com.cs.service.teacher.TeacherServiceImpl;

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
	 * @param role  角色222changed by hw
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/login" ,method=RequestMethod.POST)
	public Object IsAdmin(@RequestParam(value = "account",required=false) String account,
			@RequestParam(value = "password",required=false)String password,
			@RequestParam(value = "role",required=false) String role, 
			HttpSession session){
		System.out.println(password+"---"+account+"--"+role);
		//获取前台页面的信息---先判断角色色
		if("teacher".equals(role)){//教师
			Teacher teacher=teachImpl.selectByTeacherNo(Integer.parseInt(account));
			if(teacher!=null){
				if(password.equals(teacher.getPassword())){
					System.out.println(teacher);
					session.setAttribute("user", teacher); 
					if(teacher.getExaminer()==0){//教师
						return teacher;
					}else{//审批员
						return teacher;
					}
				}else{
					return "wrongPassword";
				}
			}else{
				return "wrongAccount";
			}
		}else if("student".equals(role)){//学生
			Student stu =stuImpl.selectByNo(Integer.parseInt(account));
			if(stu!=null){
				if(password.equals(stu.getPassword())){
					System.out.println(stu);
					session.setAttribute("user", stu); 
					return stu;
				}else{
					return "wrongPassword";
				}
			} else{
				return "wrongAcount";
			}
		}else if("admin".equals(role)){//管理员
			Administer admin=adminImpl.selectByID(account);
			if(admin!=null){
				if(password.equals(admin.getPassword())){
					System.out.println(admin);
					session.setAttribute("user", admin); 
					return admin;
				}else{
					return "wrongPassword";
				}
			}else{
				return "wrongAcount";
			}
		}
		return "wrongRole";
	}

	/**
	 * 获取登录用户的信息
	 * @param session
	 * @return
	 */
	@ResponseBody
	@RequestMapping("loginInfo")
	public Object LoginInfo(HttpSession session){
		Object obj=session.getAttribute("user");
		if(obj==null){
			return "null";
		}
		return obj;
	}
	/**
	 * 登出--删除用户登录的信息
	 * @param session
	 */
	@ResponseBody
	@RequestMapping("logOut")
	public void logOut(HttpSession session){
		session.removeAttribute("user");
	}
	
}
