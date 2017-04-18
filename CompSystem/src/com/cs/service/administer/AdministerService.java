package com.cs.service.administer;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.cs.pojo.Administer;
import com.cs.pojo.Competition;
import com.cs.pojo.FileUpload;
import com.cs.util.PageInfo;
@Service
public interface AdministerService {

	public Administer selectByID(String adminNo);
	
	PageInfo getArticleList(Map map);
	
	int insertFile(FileUpload file);
	
	PageInfo CompetitionList(Map map);
}

