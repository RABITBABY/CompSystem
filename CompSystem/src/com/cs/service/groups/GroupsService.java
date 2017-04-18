package com.cs.service.groups;

import java.util.List;

import com.cs.pojo.Groups;

public interface GroupsService {
	
	/**
	 * 根据comId查找该竞赛参与的组别
	 * @return
	 */
	public List<Groups> getCompGroups(Integer comId);
	
	/**
	 * 通过id删除，即退出队伍
	 */
	public void outGroups(Integer id);
	
	/**
	 * 创建队伍
	 * @param groups
	 */
	public void createGroups(Groups groups);

}
