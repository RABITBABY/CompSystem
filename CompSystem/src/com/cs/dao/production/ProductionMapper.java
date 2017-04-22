package com.cs.dao.production;

import java.util.List;
import java.util.Map;

import com.cs.pojo.Production;


public interface ProductionMapper {
   List<Production> getProduction(Map map); //分页获取
   int getTotal();
   Production getProductionByID(int proId); 
   int insertProduction(Production production);
   int updateByPrimaryId(Production production);
   int deleteProduction(int pId);
}