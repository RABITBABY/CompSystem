package com.cs.pojo;

public class Administer {
    private String adminno;

    private String password;

    private String adminname;

    private Integer departmentid;

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

    public Integer getDepartmentid() {
        return departmentid;
    }

    public void setDepartmentid(Integer departmentid) {
        this.departmentid = departmentid;
    }
}