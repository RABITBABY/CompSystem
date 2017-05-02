package com.cs.test.material;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.cs.dao.budget.BudgetMapper;
import com.cs.dao.material.MaterialMapper;
import com.cs.pojo.Budget;
import com.cs.pojo.Material;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath*:SpringMVC.xml","classpath*:SpringMybatis.xml"})
public class MaterialDaoTest extends AbstractJUnit4SpringContextTests{
	   @Autowired
	   private MaterialMapper mapper;
	   @Test
	   public void testUpdate(){
		   Material material=new Material();
		   material.setMaterialpic("bb.jsp");
		   material.setMaterialid(1);
		   mapper.updateByPrimaryKey(material);
	   }
	   
}
