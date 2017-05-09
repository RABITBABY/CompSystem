package com.cs.dao.model;

import java.util.List;
import java.util.Map;

import com.cs.pojo.Model;

public interface ModelMapper {
	
	int insertModel(Model model);
	
	int updateModel(Model model);
	
	int delectModel(int mid);
	
	List<Model> getAllModel(Map map);
	
	int getTotal();
}