package com.cs.dao.article;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.cs.pojo.Article;

public interface ArticleMapper {
	
	/**
	 * 获取某类型的一定数量文章
	 * @param map
	 * @return
	 */
	List<Map> getMtypeList(Map map);
	/**
	 * 获取所有该类型的文章数量
	 * @param type
	 * @return
	 */
	int getTotal(String type);
	
	/**
	 * 根据文章id获取文章的详细内容
	 * @param id
	 * @return
	 */
	Map findById(int id);
	
	
	
}