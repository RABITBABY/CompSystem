package com.cs.dao.awards;

import java.util.List;

import com.cs.pojo.Awards;
public interface AwardsMapper {
	/**
	 * 根据Id删除
	 * @param awardsid
	 * @return
	 */
    int deleteByPrimaryKey(Integer awardsid);
    /**
     * 增加学生获奖情况
     * @param record
     * @return
     */
    int addAwards(Awards record);
    /**
     * 动态进行数据插入
     * @param record
     * @return
     */
    int insertSelective(Awards record);

    /**
     * 根据ID查找
     * @param awardsid
     * @return
     */
    Awards selectByID(Integer awardsid);
    /**
     * 根据有的内容动态更新
     * @param record
     * @return
     */
    int updateByIDSelective(Awards record);
    /**
     * 根据Id更新全部
     * @param record
     * @return
     */
    int updateByID(Awards record);
    
    /**
     * 根据学号查看获奖情况
     * @param studentNo
     * @return
     */
    List<Awards> selectAwardsByStudentNo(Integer studentNo);
}