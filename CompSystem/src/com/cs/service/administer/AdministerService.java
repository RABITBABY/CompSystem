package com.cs.service.administer;

import org.springframework.stereotype.Service;

import com.cs.pojo.Administer;
@Service
public interface AdministerService {

	public Administer selectByID(String adminNo);
	
}

