package com.cs.test.student;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.cs.pojo.Student;
import com.cs.service.student.StudentService;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath*:SpringMVC.xml",
		"classpath*:SpringMybatis.xml"})
public class TestStudentService extends AbstractJUnit4SpringContextTests {
    @Autowired
	private StudentService studentService;
	@Test
	public void testJoinGroup(){
		studentService.joinGroup(1, 7);
	}
	
}
