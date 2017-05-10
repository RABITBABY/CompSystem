package com.cs.service.groups;

import java.util.List;
import java.util.Map;

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
	
	/**
	 * 获取某个竞赛的组以及其组成员
	 * @param comId
	 */
	public List<Map<String,Object>> getGroupsAndMember(Integer comId);

}
