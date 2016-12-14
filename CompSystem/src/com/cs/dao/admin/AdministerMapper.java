package com.cs.dao.admin;

import com.cs.pojo.Administer;



public interface AdministerMapper {
	/**
	 * 删除根据Id
	 * @param adminno
	 * @return
	 */
    int deleteByID(String adminno);
    
    /**
     * 根据ID查找
     * @param adminno
     * @return
     */
    Administer selectByID(String adminno);
    
    /**
     * 动态更新内容
     * @param record
     * @return
     */
    int updateByIDSelective(Administer record);
    
//    int insert(Administer record);
//    int insertSelective(Administer record);

}