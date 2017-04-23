package com.cs.service.competition;

import java.util.Map;

import org.springframework.stereotype.Service;

import com.cs.util.PageInfo;

@Service
public interface CompetitionService {
	PageInfo CompetitionList(Map map);

}
