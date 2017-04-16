package com.cs.dao.compcondition;

import java.util.List;

import com.cs.pojo.CompCondition;
import com.cs.pojo.Conditions;

public interface CompConditionMapper {
	int addCompConditionBatch(List<CompCondition> compConditions);
	
	int updateByPrimaryKeySelective(CompCondition compCondition);
	
	int deleteByComId(Integer comId);
	
	List<Conditions> selectComId(Integer comId);
	
    int insert(CompCondition record);

    int insertSelective(CompCondition record);
}