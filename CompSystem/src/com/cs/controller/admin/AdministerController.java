package com.cs.controller.admin;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

import com.cs.pojo.Competition;
import com.cs.pojo.FileUpload;
import com.cs.service.administer.AdministerServiceImpl;
import com.cs.service.article.ArticleServiceImpl;
import com.cs.service.fileUpload.FileUploadService;
import com.cs.util.PageInfo;
import com.cs.util.ParamUtil;



@Controller
@RequestMapping("/admin")
public class AdministerController {

	@Autowired
	AdministerServiceImpl adminImpl;
	
	
	
	
	/**
	 * 获取近期的竞赛（可以报名）
	 * @param type
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/CompetionList")
	public  Map CompetitionList(String department,String time,String index,String pageSize) {
		Map<String ,Object> resultMap=new HashMap<String, Object>();
		Map<String ,Object> param=new HashMap<String, Object>();
		department=ParamUtil.getStr(department, "");
		time=ParamUtil.getStr(time, "");
		index=ParamUtil.getStr(index, "1");
		pageSize=ParamUtil.getStr(pageSize, "10");
		int page=(Integer.parseInt(index)-1)*Integer.parseInt(pageSize);
		param.put("department", department);
		param.put("time", time);	
		param.put("index", index);	
		param.put("page", page);	
		param.put("pageSize", pageSize);	
		
		PageInfo pageInfo=new PageInfo();
		
		pageInfo=adminImpl.CompetitionList(param);
		
		resultMap.put("comPageInfo", pageInfo);
		System.out.println(param+"\n"+resultMap);
		
		return resultMap;
	}
	
	/**
	 * 分页根据文章类型找到相关文章
	 * @param type 文章类型
	 * @param page 页数
	 * @param pageSize 每页数量 
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value="/article", method = RequestMethod.GET)
	public  Map findArticleByType(String type,String index,String pageSize) {
		
		Map<String,Object> result=new HashMap<String, Object>();
		Map<String,Object> param=new HashMap<String, Object>();
		
		
		type=ParamUtil.getStr(type, "1");
		index=ParamUtil.getStr(index, "1");
		pageSize=ParamUtil.getStr(pageSize, "10");
		
		
		param.put("type", type);
		param.put("index", index);
		param.put("pageSize",pageSize);
		
		PageInfo pageInfo=adminImpl.getArticleList(param);
		result.put("articlePageInfo",pageInfo );
		return result;
	}
	
	
	
	

	
	@RequestMapping("/saveArticle")
	public void saveArticle(){
		//获取文章对象需要的东西--标题，内容，文章类型
		
		//获取当前登录的管理员ID
		
		//获取当前时间
		
	}
	
	/**
	 * 文件上传
	 * @param request
	 * @throws IllegalStateException
	 * @throws IOException
	 */
	@ResponseBody
	@RequestMapping("/uploadFile")
	public String saveFile(HttpServletRequest request,HttpServletResponse response) throws IllegalStateException, IOException{
		String statueCode="0"; 
		//获取解析器  
        CommonsMultipartResolver resolver = new CommonsMultipartResolver(request.getSession().getServletContext());  
        //判断是否是文件  
        if(resolver.isMultipart(request)){  
            //进行转换  
            MultipartHttpServletRequest multiRequest = (MultipartHttpServletRequest)(request);  
            //获取所有文件名称  
            Iterator<String> it = multiRequest.getFileNames();  
            while(it.hasNext()){  
                //根据文件名称取文件  
                MultipartFile file = multiRequest.getFile(it.next());  
                String fileName = file.getOriginalFilename();  //文件名
                String uploadName = String.valueOf( System.currentTimeMillis());//时间戳字符串
                
                String path = request.getSession().getServletContext().getRealPath("/WEB-INF/uploadFile");  
                path=path+"/"+fileName;
                System.out.println("path:"+path+"\n uploadName:"+uploadName);
                String localPath = path ;  
                File newFile = new File(localPath);  
                //上传的文件写入到指定的文件中  
                file.transferTo(newFile);  
                           
                //获取当前用户的ID
               Map userInfo=(Map)request.getSession().getAttribute("loginInfo");
               String adminNo=(String) userInfo.get("userId");
                //保存进数据库
                FileUpload fileUpload=new FileUpload();
                fileUpload.setUploaddate(new Date());
                fileUpload.setSavename(uploadName);
                fileUpload.setFilename(fileName);
                fileUpload.setUploaduserno(adminNo);
                System.out.println(fileUpload);
               int insertStatue= adminImpl.insertFile(fileUpload);
               if(insertStatue>0){
            	   statueCode="1";
               }
            }  
		}
        return statueCode;
	}
	
	
	/**
	 * 优秀作品列表
	 * @param request
	 * @param response
	 * @return
	 */
	
	
	/**
	 * 上传优秀作品
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping("/uploadProduction")
	public Map uploadProduction(HttpServletRequest request,HttpServletResponse response){
		
		
		return null;
	}
	
	
	
	
	
	
	
}
