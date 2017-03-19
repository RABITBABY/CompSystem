package com.cs.service.article;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.cs.pojo.Article;
@Service
public interface ArticleService {
	public List<Article> findByType(int type );
	public Map findArticleByType(int type );

}
