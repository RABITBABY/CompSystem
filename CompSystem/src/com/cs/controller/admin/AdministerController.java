package com.cs.controller.admin;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.Iterator;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

import com.cs.pojo.FileUpload;
import com.cs.service.administer.AdministerServiceImpl;
import com.cs.service.article.ArticleServiceImpl;
import com.cs.service.fileUpload.FileUploadService;



@Controller
@RequestMapping("/admin")
public class AdministerController {
	
	@Autowired
	ArticleServiceImpl articlImpl;
	
	@Autowired
	AdministerServiceImpl adminImpl;
	
	@Autowired
	FileUploadService fileImpl;
	
	/**
	 * 获取不同类型的文章---前台需要传递一个参数type--文章类型
	 * @param request
	 * @return
	 *//*
	@ResponseBody
	@RequestMapping("/article")
	public  List<Article> findByType(int type) {
		if(request.getParameter("type")!=null){
			
			int type=Integer.parseInt(request.getParameter("type"));
			System.out.println("---------------type"+type);
		}
		List<Article> articles=articlImpl.findByType(type);
		for (Article a : articles	) {
			System.out.println(a);
		}
		return articles;
	}*/
	
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
               int insertStatue= fileImpl.insertFile(fileUpload);
               if(insertStatue>0){
            	   statueCode="1";
               }
            }  
		}
        return statueCode;
	}
	
	
	
	
	
}
