package com.cs.controller.admin;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

import com.cs.pojo.Article;
import com.cs.service.administer.AdministerServiceImpl;
import com.cs.service.article.ArticleServiceImpl;

@Controller
@RequestMapping("/admin")
public class AdministerController {
	
	@Autowired
	ArticleServiceImpl articlImpl;
	@Autowired
	AdministerServiceImpl adminImpl;
	
	/**
	 * 获取不同类型的文章---前台需要传递一个参数type--文章类型
	 * @param request
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/article")
	public  List<Article> findByType(int type) {
		/*if(request.getParameter("type")!=null){
			
			int type=Integer.parseInt(request.getParameter("type"));
			System.out.println("---------------type"+type);
		}*/
		List<Article> articles=articlImpl.findByType(type);
		for (Article a : articles	) {
			System.out.println(a);
		}
		return articles;
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
	@RequestMapping("/saveFile")
	public void saveFile(HttpServletRequest request) throws IllegalStateException, IOException{
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
					//下载的位置-----------------------------------------
					String path="E:/"+file.getOriginalFilename();
					//上传
					file.transferTo(new File(path));
				}
			}
		
		}
	}
	
}
