package com.cs.service.groups;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cs.dao.group.GroupsMapper;
import com.cs.pojo.Groups;
@Service("groupsService")
public class GroupsServiceImpl implements GroupsService{
	@Autowired
	private GroupsMapper groupsMapper;
	@Override
	public List<Groups> getCompGroups(Integer comId) {
		return groupsMapper.selectByComId(comId);
	}
	@Override
	public void outGroups(Integer id) {
		// TODO Auto-generated method stub
		groupsMapper.deleteByid(id);
	}
	@Override
	public void createGroups(Groups groups) {
		//synchronized (groupsMapper) {
			int gNo = groupsMapper.selectMaxGroupsNo();
			groups.setGroupsno(gNo+1);
			groups.setCaptainstatus(1);
			groups.setStatus(0);
			groups.setIscaptain(1);
			groupsMapper.insert(groups);
		//}
	}

}
