package com.cs.service.teacher;

import java.util.ArrayList;
import java.util.List;

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
	public Competition getCompDetail(Integer comId) {
		//根据comId查找基本信息
		Competition competition = comMapper.selectByPrimaryKey(comId);
		competition.setBudgets(budgetMapper.selectByComId(comId));
		competition.setSchedules(scheduleMapper.selectByComId(comId));
		competition.setHours(hoursMapper.selectByComId(comId));
		competition.setTeachers(guideTeacherMapper.selectComId(comId));
		competition.setConditions(compConditionMapper.selectComId(comId));
		return competition;
	}


	
	

}
