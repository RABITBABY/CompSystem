package com.cs.pojo;

import java.util.Date;

public class Schedule {
    private Integer comId;

    private Integer teacherNo;

    private String content;

    private String position;

    private Date date;

    private Integer hours;

	public Integer getComId() {
		return comId;
	}

	public void setComId(Integer comId) {
		this.comId = comId;
	}

	public Integer getTeacherNo() {
		return teacherNo;
	}

	public void setTeacherNo(Integer teacherNo) {
		this.teacherNo = teacherNo;
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