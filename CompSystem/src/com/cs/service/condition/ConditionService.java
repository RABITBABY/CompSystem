package com.cs.service.condition;

import java.util.List;

import com.cs.pojo.Conditions;

public interface ConditionService {

	/**
	 * 根据comId获取报名该竞赛所需要的条件
	 * @param comId
	 * @return
	 */
	List<Conditions> getCompCondition(Integer comId);
	
	/**
	 * 获取所有竞赛条件
	 * @param comId
	 * @return
	 */
	List<Conditions> getAllCondition();
}
