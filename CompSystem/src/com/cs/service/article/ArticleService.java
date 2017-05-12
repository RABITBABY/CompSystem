package com.cs.service.article;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.cs.pojo.Article;
import com.cs.util.PageInfo;
@Service
public interface ArticleService {
	PageInfo getArticleList(Map map);
	public PageInfo indexArticleList(Map map);
	PageInfo searchArticle(Map map);
	
	Map getArticleByID(int articleID);
	
	 Map getArticleByComp(Map map);
	
	int insertArticle(Article article);
	
	int deleteArticle(int articleId,int rid,int type );
	
	int updateArticle(int articleId,String title,String content);
	
	void addVisit(int id);
	String initArticleDetail(String comId);
	List getHotArticle();
}
