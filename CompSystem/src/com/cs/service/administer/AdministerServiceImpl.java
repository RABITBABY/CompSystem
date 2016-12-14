package com.cs.service.administer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cs.dao.admin.AdministerMapper;
import com.cs.pojo.Administer;
@Service
public class AdministerServiceImpl implements AdministerService{

	@Autowired
	AdministerMapper adminMap;
	
	@Override
	public Administer IsAdmin(String adminNo) {
		
		
		return null;
	}

}
