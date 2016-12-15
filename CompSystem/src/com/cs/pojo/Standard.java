package com.cs.pojo;

import org.springframework.stereotype.Component;

@Component
public class Standard {
    private Integer standardId;

    private Level level;

    private Prize prize;

    private Integer student;//学生标准

    private Integer teacher;//教师标准

	public Integer getStandardId() {
		return standardId;
	}

	public void setStandardId(Integer standardId) {
		this.standardId = standardId;
	}


	public void setLevel(Level level) {
		this.level = level;
	}

	public Prize getPrize() {
		return prize;
	}

	public void setPrize(Prize prize) {
		this.prize = prize;
	}

	public Integer getStudent() {
		return student;
	}

	public void setStudent(Integer student) {
		this.student = student;
	}

	public Integer getTeacher() {
		return teacher;
	}

	public void setTeacher(Integer teacher) {
		this.teacher = teacher;
	}

	public Level getLevel() {
		return level;
	}

	@Override
	public String toString() {
		return "Standard [standardId=" + standardId + ", level=" + level
				+ ", prize=" + prize + ", student=" + student + ", teacher="
				+ teacher + "]";
	}
	
	
}
