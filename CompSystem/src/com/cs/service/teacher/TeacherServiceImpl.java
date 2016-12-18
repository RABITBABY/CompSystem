package com.cs.service.teacher;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cs.dao.budget.BudgetMapper;
import com.cs.dao.competition.CompetitionMapper;
import com.cs.dao.teacher.TeacherMapper;
import com.cs.pojo.Budget;
import com.cs.pojo.Competition;
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
		int result = compMapper.addCompetition(competition);
		//保存competition.budgets
		List<Budget> budgets=competition.getBudgets();
		for (Budget budget : budgets) {
			budget.setComId(competition.getComId());
		}
		int bresult=budgetMapper.addBudgetBatch(competition.getBudgets());
		
		if (result>0&&bresult>0) {
			return true;
		}
		return false;
	}

}
