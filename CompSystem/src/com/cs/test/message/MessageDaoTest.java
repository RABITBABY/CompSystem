package com.cs.test.message;

import java.util.ArrayList;
import java.util.Date;
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
import com.cs.dao.message.MessageMapper;
import com.cs.pojo.Budget;
import com.cs.pojo.Material;
import com.cs.pojo.Message;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath*:SpringMVC.xml","classpath*:SpringMybatis.xml"})
public class MessageDaoTest extends AbstractJUnit4SpringContextTests{
	   @Autowired
	   private MessageMapper mapper;
	   @Test
	   public void testInsert(){
		   Message me=new Message();
		   me.setIsRead(0);
		   me.setMessage("sss");
		   me.setNo(1);
		   me.setFromNo(2);
		   me.setSendDate(new Date());
		   mapper.insertMessage(me);
	   }
	   
}
