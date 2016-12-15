package com.cs.dao.condition;

import java.util.List;

import com.cs.pojo.Condition;
import com.cs.pojo.Teacher;

public interface ConditionMapper {
	
    /**
     * 根据教师职工号查找
     * @param teacherno
     * @return
     */
    Condition selectByConditionId(Integer conditionId);
    

}