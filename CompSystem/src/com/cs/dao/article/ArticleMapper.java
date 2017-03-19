package com.cs.dao.article;

import java.util.List;
import java.util.Map;

import com.cs.pojo.Article;

public interface ArticleMapper {
   public List<Article> findByType(int type);
   public Map findArticleByType(int type);
}