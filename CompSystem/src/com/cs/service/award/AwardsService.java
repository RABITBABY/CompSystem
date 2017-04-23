package com.cs.service.award;

import java.util.Map;

import org.springframework.stereotype.Service;

import com.cs.util.PageInfo;
@Service
public interface AwardsService {
	PageInfo getAwardsList(Map map);
}
