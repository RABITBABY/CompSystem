package com.cs.service.model;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.cs.pojo.Model;
import com.cs.util.PageInfo;

@Service
public interface ModelService {
	
	
	int insertModel(Model model);
	
	int updateModel(Model model);
	
	int delectModel(int mid);
	
	PageInfo<Map> getAllModel(Map map);
	
}
