package com.cs.service.production;

import java.util.Map;

import org.springframework.stereotype.Service;

import com.cs.pojo.Production;
import com.cs.util.PageInfo;
@Service
public interface ProductionService {
	PageInfo productioList(Map map);
	 int insertProduction(Production production);
	 int updateProduction(Production production);
	 int delectProduction(int pId);
	
}
