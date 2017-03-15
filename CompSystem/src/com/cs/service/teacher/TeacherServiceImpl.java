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

	@Override
	public Teacher selectByTeacherNo(Integer teacherNo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean updateByTeacherNo(Teacher teacher) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean saveCompetition(Competition competition) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<Competition> findCompByTeacherNo(Integer teacherNo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Competition findByComId(Integer comId) {
		// TODO Auto-generated method stub
		return null;
	}

}
