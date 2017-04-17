package com.cs.service.groups;

import java.util.List;

import com.cs.pojo.Groups;

public interface GroupsService {
	
	/**
	 * 根据comId查找该竞赛参与的组别
	 * @return
	 */
	public List<Groups> getCompGroups(Integer comId);

}
