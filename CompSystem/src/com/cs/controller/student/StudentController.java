package com.cs.controller.student;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.ModelAndView;

import com.cs.dao.material.MaterialMapper;
import com.cs.pojo.Conditions;
import com.cs.pojo.Material;
import com.cs.pojo.Student;
import com.cs.service.condition.ConditionService;
import com.cs.service.student.StudentService;



@Controller
@RequestMapping("/student")
public class StudentController {
	/**
	 * 1.报名
	 *   1.1获取该竞赛所需的条件√
	 *   1.2判断该学生不符合的条件√
	 *   1.3个人信息：证书、学生证等的上传√
	 *   1.4报名竞赛
	 *   1.5加入一个队伍
	 *   1.6创建队伍
	 * 2.查看报名结果√
	 * 3.缴纳比赛费用
	 * 4.查询获奖情况√
	 * 5.下载相关文件（获奖证书）
	 * 6.查看个人信息。√
	 *   6.1修改个人信息。√
	 */
	@Autowired
	private StudentService studentService;
	@Autowired
	private ConditionService conditionService;
	@Autowired
	private MaterialMapper materialMapper;
	
	/**
	 * 1.1 获取该竞赛所需的条件
	 * groups表和competition表
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/getCompConditions")
	public List<Conditions> getCompConditions(){
		return conditionService.getCompCondition(1);
	}
	
	
	/**
	 * 1.2判断该学生不符合的条件
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/getDissatisfyConditions")
	public List<Conditions> getDissatisfyConditions(){
		return studentService.getDissatisfyConditions(1, 1);
	}
	
	/**
	 * 1.3个人信息：证书、学生证等的上传
	 * @param request
	 * @throws IllegalStateException
	 * @throws IOException
	 */
	@ResponseBody
	@RequestMapping("/saveMaterial")
	public void saveMaterial(HttpServletRequest request,Material material) throws IllegalStateException, IOException{
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
					String imageName=material.getStudentno().toString()+System.currentTimeMillis();
					//上传的位置-----------------------------------------
					String path=request.getSession().getServletContext().getRealPath(File.separator)+"fileUpload\\material\\"+imageName;
					//上传
					file.transferTo(new File(path));
					
					//保存进数据库
					material.setMaterialpic(imageName);
					materialMapper.insert(material);
				}
			}
		
		}
		
		
	}
	
	/**
	 * 2.查看报名结果
	 * groups表和competition表
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/getComp")
	public Map<String, Object> getComp(){
		Map<String, Object> map=new HashMap<String, Object>();
		map.put("stuCom", studentService.getCompByStudentNo(1));
		return map;
	}
	
	/**
	 * 3.缴纳比赛费用
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/getAwards")
	public Map<String, Object> getAwards(){
		Map<String, Object> map=new HashMap<String, Object>();
		map.put("stuAwards", studentService.selectAwardsByStudentNo(1));
		return map;
	}
	
	
	/**
	 * 6.查看个人信息。
	 * 获取学生信息:包括基本信息和材料（包括已审批和等待审批）
	 * @param studentNo
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/getStuInfo")
	public Student getStuInfo(@Param("studentNo") Integer studentNo){
		return studentService.selectByNo(studentNo);
	}
	
	/**
	 * 6.1修改个人信息。
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/updateInfo")
	public int updateStuInfo(Student student){
	    return studentService.updateByNo(student);
	}
	
}
