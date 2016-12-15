package com.cs.pojo;

import org.springframework.stereotype.Component;

@Component
public class Administer {
    private String adminNo;

    private String password;

    private String adminName;

    private Department department;

    public String getAdminNo() {
        return adminNo;
    }

    public void setAdminNo(String adminno) {
        this.adminNo = adminno == null ? null : adminno.trim();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    public String getAdminName() {
        return adminName;
    }

    public void setAdminName(String adminname) {
        this.adminName = adminname == null ? null : adminname.trim();
    }

	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

	@Override
	public String toString() {
		return "Administer [adminNo=" + adminNo + ", password=" + password
				+ ", adminName=" + adminName + ", department=" + department
				+ "]";
	}

 
}