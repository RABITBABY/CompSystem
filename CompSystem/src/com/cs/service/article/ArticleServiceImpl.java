package com.cs.service.article;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.cs.dao.article.ArticleMapper;
import com.cs.dao.awards.AwardsMapper;
import com.cs.dao.competition.CompetitionMapper;
import com.cs.pojo.Article;
import com.cs.util.PageInfo;
import com.cs.util.ParamUtil;

@Service
public class ArticleServiceImpl implements ArticleService {
	@Autowired
	private ArticleMapper articleMapper;
	@Autowired
	private CompetitionMapper competitionMapper;
	@Autowired
	private AwardsMapper awardsMapper;


	/**
	 * 获取文章列表分页
	 */
	@Override
	public PageInfo getArticleList(Map map) {
		System.out.println("参数"+map);
		int index=Integer.parseInt(map.get("index").toString());
		int pageSize=Integer.parseInt(map.get("pageSize").toString());
		int page=(index-1)*pageSize;
		String type=map.get("type").toString();
		Map param=new HashMap();
		param.put("page", page);
		param.put("pageSize", pageSize);
		param.put("type", type);
		
		List<Map> list=articleMapper.getMtypeList(param);
		
		int total=articleMapper.getTotal(type);
		
		int totalPage=(int) Math.ceil(total/(pageSize*1.0));//总页数
		PageInfo pageInfo=new PageInfo();
		pageInfo.setIndex(index);
		pageInfo.setList(list);
		pageInfo.setTotal(totalPage);
		pageInfo.setPageSize(pageSize);
		return pageInfo;
	}



/**
 * 获取单篇文章
 */
	@Override
	public Map getArticleByID(int articleID) {
		Map result=null;
		if(articleID!=0 ){
			result=articleMapper.findById(articleID);
			if(result!=null && result.size()>0){
				Date date=(Date)result.get("pubDate");
				String dateStr=ParamUtil.DateString(date);
				result.put("pubDate", dateStr);
			}
			
		}
		return result;
	}


/**
 * 发布文章
 */
@Override
public int insertArticle(Article article) {
	int stateCode=0;
	Map param=new HashMap<String , Object>();
	//插入数据库
	int type=article.getArticletype();
	int rID=article.getRelationId();
	param.put("rID", rID);
	param.put("isPub", "1");
	int state=0;
	if(type==1){
		 state=competitionMapper.updatePubState(param);
		
	}else if(type==2){
		state=awardsMapper.updatePubState(param);
	}
	if(state>0)
		stateCode=  articleMapper.insertArticle(article);
	
	//修改文章的状态
	return stateCode;
}


/**
 * 删除文章
 */
@Override
public int deleteArticle(int articleId, int rid,int type) {
	int stateCode=0;
	Map param=new HashMap<String, Object>();
	//删除
	int state=articleMapper.deleteArticle(articleId);
	param.put("rID", rid);
	param.put("isPub", 0);
	System.out.println(param);
	//修改状态
	if(state>0){
		if(type==1){
			stateCode=competitionMapper.updatePubState(param);
		}else if(type==2){
			stateCode=awardsMapper.updatePubState(param);
		}
	}
	return stateCode;
}


/**
 * 修改文章
 */
@Override
public int updateArticle(int articleId, String title, String content) {
	int StateCode=0;
	Map param= new HashMap<String ,Object>();
	param.put("articleId", articleId);
	param.put("title", title);
	param.put("content", content);
	StateCode=articleMapper.updateArticle(param);
	return StateCode;
}

}
