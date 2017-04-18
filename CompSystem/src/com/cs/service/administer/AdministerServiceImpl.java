package com.cs.service.administer;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cs.dao.admin.AdministerMapper;
import com.cs.dao.article.ArticleMapper;
import com.cs.dao.competition.CompetitionMapper;
import com.cs.dao.fileUpload.FileUploadMapper;
import com.cs.pojo.Administer;
import com.cs.pojo.Competition;
import com.cs.pojo.FileUpload;
import com.cs.util.PageInfo;
@Service
public class AdministerServiceImpl implements AdministerService{

	@Autowired
	private AdministerMapper adminMapper;
	
	@Autowired
	private ArticleMapper articleMapper;
	
	@Autowired
	FileUploadMapper fileMapper;
	
	@Autowired
	CompetitionMapper compeMapper;
	/**
	 * 上传文件
	 */
	@Override
	public int insertFile(FileUpload file) {
		int statue=fileMapper.insert(file);
		return statue;
	}
	/**
	 * 获取管理员信息
	 */
	@Override
	public Administer selectByID(String adminNo) {
		Administer admin=adminMapper.selectByID(adminNo);
		return admin;
	}

	
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
		return pageInfo;
	}
	
	
	/**
	 * 获取最近的竞赛活动
	 */
	@Override
	public PageInfo CompetitionList(Map map) {
		
		List<Map<String,Object>> list=compeMapper.selectByAdmin(map);
		
		int total=compeMapper.getTotal();
		int pageSize=Integer.parseInt((String)map.get("pageSize"));
		int totalPage=(int) Math.ceil(total/(pageSize*1.0));//总页数
		PageInfo pageInfo=new PageInfo();
		pageInfo.setList(list);
		pageInfo.setTotal(totalPage);
		pageInfo.setPageSize(pageSize);
		pageInfo.setIndex(Integer.parseInt((String)map.get("index")));
		return pageInfo;
	}

public static void main(String[] args) {
	int totalPage=(int) Math.ceil(3/(2*1.0));
	System.out.println(totalPage);
}
}
