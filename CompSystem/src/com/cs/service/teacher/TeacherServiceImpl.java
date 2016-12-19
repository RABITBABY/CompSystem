package com.cs.service.teacher;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cs.dao.budget.BudgetMapper;
import com.cs.dao.competition.CompetitionMapper;
import com.cs.dao.hour.HoursMapper;
import com.cs.dao.schedule.ScheduleMapper;
import com.cs.dao.teacher.TeacherMapper;
import com.cs.pojo.Budget;
import com.cs.pojo.Competition;
import com.cs.pojo.Hours;
import com.cs.pojo.Schedule;
import com.cs.pojo.Student;
import com.cs.pojo.Teacher;

@Service("teacherService")
public class TeacherServiceImpl implements TeacherService{

	@Autowired
	private TeacherMapper teacherMapper;
	@Autowired
	private CompetitionMapper compMapper;
	@Autowired
	private BudgetMapper budgetMapper;
	@Autowired
	private ScheduleMapper scheduleMapper;
	@Autowired
	private HoursMapper hoursMapper;


	@Override
	public Teacher selectByTeacherNo(Integer teacherNo) {
		Teacher findTeacher = teacherMapper.selectByTeacherNo(teacherNo);
		return findTeacher;
	}

	@Override
	public boolean updateByTeacherNo(Teacher teacher) {
		return teacherMapper.updateByTeacherNo(teacher);
	}

	@Override
	@Transactional
	public boolean saveCompetition(Competition competition) {
		//保存申报表
		int result = compMapper.addCompetition(competition);
		//保存competition.指导老师列表
		List<Teacher> guideTeachers = competition.getGuideTeachers();
		int gtResult=0;
		for (Teacher teacher : guideTeachers) {
			gtResult=teacherMapper.addGuideTeacher(teacher.getTeacherNo(),competition.getComId());
		}
		//保存competition.groups.groupsdetail:这部分。不做。后期根据学生报名自动补上。		
		//保存competition.schedual
		List<Schedule> schedules=competition.getSchedules();
		for (Schedule schedule : schedules) {
			schedule.setComId(competition.getComId());
		}
		int sResult=scheduleMapper.addScheduleBatch(schedules);
		//保存competition.budgets
		List<Budget> budgets=competition.getBudgets();
		for (Budget budget : budgets) {
			budget.setComId(competition.getComId());
		}	
		int bresult=budgetMapper.addBudgetBatch(budgets);
		//保存competition.hours
		List<Hours> hours=competition.getHours();
		for (Hours hours2 : hours) {
			hours2.setComId(competition.getComId());
		}
		int hResult = hoursMapper.addHoursBatch(hours);
		
		if (result>0&&bresult>0&&gtResult>0&&sResult>0&&hResult>0) {
			return true;
		}
		return false;
	}

	@Override
	public List<Competition> findCompByTeacherNo(Integer teacherNo) {
		return compMapper.selectByTeacherNo(teacherNo);
	}

	@Override
	public Competition findByComId(Integer comId) {
		return compMapper.selectALlByComId(comId);
	}

}
