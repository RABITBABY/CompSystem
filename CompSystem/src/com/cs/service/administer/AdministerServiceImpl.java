package com.cs.service.administer;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cs.dao.admin.AdministerMapper;
import com.cs.dao.article.ArticleMapper;
import com.cs.dao.awards.AwardsMapper;
import com.cs.dao.competition.CompetitionMapper;
import com.cs.dao.fileUpload.FileUploadMapper;
import com.cs.dao.production.ProductionMapper;
import com.cs.pojo.Administer;
import com.cs.pojo.Competition;
import com.cs.pojo.FileUpload;
import com.cs.pojo.Production;
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
	
	@Autowired
	private AwardsMapper awardsMapper;
	
	@Autowired
	private ProductionMapper productionMapper;
	
	
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
	 * 获取最近的竞赛活动
	 */
	@Override
	public PageInfo CompetitionList(Map map) {
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

	

	
public static void main(String[] args) {
	int totalPage=(int) Math.ceil(3/(2*1.0));
	System.out.println(totalPage);
}

/**
 * 根据id找文件
 */
@Override
public FileUpload getFile(int fileId) {
	FileUpload file=fileMapper.selectByPrimaryKey(fileId);
	return file;
}
}
