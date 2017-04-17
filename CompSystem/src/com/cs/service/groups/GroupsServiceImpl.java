package com.cs.service.groups;

import java.util.List;

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

}
