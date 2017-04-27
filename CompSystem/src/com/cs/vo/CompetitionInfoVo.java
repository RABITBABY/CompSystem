package com.cs.vo;

import java.util.List;

import com.cs.pojo.Budget;
import com.cs.pojo.CompCondition;
import com.cs.pojo.Competition;
import com.cs.pojo.Conditions;
import com.cs.pojo.GuideTeacher;
import com.cs.pojo.Hours;
import com.cs.pojo.Schedule;
import com.cs.pojo.Teacher;

public class CompetitionInfoVo {
	//申报书基本信息
	private Competition competition;
	//经费预算
	private List<Budget> budgets;
	//竞赛条件
	private List<CompCondition> compConditions;
	//指导老师
	private List<GuideTeacher> guideTeachers;
	//课时预算
	private List<Hours> hours;
	//培训安排
	private List<Schedule> schedules;
	public Competition getCompetition() {
		return competition;
	}
	public void setCompetition(Competition competition) {
		this.competition = competition;
	}
	public List<Budget> getBudgets() {
		return budgets;
	}
	public void setBudgets(List<Budget> budgets) {
		this.budgets = budgets;
	}
	
	public List<CompCondition> getCompConditions() {
		return compConditions;
	}
	public void setCompConditions(List<CompCondition> compConditions) {
		this.compConditions = compConditions;
	}
	public List<GuideTeacher> getGuideTeachers() {
		return guideTeachers;
	}
	public void setGuideTeachers(List<GuideTeacher> guideTeachers) {
		this.guideTeachers = guideTeachers;
	}
	public List<Hours> getHours() {
		return hours;
	}
	public void setHours(List<Hours> hours) {
		this.hours = hours;
	}
	public List<Schedule> getSchedules() {
		return schedules;
	}
	public void setSchedules(List<Schedule> schedules) {
		this.schedules = schedules;
	}
	@Override
	public String toString() {
		return "CompetitionInfoVo [competition=" + competition + ", budgets="
				+ budgets + ", compConditions=" + compConditions
				+ ", guideTeachers=" + guideTeachers + ", hours=" + hours
				+ ", schedules=" + schedules + "]";
	}
	
    
}
