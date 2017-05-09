package com.cs.service.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cs.dao.admin.AdministerMapper;
import com.cs.dao.model.ModelMapper;
import com.cs.pojo.Administer;
import com.cs.pojo.Model;
import com.cs.util.PageInfo;

@Service
public class ModelServiceImpl implements ModelService {

	@Autowired
	private ModelMapper mapper;
	@Autowired
	private AdministerMapper adminMapper;
	
	@Override
	public int insertModel(Model model) {
		
		int row=mapper.insertModel(model);
		System.out.println(row);
		return row;
	}

	@Override
	public int updateModel(Model model) {
		int row=mapper.updateModel(model);
		return row;
	}

	@Override
	public int delectModel(int mid) {
		int row=mapper.delectModel(mid);
		return row;
	}

	@Override
	public PageInfo<Map> getAllModel(Map map) {
		List<Map> pageList=new ArrayList<Map>();
		
		int index=Integer.parseInt(map.get("index").toString());
		int pageSize=Integer.parseInt(map.get("pageSize").toString());
		int page=(index-1)*pageSize;
		Map param=new HashMap();
		param.put("page", page);
		param.put("pageSize", pageSize);
		System.out.println("Model参数"+param);
		List<Model> list=mapper.getAllModel(param);
		int totalPage=0;
		if(list.size() > 0){
			int total=mapper.getTotal();
			totalPage=(int) Math.ceil(total/(pageSize*1.0));//总页数
		}
		//根据Model列，找管理员信息
		for (Model model : list) {
			Map map2=new HashMap<String, Object>();
			String adminno=model.getAdminNo();
			Administer admin=adminMapper.selectByID(adminno);
			map2.put("model", model);
			map2.put("admin", admin);
			pageList.add(map2);
		}
		
		PageInfo pageInfo=new PageInfo();
		
		pageInfo.setIndex(index);
		pageInfo.setList(pageList);
		pageInfo.setTotal(totalPage);
		pageInfo.setPageSize(pageSize);
		return pageInfo;
	}
	
	

}
