package com.cs.dao.article;

import com.cs.pojo.Article;

public interface ArticleMapper {
	// 根据ID删除
	int deleteByID(Integer articleid);

	// 插入增加一篇文章
	int insert(Article record);

	// 选择性插入 空的就不插入
	int insertSelective(Article record);

	// 根据Id查找
	Article selectByID(Integer articleid);

	// 更新文章 选择性更新
	int updateByIDSelective(Article record);

	// 跟新全部
	int updateByIDWithBLOBs(Article record);

}