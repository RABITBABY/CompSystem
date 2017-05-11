package com.cs.service.competition;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cs.dao.competition.CompetitionMapper;
import com.cs.pojo.Competition;
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
		param.put("levelName", map.get("levelName"));
		param.put("department", map.get("department"));
		param.put("time", map.get("time"));
		
		System.out.println("CompetitionList--param"+param);
		List<Map<String,Object>> list=compeMapper.selectByAdmin(param);
		int totalPage=0;
		if(list.size() > 0){
			int total=compeMapper.getTotal(param);
			System.out.println("total总条数"+total);
			totalPage=(int) Math.ceil(total/(pageSize*1.0));//总页数
		}
		
		PageInfo pageInfo=new PageInfo();
		pageInfo.setList(list);
		pageInfo.setTotal(totalPage);
		pageInfo.setPageSize(pageSize);
		pageInfo.setIndex(index);
		return pageInfo;
	}

	

	@Override
	public List<Map> analysisComp(Map map) {
		List<Map> result=new ArrayList<Map>();
		result=compeMapper.analysisCom(map);
		return result;
	}



	@Override
	public List<Competition> beforeToday() {
		List<Competition> list=compeMapper.beforeToday();
		return list;
	}



	@Override
	public List<Competition> afterToday() {
		List<Competition> list=compeMapper.afterToday();
		return list;
	}



	@Override
	public List<Map> unPubCom(String department) {
		List<Map > list=new ArrayList<Map>();
		list=compeMapper.unPubCom(department);
		return list;
	}

	
	
}
