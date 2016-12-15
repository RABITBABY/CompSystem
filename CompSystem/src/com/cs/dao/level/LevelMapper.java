package com.cs.dao.level;

import com.cs.pojo.Level;

public interface LevelMapper {
    int deleteByID(Integer levelid);

    int insert(Level record);

    int insertSelective(Level record);

    Level selectByID(Integer levelid);

    int updateByIDSelective(Level record);

    int updateByID(Level record);
}