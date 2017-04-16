package com.cs.service.article;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cs.dao.article.ArticleMapper;
import com.cs.util.PageInfo;

@Component
public class ArticleServiceImpl implements ArticleService {
	@Autowired
	private ArticleMapper mapper;

	


	@Override
	public PageInfo getMtypeList(Map<String,Object> map) {
		int indexpage=Integer.parseInt(map.get("page").toString());
		int pageSize=Integer.parseInt(map.get("pageSize").toString());
		indexpage=(indexpage-1)*pageSize;
		map.put("page", indexpage);
		map.put("pageSize", pageSize);
		System.out.println("参数"+map);
		List<Map> list=mapper.getMtypeList(map);
		int total=mapper.getTotal((String)map.get("type"));
		PageInfo page=new PageInfo();
		page.setList(list);
		page.setTotal(total);
		return page;
	}

}
