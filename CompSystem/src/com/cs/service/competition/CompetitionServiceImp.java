package com.cs.service.competition;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cs.dao.competition.CompetitionMapper;
import com.cs.util.PageInfo;

@Service
public class CompetitionServiceImp implements CompetitionService {
@Autowired 
private CompetitionMapper compeMapper;
	
	/**
	 * 获取最近的竞赛活动
	 */
	@Override
	public PageInfo CompetitionList(Map map){
		Map param=new HashMap();
		int index=Integer.parseInt(map.get("index").toString());
		int pageSize=Integer.parseInt(map.get("pageSize").toString());
		int page=(index-1)*pageSize;
		param.put("page", page);
		param.put("pageSize", pageSize);
		param.put("department", map.get("department"));
		param.put("time", map.get("time"));
		
		System.out.println("CompetitionList--param"+param);
		List<Map<String,Object>> list=compeMapper.selectByAdmin(param);
		
		int total=compeMapper.getTotal();
		int totalPage=(int) Math.ceil(total/(pageSize*1.0));//总页数
		PageInfo pageInfo=new PageInfo();
		pageInfo.setList(list);
		pageInfo.setTotal(totalPage);
		pageInfo.setPageSize(pageSize);
		pageInfo.setIndex(index);
		return pageInfo;
	}

	
	
}
