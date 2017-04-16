package com.cs.controller.index;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cs.service.article.ArticleService;
import com.cs.util.PageInfo;
import com.cs.util.ParamUtil;

@Controller
@RequestMapping("/index")
public class IndexController {
	
	@Autowired
	ArticleService articlService;
	
	/**
	 * 分页根据文章类型找到相关文章
	 * @param type 文章类型
	 * @param page 页数
	 * @param pageSize 每页数量 
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value="/article", method = RequestMethod.GET)
	public  List<Map<String,Object>> findArticleByType(String type,String page,String pageSize) {
		List<Map<String,Object>> resutList=new ArrayList<Map<String,Object>>();
		
		Map<String,Object> result=new HashMap<String, Object>();
		Map<String,Object> map=new HashMap<String, Object>();
		type=ParamUtil.getStr(type, "1");
		page=ParamUtil.getStr(page, "1");
		pageSize=ParamUtil.getStr(pageSize, "10");
		map.put("type", type);
		map.put("page", page);
		map.put("pageSize", pageSize);
		PageInfo pageInfo=articlService.getMtypeList(map);
		result.put("list",pageInfo.getList() );
		result.put("total", pageInfo.getTotal());
		resutList.add(result);
		return resutList;
	}
	
	
	
	
	
}
