package com.cs.dao.budget;

import com.cs.pojo.Budget;



public interface BudgetMapper {
    int deleteByPrimaryKey(Integer budgetid);

    int insert(Budget record);

    int insertSelective(Budget record);

    Budget selectByPrimaryKey(Integer budgetid);

    int updateByPrimaryKeySelective(Budget record);

    int updateByPrimaryKey(Budget record);
}