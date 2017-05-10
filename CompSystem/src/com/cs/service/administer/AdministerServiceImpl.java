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
import com.cs.dao.material.MaterialMapper;
import com.cs.dao.production.ProductionMapper;
import com.cs.dao.teacher.TeacherMapper;
import com.cs.pojo.Administer;
import com.cs.pojo.Competition;
import com.cs.pojo.FileUpload;
import com.cs.pojo.Material;
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
	
	@Autowired
	private MaterialMapper materialMapper;
	
	
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
@Override
public PageInfo allMaterial(Map map) {
	int index=Integer.parseInt(map.get("index").toString());
	int pageSize=Integer.parseInt(map.get("pageSize").toString());
	int page=(index-1)*pageSize;
	String adminNo=map.get("adminNo").toString();
	String department=adminMapper.getDepartment(adminNo);
	PageInfo pageInfo=new PageInfo();
	
	if(department!=null && !"".equals(department)){
		Map param=new HashMap<String , Object>();
		param.put("page", page);
		param.put("pageSize", pageSize);
		param.put("department", department);
		System.out.println("allMaterialService参数:"+param);
		List<Map> list =materialMapper.allMaterial(param);
		int totalPage=0;
		if(list.size()>0){
			int total=materialMapper.MaterialCount();
			totalPage=(int) Math.ceil(total/(pageSize*1.0));//总页数
		}
		
		pageInfo.setIndex(index);
		pageInfo.setList(list);
		pageInfo.setTotal(totalPage);
		pageInfo.setPageSize(pageSize);
	}
	
	
	return pageInfo;
}
@Override
public int updateMaterialState(int id,int state) {
	Map param=new HashMap<String,Object>();
	param.put("id", id);
	param.put("state", state);
	int stateCode =materialMapper.updateState(param);
	return stateCode;
}
}
