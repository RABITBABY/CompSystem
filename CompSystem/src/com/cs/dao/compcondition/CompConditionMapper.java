package com.cs.dao.compcondition;

import com.cs.pojo.CompCondition;

public interface CompConditionMapper {
    int insert(CompCondition record);

    int insertSelective(CompCondition record);
}