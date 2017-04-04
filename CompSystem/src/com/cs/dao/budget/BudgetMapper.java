package com.cs.dao.budget;

import java.util.List;

import com.cs.pojo.Budget;

public interface BudgetMapper {
	/*根据comId 查找budget*/
	List<Budget> selectByComId(Integer comId);
	
    int deleteByPrimaryKey(Integer budgetid);

    int insert(Budget record);

    int insertSelective(Budget record);

    Budget selectByPrimaryKey(Integer budgetid);

    int updateByPrimaryKeySelective(Budget record);

    int updateByPrimaryKey(Budget record);
}