package com.cs.service.award;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.cs.dao.awards.AwardsMapper;
import com.cs.util.PageInfo;
@Component
public class AwardsServiceImpl implements AwardsService{

	@Autowired
	private AwardsMapper awardsMapper;
	/**
	 * 获取最近获奖
	 */
	@Override
	public PageInfo getAwardsList(Map map) {
		
		int index=Integer.parseInt(map.get("index").toString());
		int pageSize=Integer.parseInt(map.get("pageSize").toString());
		int page=(index-1)*pageSize;
		Map param=new HashMap();
		param.put("page", page);
		param.put("pageSize", pageSize);
		param.put("department", map.get("department"));
		param.put("time", map.get("time"));
		System.out.println("参数"+param);
		List<Map> list=awardsMapper.getAwards(param);
		int totalPage=0;
		if(list.size() > 0){
			int total=awardsMapper.getTotal();
			totalPage=(int) Math.ceil(total/(pageSize*1.0));//总页数
		}
		PageInfo pageInfo=new PageInfo();
		pageInfo.setIndex(index);
		pageInfo.setList(list);
		pageInfo.setTotal(totalPage);
		pageInfo.setPageSize(pageSize);
		return pageInfo;
	}
	/**
	 * 获奖分析
	 */
	@Override
	public List<Map> analysisAwards(Map map) {
		List<Map> result =new ArrayList<Map>();
		result=awardsMapper.analysisAwards(map);
		return result;
	}
	@Override
	public List<Map> unPubAward() {
		return awardsMapper.unPubAward();
	}
	
	
	
	
}
