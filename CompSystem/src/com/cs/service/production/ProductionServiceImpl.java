package com.cs.service.production;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.cs.dao.production.ProductionMapper;
import com.cs.pojo.Production;
import com.cs.util.PageInfo;
@Service
public class ProductionServiceImpl implements ProductionService {
	@Autowired
	private ProductionMapper productionMapper;
	
	/**
	 * 获取最近的优秀作品
	 */
	@Override
	public PageInfo productioList(Map map) {
		Map param=new HashMap();
		int index=Integer.parseInt(map.get("index").toString());
		int pageSize=Integer.parseInt(map.get("pageSize").toString());
		int page=(index-1)*pageSize;
		param.put("page", page);
		param.put("pageSize", pageSize);
		
		System.out.println("productioList--param"+param);
		
		List<Production> list=productionMapper.getProduction(param);
		
		int total=productionMapper.getTotal();
		int totalPage=(int) Math.ceil(total/(pageSize*1.0));//总页数
		PageInfo pageInfo=new PageInfo();
		pageInfo.setList(list);
		pageInfo.setTotal(totalPage);
		pageInfo.setPageSize(pageSize);
		pageInfo.setIndex(index);
		return pageInfo;
	}

	@Override
	public int insertProduction(Production production) {
		int stateCode=0;
		if(production!=null){
			productionMapper.insertProduction(production);
		}
		return stateCode;
	}

	@Override
	public int updateProduction(Production production) {
		
		int stateCode=0;
		if(production!=null){
			productionMapper.updateByPrimaryId(production);
		}
		return stateCode;
	}

	@Override
	public int delectProduction(int pId) {
		int stateCode=productionMapper.deleteProduction(pId);
		return stateCode;
	}
}
