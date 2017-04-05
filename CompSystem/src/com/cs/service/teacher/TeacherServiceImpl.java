package com.cs.service.teacher;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cs.dao.budget.BudgetMapper;
import com.cs.dao.compcondition.CompConditionMapper;
import com.cs.dao.competition.CompetitionMapper;
import com.cs.dao.group.GroupsMapper;
import com.cs.dao.guideteacher.GuideTeacherMapper;
import com.cs.dao.hour.HoursMapper;
import com.cs.dao.schedule.ScheduleMapper;
import com.cs.dao.teacher.TeacherMapper;
import com.cs.pojo.Budget;
import com.cs.pojo.Competition;
import com.cs.pojo.Conditions;
import com.cs.pojo.Groups;
import com.cs.pojo.Hours;
import com.cs.pojo.Schedule;
import com.cs.pojo.Student;
import com.cs.pojo.Teacher;

@Service("teacherService")
public class TeacherServiceImpl implements TeacherService{

	@Autowired
	private TeacherMapper teacherMapper;
	@Autowired
	private CompetitionMapper comMapper;
	@Autowired
	private GroupsMapper groupsMapper;
	@Autowired
	private BudgetMapper budgetMapper;
	@Autowired
	private ScheduleMapper scheduleMapper;
	@Autowired
	private HoursMapper hoursMapper;
	@Autowired
	private GuideTeacherMapper guideTeacherMapper;
	@Autowired
	private CompConditionMapper compConditionMapper;
	
	@Override
	public Teacher selectByTeacherNo(Integer teacherNo) {
		return teacherMapper.selectByPrimaryKey(teacherNo);
	}
	
	@Override
	public boolean deleteComp(Integer comId) {
		int count = comMapper.deleteByPrimaryKey(comId);
		if (count>0) {
			return true;
		}
		return false;
	}

	@Override
	public List<Competition> getCompResults(Integer teacherNo) {
		return comMapper.selectByTeacherno(teacherNo);
	}
	
	@Override
	public List<Groups> getCompGroups(Integer comId) {
		return groupsMapper.selectByComId(comId);
	}

	@Override
	public boolean updateByTeacherNo(Teacher teacher) {
		int updateByPrimaryKey = teacherMapper.updateByPrimaryKey(teacher);
		if (updateByPrimaryKey>0) {
			return true;
		}
		return false;
	}

	@Override
	public List<Competition> getCompBySpStatus(Competition competition) {
		
		return comMapper.selectBySpStatus(competition);
	}

	@Override
	public Map<String,Object> getCompDetail(Integer comId) {
		//根据comId查找基本信息
		Competition competition = comMapper.selectByPrimaryKey(comId);
		List<Budget> budgets=budgetMapper.selectByComId(comId);
		List<Schedule> schedules=scheduleMapper.selectByComId(comId);
		List<Hours> hours = hoursMapper.selectByComId(comId);
		List<Teacher> teachers = guideTeacherMapper.selectComId(comId);
		List<Conditions> conditions = compConditionMapper.selectComId(comId);
		Map<String,Object> map=new HashMap<String, Object>();
		map.put("competition", competition);
		map.put("budgets", budgets);
		map.put("schedules", schedules);
		map.put("hours", hours);
		map.put("teachers", teachers);
		map.put("conditions", conditions);
		return map;
	}

	@Override
	public List<Student> getGroupsMember(Integer groupsNo) {
		
		return groupsMapper.selectByGroupsNo(groupsNo);
	}

	@Override
	public boolean approveGroups(Groups groups) {
		int updateStatus = groupsMapper.updateStatus(groups);
		if (updateStatus>0) {
			return true;
		}
		return false;
	}

	@Override
	public List<Competition> getEndCompetition(Integer teacherNo) {
		
		return comMapper.selectEndComp(teacherNo);
	}


	
	

}
