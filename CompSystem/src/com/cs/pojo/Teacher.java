package com.cs.pojo;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

public class Teacher {
    private Integer teacherno;

    private String teachername;

    private String gender;
    
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date birth;

    private String department;

    private String subject;

    private String phone;

    private String title;

    private String post;

    private String email;

    private String type;

    private String direction;

    private String education;

    private String lab;

    private String password;

    private Integer examiner;

    public Integer getTeacherno() {
        return teacherno;
    }

    public void setTeacherno(Integer teacherno) {
        this.teacherno = teacherno;
    }

    public String getTeachername() {
        return teachername;
    }

    public void setTeachername(String teachername) {
        this.teachername = teachername == null ? null : teachername.trim();
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender == null ? null : gender.trim();
    }

    public Date getBirth() {
        return birth;
    }

    public void setBirth(Date birth) {
        this.birth = birth;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department == null ? null : department.trim();
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject == null ? null : subject.trim();
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone == null ? null : phone.trim();
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    public String getPost() {
        return post;
    }

    public void setPost(String post) {
        this.post = post == null ? null : post.trim();
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type == null ? null : type.trim();
    }

    public String getDirection() {
        return direction;
    }

    public void setDirection(String direction) {
        this.direction = direction == null ? null : direction.trim();
    }

    public String getEducation() {
        return education;
    }

    public void setEducation(String education) {
        this.education = education == null ? null : education.trim();
    }

    public String getLab() {
        return lab;
    }

    public void setLab(String lab) {
        this.lab = lab == null ? null : lab.trim();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    public Integer getExaminer() {
        return examiner;
    }

    public void setExaminer(Integer examiner) {
        this.examiner = examiner;
    }

	@Override
	public String toString() {
		return "Teacher [teacherno=" + teacherno + ", teachername="
				+ teachername + ", gender=" + gender + ", birth=" + birth
				+ ", department=" + department + ", subject=" + subject
				+ ", phone=" + phone + ", title=" + title + ", post=" + post
				+ ", email=" + email + ", type=" + type + ", direction="
				+ direction + ", education=" + education + ", lab=" + lab
				+ ", password=" + password + ", examiner=" + examiner + "]";
	}
    
    
}