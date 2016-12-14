package com.cs.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cs.pojo.Article;
import com.cs.service.article.ArticleServiceImpl;

@Controller
@RequestMapping("/admin")
public class AdministerController {
	
	@Autowired
	ArticleServiceImpl articlImpl;
	
	/**
	 * 获取不同类型的文章---前台需要传递一个参数type--文章类型
	 * @param request
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/article")
	public  List<Article> findByType(HttpServletRequest request) {
		if(request.getParameter("type")!=null){
			
			int type=Integer.parseInt(request.getParameter("type"));
			System.out.println("---------------type"+type);
		}
		List<Article> articles=articlImpl.findByType(1);
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
	
	
}
