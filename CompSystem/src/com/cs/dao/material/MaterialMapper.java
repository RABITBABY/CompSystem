package com.cs.dao.material;

import com.cs.pojo.Material;

public interface MaterialMapper {
    int deleteByPrimaryKey(Integer materialid);

    int insert(Material record);

    int insertSelective(Material record);

    Material selectByMaterialId(Integer materialid);

    int updateByPrimaryKeySelective(Material record);

    int updateByPrimaryKey(Material record);
}