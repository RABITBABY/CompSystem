package com.cs.dao.admin;

import com.cs.pojo.Administer;



public interface AdministerMapper {
	//删除根据Id
    int deleteByID(String adminno);
    //根据ID查找
    Administer selectByID(String adminno);
    
//    int insert(Administer record);
//    int insertSelective(Administer record);

}