package com.cs.dao.condition;

import java.util.List;

import com.cs.pojo.CompCondition;
import com.cs.pojo.Conditions;

public interface ConditionsMapper {
	
	List<Conditions> selectAllConditions();
	
    int deleteByPrimaryKey(Integer conditionid);

    int insert(Conditions record);

    int insertSelective(Conditions record);

    Conditions selectByPrimaryKey(Integer conditionid);

    int updateByPrimaryKeySelective(Conditions record);

    int updateByPrimaryKey(Conditions record);
    
    List<Conditions> getConditionsByType(Integer type);
}