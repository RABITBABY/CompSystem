package com.cs.test.teacher;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.cs.dao.budget.BudgetMapper;
import com.cs.dao.teacher.TeacherMapper;
import com.cs.pojo.Budget;
import com.cs.pojo.Teacher;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath*:SpringMVC.xml","classpath*:SpringMybatis.xml"})
public class TeacherDaoTest extends AbstractJUnit4SpringContextTests{
   @Autowired
   private TeacherMapper teacherMapper;
   @Autowired
   private BudgetMapper budgetMapper;
   @Test
   public void testAddComp(){
	   Budget budget1=new Budget();
	   budget1.setComid(1);
	   budget1.setSubject("测试1");
	   Budget budget2=new Budget();
	   budget2.setComid(1);
	   budget2.setSubject("测试2");
	   List<Budget> buList=new ArrayList<Budget>();
	   buList.add(budget1);
	   buList.add(budget2);
	   budgetMapper.addCompBudgetBatch(buList);
   }
}
