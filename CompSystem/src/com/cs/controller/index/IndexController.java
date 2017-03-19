package com.cs.controller.index;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cs.pojo.Article;
import com.cs.service.article.ArticleService;

@Controller
@RequestMapping("/index")
public class IndexController {
	
	@Autowired
	ArticleService articlService;
	
	
	@ResponseBody
	@RequestMapping("/article1")
	public  List<Article> findByType(String type) {
		List<Article> articles=new ArrayList<Article>();
		articles=articlService.findByType(Integer.parseInt(type));
		System.out.println(articles);
		return articles;
	}
	
	@ResponseBody
	@RequestMapping("/article")
	public  Map findArticleByType(String type) {
		Map articles=new HashMap<String, Object>();
		articles=articlService.findArticleByType(Integer.parseInt(type));
		System.out.println("map"+articles);
		return articles;
	}
	
	
	
}
