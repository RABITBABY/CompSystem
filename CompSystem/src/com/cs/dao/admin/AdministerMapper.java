package com.cs.dao.admin;

import com.cs.pojo.Administer;



public interface AdministerMapper {
    int deleteByPrimaryKey(String adminno);

    int insert(Administer record);

    int insertSelective(Administer record);

    Administer selectByPrimaryKey(String adminno);

    int updateByPrimaryKeySelective(Administer record);

    int updateByPrimaryKey(Administer record);
}