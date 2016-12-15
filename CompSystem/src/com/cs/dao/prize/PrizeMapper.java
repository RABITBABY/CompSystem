package com.cs.dao.prize;

import com.cs.pojo.Prize;

public interface PrizeMapper {
    int deleteByID(Integer prizeid);

    int insert(Prize record);

    int insertSelective(Prize record);

    Prize selectByID(Integer prizeid);

    int updateByIDSelective(Prize record);

    int updateByID(Prize record);
}