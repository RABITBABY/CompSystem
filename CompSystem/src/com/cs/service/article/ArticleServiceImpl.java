package com.cs.service.article;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cs.dao.article.ArticleMapper;
import com.cs.pojo.Article;

@Component
public class ArticleServiceImpl implements ArticleService {
	@Autowired
	private ArticleMapper mapper;

	
	@Override
	public List<Article> findByType(int type) {
		List<Article> articles= mapper.findByType(type);
		System.out.println("article"+articles);
		return articles;
	}
	
	@Override
	public Map findArticleByType(int type) {
		Map articles= (Map) mapper.findByType(type);
		System.out.println("article"+articles);
		return articles;
	}

}
