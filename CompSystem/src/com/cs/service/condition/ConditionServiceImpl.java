package com.cs.service.condition;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cs.dao.compcondition.CompConditionMapper;
import com.cs.dao.condition.ConditionsMapper;
import com.cs.pojo.Conditions;
@Service("conditionService")
public class ConditionServiceImpl implements ConditionService{

	@Autowired
	private CompConditionMapper compConditionsMapper;
	@Autowired
	private ConditionsMapper conditionsMapper;
	@Override
	public List<Conditions> getCompCondition(Integer comId) {
		return compConditionsMapper.selectComId(comId);
	}
	@Override
	public List<Conditions> getAllCondition() {
		
		return conditionsMapper.selectAllConditions();
	}

}
