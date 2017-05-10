package com.cs.service.groups;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cs.dao.group.GroupsMapper;
import com.cs.pojo.Groups;
import com.cs.pojo.Student;
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
	@Override
	public List<Map<String, Object>> getGroupsAndMember(Integer comId) {
		List<Map<String,Object>> groupInfoList=new ArrayList<Map<String,Object>>();
		List<Groups> compGroups = getCompGroups(comId);
		for (int i = 0; i < compGroups.size(); i++) {
			Map<String, Object> map=new HashMap<String, Object>();
			List<Student> members = groupsMapper.selectByGroupsNo(compGroups.get(i).getGroupsno());
			map.put("group", compGroups.get(i));
			map.put("members", members);
			groupInfoList.add(map);
		}
		return groupInfoList;
	}


}
