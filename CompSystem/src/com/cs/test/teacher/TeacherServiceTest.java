package com.cs.test.teacher;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.cs.pojo.Budget;
import com.cs.pojo.Competition;
import com.cs.service.teacher.TeacherService;
import com.cs.vo.CompetitionInfoVo;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath*:SpringMVC.xml",
		"classpath*:SpringMybatis.xml" })
public class TeacherServiceTest extends AbstractJUnit4SpringContextTests {
	@Autowired
	private TeacherService teacherService;

	@Test
	public void addOrUpdateComp() {
		CompetitionInfoVo compVo = new CompetitionInfoVo();
		Competition competition = new Competition();
		competition.setComid(44);
		competition.setComname("你说啥赛");
		Budget budget1 = new Budget();
		budget1.setSubject("测试1那个啥赛");
		Budget budget2 = new Budget();
		budget2.setSubject("测试2那个啥赛");
		List<Budget> buList = new ArrayList<Budget>();
		buList.add(budget1);
		buList.add(budget2);
		compVo.setCompetition(competition);
		compVo.setBudgets(buList);
		teacherService.addOrUpdateComp(compVo);
	}
	
	@Test
	public void updateComp() {
		CompetitionInfoVo compVo = new CompetitionInfoVo();
		Competition competition = new Competition();
		competition.setComname("那个啥赛改一下");
		competition.setComid(4);
		Budget budget1 = new Budget();
		budget1.setSubject("那个啥赛的预算");
		budget1.setBudgetid(10);
		Budget budget2 = new Budget();
		budget2.setSubject("测试2那个啥赛的预算");
		budget2.setBudgetid(11);
		List<Budget> buList = new ArrayList<Budget>();
		buList.add(budget1);
		buList.add(budget2);
		compVo.setCompetition(competition);
		compVo.setBudgets(buList);
		teacherService.updateComp(compVo);
	}
	
	
	@Test
	public void updateCompStatusByDept() {
		Competition competition=new Competition();
		competition.setComid(1);
		competition.setUopinion("我就是不同意");
		competition.setDsdate(new Date());
		competition.setDepspstatus(0);
		teacherService.updateCompStatusByDept(competition);
	}
}
