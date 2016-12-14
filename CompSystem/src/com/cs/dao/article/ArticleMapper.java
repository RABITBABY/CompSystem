package com.cs.dao.article;

import java.util.List;

import com.cs.pojo.Article;

public interface ArticleMapper {
	/**
	 *  根据ID删除
	 * @param articleid
	 * @return
	 */
	int deleteByID(Integer articleid);

	/**
	 * 插入增加一篇文章
	 * @param record
	 * @return
	 */
	int insert(Article record);

	/**
	 *  选择性插入 空的就不插入
	 * @param record
	 * @return
	 */
	int insertSelective(Article record);

	/**
	 *  根据Id查找
	 * @param articleid
	 * @return
	 */
	Article selectByID(Integer articleid);

	/**
	 *  更新文章 选择性更新
	 * @param record
	 * @return
	 */
	int updateByIDSelective(Article record);

	/**
	 * 跟新全部
	 * @param record
	 * @return
	 */
	int updateByIDWithBLOBs(Article record);
	/**
	 * 查询不同种类的文章  
	 * 1--竞赛征文  2--动态  3--获奖信息
	 * @param type
	 * @return
	 */
	List<Article> findByType(int type);
	
}