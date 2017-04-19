package com.cs.test.groups;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.cs.pojo.Groups;
import com.cs.pojo.Student;
import com.cs.service.groups.GroupsService;
import com.cs.service.student.StudentService;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath*:SpringMVC.xml",
		"classpath*:SpringMybatis.xml"})
public class TestGroupsService extends AbstractJUnit4SpringContextTests {
    @Autowired
	private GroupsService groupsService;
	@Test
	public void testcreateGroups(){
		Groups groups=new Groups();
		groups.setComid(1);
		groups.setGroupsname("无敌空虚队");
		groups.setStudentno(8);
		groups.setTeacherno(1);
		groupsService.createGroups(groups);
	}
	
	
	
}
