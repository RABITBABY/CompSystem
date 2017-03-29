package com.cs.dao.production;

import java.util.List;
import java.util.Map;

import com.cs.pojo.Production;


public interface ProductionMapper {
   List<Production> getAllProduction(Map map); 
   Production getProductionByID(int proId); 
   int insertProduction(Production production);
   int updateByPrimaryId(Production production);
}