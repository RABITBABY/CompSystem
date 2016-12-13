package com.cs.dao.production;

import com.cs.pojo.Production;

public interface ProductionMapper {
    int deleteByPrimaryKey(Integer proid);

    int insert(Production record);

    int insertSelective(Production record);

    Production selectByPrimaryKey(Integer proid);

    int updateByPrimaryKeySelective(Production record);

    int updateByPrimaryKeyWithBLOBs(Production record);

    int updateByPrimaryKey(Production record);
}