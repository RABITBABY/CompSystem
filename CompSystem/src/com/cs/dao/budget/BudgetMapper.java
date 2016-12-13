package com.cs.dao.budget;

import com.cs.pojo.Budget;

public interface BudgetMapper {
	/**
	 * 根据Id删除
	 * 
	 * @param budgetid
	 * @return
	 */
	int deleteID(Integer budgetid);

	/**
	 * 全部插入
	 * 
	 * @param record
	 * @return
	 */
	int insert(Budget record);

	/**
	 * 动态插入
	 * 
	 * @param record
	 * @return
	 */
	int insertSelective(Budget record);

	/**
	 * 根据ID查找
	 * 
	 * @param budgetid
	 * @return
	 */
	Budget selectByID(Integer budgetid);

	/**
	 * 动态更新
	 * 
	 * @param record
	 * @return
	 */
	int updateByIDSelective(Budget record);

	/**
	 * 全部更新
	 * 
	 * @param record
	 * @return
	 */
	int updateID(Budget record);
}