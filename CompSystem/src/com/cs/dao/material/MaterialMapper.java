package com.cs.dao.material;

import java.util.List;
import java.util.Map;

import com.cs.pojo.Material;

public interface MaterialMapper {
	
	List<Material> selectByStudentno(Object object);
	
    int deleteByPrimaryKey(Integer materialid);

    int insert(Material record);

    int insertSelective(Material record);

    Material selectByPrimaryKey(Integer materialid);

    int updateByPrimaryKeySelective(Material record);

    int updateByPrimaryKey(Material record);
    //max
    List<Map> allMaterial(Map map);
    
    int MaterialCount();
    
    int updateState(int id);
}