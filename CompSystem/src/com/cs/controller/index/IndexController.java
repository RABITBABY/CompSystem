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
import com.cs.service.production.ProductionService;
import com.cs.util.PageInfo;
import com.cs.util.ParamUtil;

@Controller
@RequestMapping("/index")
public class IndexController {
	
	@Autowired
	ArticleService articlService;
	
	@Autowired
	ProductionService productionService;
	
	/**
	 * 分页根据文章类型找到相关文章
	 * @param type 文章类型
	 * @param page 页数
	 * @param pageSize 每页数量 
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value="/articlesList", method = RequestMethod.GET)
	public  Map findArticleByType(String type,String index,String pageSize) {
		Map<String,Object> result=new HashMap<String, Object>();
		Map<String,Object> param=new HashMap<String, Object>();
		type=ParamUtil.getStr(type, "1");
		index=ParamUtil.getStr(index, "1");
		pageSize=ParamUtil.getStr(pageSize, "10");
		param.put("type", type);
		param.put("index", index);
		param.put("pageSize",pageSize);
		
		PageInfo pageInfo=articlService.getArticleList(param);
		result.put("articlePageInfo",pageInfo );
		return result;
	}
	
	/**
	 * 获取当个文章
	 * @param type 文章类型
	 * @param page 页数
	 * @param pageSize 每页数量 
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value="/article", method = RequestMethod.GET)
	public  Map findArticleById(String articleId) {
		int articleID=Integer.parseInt(articleId);
		Map<String,Object> result=new HashMap<String, Object>();
		
		result=articlService.getArticleByID(articleID);
		
		return result;
	}
	
	
	/**
	 * 获取近期的优秀作品（可以报名）
	 * @param type
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/productionList")
	public  Map productionList(String index,String pageSize) {
		Map<String ,Object> resultMap=new HashMap<String, Object>();
		Map<String ,Object> param=new HashMap<String, Object>();
		index=ParamUtil.getStr(index, "1");
		pageSize=ParamUtil.getStr(pageSize, "6");
		
		param.put("index", index);	
		param.put("pageSize", pageSize);	
		
		PageInfo pageInfo=new PageInfo();
		
		pageInfo=productionService.productioList(param);
		
		resultMap.put("produPageInfo", pageInfo);
		System.out.println(param+"\n"+resultMap);
		
		return resultMap;
	}
	
	
	
	
	
}
