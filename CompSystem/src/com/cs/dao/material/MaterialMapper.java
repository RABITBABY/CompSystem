package com.cs.dao.material;

import java.util.List;

import com.cs.pojo.Condition;
import com.cs.pojo.Material;

public interface MaterialMapper {
	/**
	 * 根据学生No，获取学生材料
	 * @param conditionId
	 * @return
	 */
	List<Material> selectByStudentNo(Integer studentNo);
	
    int deleteByPrimaryKey(Integer materialid);

    int insert(Material record);

    int insertSelective(Material record);

    Material selectByMaterialId(Integer materialid);

    int updateByPrimaryKeySelective(Material record);

    int updateByPrimaryKey(Material record);
}
