package com.cs.service.article;

import java.util.List;

import org.springframework.stereotype.Service;

import com.cs.pojo.Article;
@Service
public interface ArticleService {
	List<Article> findByType(int type);

}
