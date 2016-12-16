package com.cs.dao.condition;

import java.util.List;

import com.cs.pojo.Condition;
import com.cs.pojo.Teacher;

public interface ConditionMapper {
	
    /**
     * 根据id查找
     * @param teacherno
     * @return
     */
    Condition selectByConditionId(Integer conditionId);
    
    /**
     * 根据学号查找通过审核 的条件
     * @param teacherno
     * @return
     */
    List<Condition> selectPassConditions(Integer studentNo);
    

}