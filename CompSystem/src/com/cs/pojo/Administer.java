package com.cs.pojo;

public class Administer {
    private String adminno;

    private String password;

    private String adminname;

    private String department;

    public String getAdminno() {
        return adminno;
    }

    public void setAdminno(String adminno) {
        this.adminno = adminno == null ? null : adminno.trim();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    public String getAdminname() {
        return adminname;
    }

    public void setAdminname(String adminname) {
        this.adminname = adminname == null ? null : adminname.trim();
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department == null ? null : department.trim();
    }

	@Override
	public String toString() {
		return "Administer [adminno=" + adminno + ", password=" + password
				+ ", adminname=" + adminname + ", department=" + department
				+ "]";
	}
    
    
}