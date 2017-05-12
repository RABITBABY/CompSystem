package com.cs.service.fileUpload;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cs.dao.fileUpload.FileUploadMapper;
import com.cs.pojo.FileUpload;
import com.cs.util.PageInfo;
@Service("fileImpl")
public class FileUploadServiceImpl implements FileUploadService {

	@Autowired
	FileUploadMapper mapper;
	
	@Override
	public int insertFile(FileUpload file) {
		int statue=mapper.insert(file);
		return statue;
	}

	@Override
	public int deleteFile(int fileId) {
		
		return mapper.deleteByPrimaryKey(fileId);
	}

	@Override
	public FileUpload findFileById(int fileId) {
		return mapper.selectByPrimaryKey(fileId);
	}

	@Override
	public PageInfo allFile(Map map) {
		int index=Integer.parseInt(map.get("index").toString());
		int pageSize=Integer.parseInt(map.get("pageSize").toString());
		int page=(index-1)*pageSize;
		Map param=new HashMap<String , Object>();
		param.put("page", page);
		param.put("pageSize", pageSize);
		if(map.get("adminNo")!=null){
			
			param.put("adminNo", map.get("adminNo").toString());
		}
		List<Map> list=mapper.allFile(param);
		int totalPage=0;
		if(list.size()>0){
			int total=mapper.getTotal(param);
			System.out.println("总条数"+total);
			totalPage=(int) Math.ceil(total/(pageSize*1.0));//总页数
		}
		PageInfo pageInfo=new PageInfo();
		pageInfo.setIndex(index);
		pageInfo.setList(list);
		pageInfo.setTotal(totalPage);
		pageInfo.setPageSize(pageSize);
		
		return pageInfo;
	}

	
}
