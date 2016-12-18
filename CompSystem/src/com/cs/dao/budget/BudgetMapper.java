package com.cs.dao.budget;

import java.util.List;

import com.cs.pojo.Budget;

public interface BudgetMapper {
	
	/**
	 * 根据ID查找
	 * 
	 * @param budgetid
	 * @return
	 */
	Budget selectByID(Integer budgetid);
	
	/**
	 * 批量插入预算。
	 * @param budgetid
	 * @return
	 */
	int addBudgetBatch(List<Budget> budgets);
	
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