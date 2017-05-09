package com.cs.service.article;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cs.dao.article.ArticleMapper;
import com.cs.dao.awards.AwardsMapper;
import com.cs.dao.compcondition.CompConditionMapper;
import com.cs.dao.competition.CompetitionMapper;
import com.cs.dao.guideteacher.GuideTeacherMapper;
import com.cs.dao.schedule.ScheduleMapper;
import com.cs.pojo.Article;
import com.cs.pojo.Competition;
import com.cs.pojo.Conditions;
import com.cs.pojo.Schedule;
import com.cs.pojo.Teacher;
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

	@Autowired
	private CompConditionMapper coMapper;
	@Autowired
	private GuideTeacherMapper gTeacherMapper;
	@Autowired
	private ScheduleMapper scheduleMapper;
	
	/**
	 * 获取文章列表分页
	 */
	@Override
	public PageInfo getArticleList(Map map) {
		
		int index=Integer.parseInt(map.get("index").toString());
		int pageSize=Integer.parseInt(map.get("pageSize").toString());
		int page=(index-1)*pageSize;
		String type=map.get("type").toString();
		Map param=new HashMap();
		param.put("page", page);
		param.put("pageSize", pageSize);
		param.put("type", type);
		param.put("adminNo",map.get("adminNo").toString() );
		System.out.println("参数"+param);
		List<Map> list=articleMapper.getMtypeList(param);
		System.out.println(type+"++++");
		int totalPage=0;
		if(list.size() > 0){
			int total=articleMapper.getTotal(type);
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
	 * 首页获取文章列表分页
	 */
	@Override
	public PageInfo indexArticleList(Map map) {
		
		int index=Integer.parseInt(map.get("index").toString());
		int pageSize=Integer.parseInt(map.get("pageSize").toString());
		int page=(index-1)*pageSize;
		String type=map.get("type").toString();
		Map param=new HashMap();
		param.put("page", page);
		param.put("pageSize", pageSize);
		param.put("type", type);
		
		System.out.println("参数"+param);
		List<Map> list=articleMapper.getIndexList(param);
		System.out.println(type+"++++");
		int totalPage=0;
		if(list.size() > 0){
			int total=articleMapper.getTotal(type);
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
	 * 获取文章列表分页
	 */
	@Override
	public PageInfo searchArticle(Map map) {
		System.out.println("参数"+map);
		int index=Integer.parseInt(map.get("index").toString());
		int pageSize=Integer.parseInt(map.get("pageSize").toString());
		int page=(index-1)*pageSize;
		String type=map.get("type").toString();
		String searchInput="%"+map.get("searchInput").toString()+"%";
		
		Map param=new HashMap();
		param.put("page", page);
		param.put("pageSize", pageSize);
		param.put("type", type);
		param.put("searchInput" , searchInput);
		System.out.println("参数"+param);
		List<Map> list=articleMapper.searchArticle(param);
		
		int total=articleMapper.searchTotal(param);
		
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
@Override
public void addVisit(int id) {
	 articleMapper.addVisit(id);
}
@Override
public String initArticleDetail(String comId) {
	// TODO Auto-generated method stub
	int id=Integer.parseInt(comId);
	StringBuffer articleDetail=new StringBuffer();
	List<Conditions> conditions=new ArrayList<Conditions>();
	List<Map> schedule=new ArrayList<Map>();
	List<Teacher> guideTeacher=new ArrayList<Teacher>();
	Competition competition=new Competition();
	
	//竞赛基本信息competition
	competition=competitionMapper.selectByPrimaryKey(id);
	//竞赛条件compCondition
	conditions= coMapper.selectComId(id);
	//指导老师guideTeacher
	guideTeacher=gTeacherMapper.selectComId(id);
	//培训安排schedule
	schedule=scheduleMapper.scheduleList(id);
	System.out.println(schedule);
	
	articleDetail.append("\n竞赛基本信息：\n");
	//拼接信息
	articleDetail.append("\n竞赛名称：");
	articleDetail.append("\n竞赛负责人：");
	articleDetail.append("\n竞赛负责人：");
	
	articleDetail.append("\n竞赛条件：\n");
	for (Conditions c : conditions) {
		articleDetail.append(c.getConditionname()+"\t");
	}
	articleDetail.append("\n竞赛指导老师：\n");
	for (Teacher teacher : guideTeacher) {
		articleDetail.append(teacher.getTeachername()+"\t ");
	}
	articleDetail.append("\n竞赛培训安排：(培训内容 、培训地点、培训时间、培训负责老师、学时)\n");
	for (Map s : schedule) {
		articleDetail.append(s.get("content")+"\t"+s.get("position")+"\t"+s.get("date")+"\t"+s.get("teacherName")+"\t"+s.get("hour"));
	}
	System.out.println(articleDetail);
	return articleDetail.toString();
}
@Override
public List getHotArticle() {
	
	return articleMapper.hotArticle();
}

}
