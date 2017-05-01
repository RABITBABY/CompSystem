package com.cs.dao.article;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.cs.pojo.Article;

public interface ArticleMapper {
	
	/** 获取某类型的一定数量文章*/
	List<Map> getMtypeList(Map map);
	List<Map> searchArticle(Map map);
	/**  获取所有该类型的文章数量   */
	int getTotal(String type);
	int searchTotal(Map map);
	/**  根据文章id获取文章的详细内容 */
	Map findById(int id);
	/**发布文章*/
	int insertArticle(Article article);
	/**删除文章*/
	int deleteArticle(int articleId );
	
	int updateArticle(Map map );
	
	int addVisit(int id);
}