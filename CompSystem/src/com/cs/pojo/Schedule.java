package com.cs.pojo;

import java.util.Date;

import org.springframework.stereotype.Component;
@Component
public class Schedule {
    private Integer scheduleId;

    private Competition competition;

    private Teacher teacher;

    private String content;

    private String position;

    private Date date;

    private Integer hours;

	public Integer getScheduleId() {
		return scheduleId;
	}

	public void setScheduleId(Integer scheduleId) {
		this.scheduleId = scheduleId;
	}

	public Competition getCompetition() {
		return competition;
	}

	public void setCompetition(Competition competition) {
		this.competition = competition;
	}

	public Teacher getTeacher() {
		return teacher;
	}

	public void setTeacher(Teacher teacher) {
		this.teacher = teacher;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Integer getHours() {
		return hours;
	}

	public void setHours(Integer hours) {
		this.hours = hours;
	}

    
}
