package com.cs.dao.condition;

import com.cs.pojo.Conditions;

public interface ConditionsMapper {
    int deleteByPrimaryKey(Integer conditionid);

    int insert(Conditions record);

    int insertSelective(Conditions record);

    Conditions selectByPrimaryKey(Integer conditionid);

    int updateByPrimaryKeySelective(Conditions record);

    int updateByPrimaryKey(Conditions record);
}