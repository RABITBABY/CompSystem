package com.cs.service.article;

import java.util.Map;

import org.springframework.stereotype.Service;

import com.cs.util.PageInfo;
@Service
public interface ArticleService {
	PageInfo getMtypeList(Map<String,Object> map);
}
