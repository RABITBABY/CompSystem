package com.cs.test.budget;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.cs.dao.budget.BudgetMapper;
import com.cs.pojo.Budget;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath*:SpringMVC.xml","classpath*:SpringMybatis.xml"})
public class BudgetDaoTest extends AbstractJUnit4SpringContextTests{
	   @Autowired
	   private BudgetMapper budgetMapper;
	   @Test
	   public void testdeleteBudgetBycomid(){
		   budgetMapper.deleteByComId(4);
	   }
	   
	   @Test
	   public void testSelect(){
		   List<Budget> selectByComId = budgetMapper.selectByComId(1);
		   System.out.println(selectByComId.get(0).getSubject());
	   }
	   @Test
	   public void batchInsert(){
		   List<Budget> buList =new ArrayList<Budget>();
		   Budget budget=new Budget();
		   budget.setComid(1);
		   budget.setSubject("车费");
		   budget.setSum(300);
		   buList.add(budget);
		   budgetMapper.addCompBudgetBatch(buList);
	   }
}
