package com.cs.pojo;

public class Standard {
    private Integer standardid;

    private Integer levelid;

    private String student;

    private String teacher;

    public Integer getStandardid() {
        return standardid;
    }

    public void setStandardid(Integer standardid) {
        this.standardid = standardid;
    }

    public Integer getLevelid() {
        return levelid;
    }

    public void setLevelid(Integer levelid) {
        this.levelid = levelid;
    }

    public String getStudent() {
        return student;
    }

    public void setStudent(String student) {
        this.student = student == null ? null : student.trim();
    }

    public String getTeacher() {
        return teacher;
    }

    public void setTeacher(String teacher) {
        this.teacher = teacher == null ? null : teacher.trim();
    }

	@Override
	public String toString() {
		return "Standard [standardid=" + standardid + ", levelid=" + levelid
				+ ", student=" + student + ", teacher=" + teacher + "]";
	}
    
    
}